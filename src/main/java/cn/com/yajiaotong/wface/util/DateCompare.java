package cn.com.yajiaotong.wface.util;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
/**  
 * @description 日期比较天 月 年  
 * @author www.javawind.net  
 */ 
public class DateCompare {
	
   /* public static void main(String[] args) {  
        String date = "2008-06-12";  
          
        DateCompare.compareDate(date, null, 0);  
        DateCompare.compareDate(date, null, 1);  
        DateCompare.compareDate(date, null, 2);  
          
        date = "2006-06-03";          
        DateCompare.compareDate(date, null, 0);  
        DateCompare.compareDate(date, null, 1);  
        DateCompare.compareDate(date, null, 2);  
        DateCompare.compareDate(date, "2009-06-01", 0);  
        DateCompare.compareDate(date, "2009-06-01", 1);  
        DateCompare.compareDate(date, "2009-06-01", 2);  
    }  */
      
    /**  
     * @param date1 需要比较的时间 不能为空(null),需要正确的日期格式  
     * @param date2 被比较的时间  为空(null)则为当前时间  
     * @param stype 返回值类型   0为多少天，1为多少个月，2为多少年  
     * @return  
     */ 
    public static int compareDate(String date1,String date2,int stype){  
        int n = 0;  
          
        String[] u = {"天","月","年"};  
        String formatStyle = stype==1?"yyyy-MM":"yyyy-MM-dd";  
          
        date2 = date2==null?DateCompare.getCurrentDate():date2;  
          
        DateFormat df = new SimpleDateFormat(formatStyle);  
        Calendar c1 = Calendar.getInstance();  
        Calendar c2 = Calendar.getInstance();  
        try {  
            c1.setTime(df.parse(date1));  
            c2.setTime(df.parse(date2));  
        } catch (Exception e3) {  
            System.out.println("wrong occured");  
        }  
        //List list = new ArrayList();  
        while (!c1.after(c2)) {                     // 循环对比，直到相等，n 就是所要的结果  
            //list.add(df.format(c1.getTime()));    // 这里可以把间隔的日期存到数组中 打印出来  
            n++;  
            if(stype==1){  
                c1.add(Calendar.MONTH, 1);          // 比较月份，月份+1  
            }  
            else{  
                c1.add(Calendar.DATE, 1);           // 比较天数，日期+1  
            }  
        }  
          
        n = n-1;  
          
        if(stype==2){  
            n = (int)n/365;  
        }     
          
        //SSystem.out.println(date1+" -- "+date2+" 相差多少"+u[stype]+":"+n);        
        return n;  
    }  
      
    /**  
     * 得到当前日期  
     * @return  
     */ 
    public static String getCurrentDate() {  
        Calendar c = Calendar.getInstance();  
        Date date = c.getTime();  
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");  
        return simple.format(date);  
    }  
} 