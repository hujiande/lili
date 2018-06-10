package com.example.mianshi.demo.Demo;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Calendar_d {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.YEAR);
        System.out.println(i);
        cal.add(Calendar.DATE,-1);
        long millis = System.currentTimeMillis();
        System.out.println(cal.getTime());

        //java 8
        LocalDateTime dateTime = LocalDateTime.now().minusDays(1);
        System.out.println(dateTime);
    }
}
