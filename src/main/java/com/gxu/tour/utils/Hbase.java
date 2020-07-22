package com.gxu.tour.utils;


import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName Hbase
 * @Description TODO
 * @Author LLM
 * @Date 2019/11/6 16:32
 * @Version 1.0
 **/
public class Hbase {

    static Connection connection=null;

    //获取表
    public static Table getTable(String tableName) throws IOException
    {
        Table table=null;
        try {
            connection= ConnectionFactory.createConnection();
            //获取表
            table=connection.getTable(TableName.valueOf(tableName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }


    //加载测试数据1W条
    public static void InsertDatas() throws IOException
    {
        Random random=new Random();

        //浏览字段
        String[] search={"南宁","郑州","德天","崇左","柳州","梧州","北海"};
        //对应产品id

        //时间




        String tableName="logs";

        for (int i=10011;i<=20000;i++)
        {
            //行键
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            String rowkey=df.format(new Date())+i;
            //时间
            SimpleDateFormat dfone = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String date=dfone.format(new Date());

            Map<String,Object> map=new HashMap<String, Object>();
            map.put("date",date);
            map.put("title",search[random.nextInt(search.length)]);
            map.put("userid",""+(random.nextInt(10000)+100000));
            putData(tableName,rowkey,map);

        }

    }

    //放置数据
    public static void putData(String tableName,String RowKey,Map<String,Object> value) throws IOException {
        Table table=getTable(tableName);

        Put put=new Put(Bytes.toBytes(RowKey));
        for (String key:value.keySet())
        {
            put.addColumn(Bytes.toBytes("info"),
                    Bytes.toBytes(key),
                    Bytes.toBytes(value.get(key).toString()));
        }

        table.put(put);
        table.close();
        connection.close();
    }

    /**
     * 根据日期来查询数据
     * @param tableName
     * @param startKey 开始日期
     * @param endKey  结束日期
     * @return
     * @throws IOException
     */
    public static List<String> scan(String tableName, String startKey, String endKey) throws IOException {
        Table table = getTable(tableName);
        Scan scan = new Scan();
        List<String> logs=new ArrayList<String>();
        // 设置行键的查找范围
        scan.setStartRow(startKey.getBytes());
        scan.setStopRow(endKey.getBytes());
        // 过滤行键
        //RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator("^000c-e797-62fc.*2017-04-16$"));
        //Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new BinaryPrefixComparator("123".getBytes()));
        //scan.setFilter(filter);
        ResultScanner scanner = table.getScanner(scan);
        for (Result r : scanner) {
            for (Cell cell:r.rawCells())
            {
                //只提取用户的行为日志
                if("title".equals(Bytes.toString(CellUtil.cloneQualifier(cell))))
                    logs.add(Bytes.toString(CellUtil.cloneValue(cell)));

            }

        }
        table.close();
        connection.close();
        return logs;
    }

    public static void main(String[] args)
    {
        try {
            System.setProperty("hadoop.home.dir", "F:\\bigdata\\spark\\hadoop-common-2.2.0-bin-master");

            String start="20191106192100";
            String stop="20191106192200";

            List<String> logs=scan("logs",start,stop);
            System.out.println(logs.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
