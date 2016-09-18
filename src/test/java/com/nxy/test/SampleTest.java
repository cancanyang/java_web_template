package com.nxy.test;

import org.junit.Test;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by snailnan on 2016/9/9.
 */
public class SampleTest {
    @Test
    public void test(){
        System.out.println(formatLiveName("123"));
        System.out.println(formatLiveName(""));
        System.out.println(formatLiveName(null));
        System.out.println(formatLiveName("fx_hifi_pg_360.m3u8"));
        System.out.println(formatLiveName("fx_hifi_pg_540"));
        System.out.println(formatLiveName("live.hifi_2016kma_360.m3u8"));
    }
    private String formatLiveName(String livename){
        if (livename == null ){
            return "";
        }else{
            int sep = livename.lastIndexOf(".");
            return sep > -1 ? livename.substring(0,sep):livename;
        }
    }
    @Test
    public void test2(){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.MILLISECOND, 0);
        Date data = new Date(calendar.getTimeInMillis());
        System.out.println(data.getTime());
        CronSequenceGenerator gronSequenceGenerator = new CronSequenceGenerator("0/5 * * * * ?");
        Date data2 = gronSequenceGenerator.next(data);
        System.out.println(data2.getTime());
        Date data3 = gronSequenceGenerator.next(data2);
        System.out.println(data3.getTime());
    }
    @Test
    public void test3() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.MILLISECOND, 0);
        Long time = calendar.getTimeInMillis();
        System.out.println(time);
    }
    @Test
    public void test4(){
        System.out.println(getNextScheduledTime("0/5 * * * * ?"));
        System.out.println(getNextScheduledTime("0 0/1 * * * ?"));
        System.out.println(getNextScheduledTime("0 0/5 * * * ?"));
    }
    public long getNextScheduledTime(String cron){
        CronSequenceGenerator gronSequenceGenerator = new CronSequenceGenerator(cron);
        Date d1 = gronSequenceGenerator.next(new Date());
        Date d2 = gronSequenceGenerator.next(d1);
        long time = d2.getTime()-d1.getTime();
        return time;
    }

    @Test
    public void test5(){
        System.out.println(Math.floor(500/1000));
        System.out.println(Math.floor(5000/1000));
        System.out.println(Math.floor(5010/1000));
        System.out.println(Math.floor(5110/1000));
        System.out.println(Math.floor(5610/1000));
    }
}
