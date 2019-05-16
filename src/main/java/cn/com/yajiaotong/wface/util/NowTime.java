package cn.com.yajiaotong.wface.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTime {
	
	public static Date getNowTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(DateUtil.getCurrentDateTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				 
	}
}
