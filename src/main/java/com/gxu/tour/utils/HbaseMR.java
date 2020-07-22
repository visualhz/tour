package com.gxu.tour.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HbaseMR
 * @Description TODO
 * @Author LLM
 * @Date 2019/11/6 19:37
 * @Version 1.0
 **/
public class HbaseMR extends Configured implements Tool {


    static Map<String,Integer> title=new HashMap<String, Integer>();

    public static class MyMapper extends TableMapper<Text, IntWritable> {
        private   Text mapOutputKey = new Text();
        private   IntWritable mapOutValue=new IntWritable(1);
        public void map(ImmutableBytesWritable rowkey, Result value, Context context)
                throws InterruptedException, IOException {

            for (Cell cell:value.rawCells())
            {

                if("title".equals(Bytes.toString(CellUtil.cloneQualifier(cell)))) {

                    mapOutputKey.set(Bytes.toString(CellUtil.cloneValue(cell)));
                    context.write(mapOutputKey, mapOutValue);
                }
            }

        }
    }

    public static class MyReducer extends TableReducer<Text, IntWritable, ImmutableBytesWritable> {

        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum=0;
            for(IntWritable num:values)
            {
                sum+=num.get();
            }
           title.put(key.toString(),sum);

        }
    }

    @Override
    public int run(String[] args) throws Exception {
        //1) get conf
        Configuration configuration = this.getConf();

        Job job = Job.getInstance(configuration, this.getClass().getSimpleName());
        job.setJarByClass(this.getClass());

        Scan scan = new Scan();

        scan.setStartRow(args[0].getBytes());
        scan.setStopRow(args[1].getBytes());

        scan.setCaching(500);
        scan.setCacheBlocks(false);

        TableMapReduceUtil.initTableMapperJob(
                "logs",        // input table
                scan,               // Scan instance to control CF and attribute selection
                MyMapper.class,     // mapper class
                Text.class,         // mapper output key
                IntWritable.class,  // mapper output value
                job);
        TableMapReduceUtil.initTableReducerJob(
                "logsMR",        // output table
                MyReducer.class,    // reducer class
                job);


        boolean isSuc = job.waitForCompletion(true);
        return (isSuc) ? 0 : 1;
    }

    public static void main(String[] args){

        System.setProperty("hadoop.home.dir", "F:\\bigdata\\spark\\hadoop-common-2.2.0-bin-master");

        String start="20191106192100";
        String end="20191106192200";
        String[] datas={start,end};
        HbaseDataMR(datas);
        for(String value:title.keySet())
        {
            System.out.println(value+"="+title.get(value));
        }
    }

    //hbaseMR分析调用方法
    //其中args[0] 将传递参数start,args[1]将传递stop
    public static void HbaseDataMR(String[] args)
    {

        Configuration configuration = HBaseConfiguration.create();
        try {
            int status = ToolRunner.run(configuration, new HbaseMR(),args);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
