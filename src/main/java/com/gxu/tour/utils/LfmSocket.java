package com.gxu.tour.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName LfmSocket
 * @Description TODO
 * @Author LLM
 * @Date 2019/8/30 9:12
 * @Version 1.0
 **/
public class LfmSocket {

    private static Object remoteCall(String content,int flag){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", content);
        String str = jsonObject.toJSONString();
        System.out.println(str);
        // 访问服务进程的套接字
        Socket socket = null;
        //List<String> questions = new ArrayList<>();
        //log.info("调用远程接口:host=>"+HOST+",port=>"+PORT);
        try {
            // 初始化套接字，设置访问服务的主机和进程端口号，HOST是访问python进程的主机名称，可以是IP地址或者域名，PORT是python进程绑定的端口号
            if(flag==1)
                socket = new Socket("119.23.19.167",12345);
            else if(flag==2)
                socket = new Socket("119.23.19.167",12346);
            // 获取输出流对象
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os);
            // 发送内容
            out.print(str);
            // 告诉服务进程，内容发送完毕，可以开始处理
            out.print("over");
            // 获取服务进程的输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
            String tmp = null;
            StringBuilder sb = new StringBuilder();
            // 读取内容
            while((tmp=br.readLine())!=null)
                sb.append(tmp).append('\n');

            System.out.println(sb);


            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {if(socket!=null) socket.close();} catch (IOException e) {}
            //log.info("远程接口调用结束.");
            System.out.println("OK");
        }
        return null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String userid="103404";



    }

    /**
     *
     * @param
     * @return
     */
    public  static String getPredict(String content,int flag)
    {
//        String predict= (String) remoteCall(content).toString().trim()
//                .replaceAll("\\[","").replaceAll("\\]","");
        String predict=(String) remoteCall(content,flag).toString().trim();
        return predict;
    }

}
