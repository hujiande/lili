package com.example.mianshi.demo.Demo;

public class Chart {
    public static void main(String[] args) throws Exception{
        String str = new String("你好");
        String str3 = "你好";
        String str4 = "你好";
        String str2 = new String( str3.getBytes("GB2312"),"ISO-8859-1");
        String str5 = new String( str2.getBytes("ISO-8859-1"),"GB2312");
        System.out.println(str5);
    }
}
