package cn.com.yajiaotong.wface.util;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class StringUtil {

	private static byte salts[] = new byte[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat deliverTime=new SimpleDateFormat("yyyyMMddHHmm");
	private static Calendar calendar=Calendar.getInstance();

	public static String formateDeliverTime(String date){
		String callback=null;
		Date result=null;
		if(isEmpty(date))return callback;
		try{
			result=deliverTime.parse(String.valueOf(calendar.get(Calendar.YEAR)).substring(0, 2)+date);
		}catch(Exception e){
			try {
				result=dateFormat.parse(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if(result!=null)callback=dateFormat.format(result);
		return callback;
	}
	
	public static String date2String(Date d) {
		if (d == null) {
			return null;
		} else {
			return dateFormat.format(d);
		}
	}

	public static String date2String(Date d, String format) {
		if (d == null) {
			return null;
		} else {
			SimpleDateFormat sdateFormat = new SimpleDateFormat(format);
			return sdateFormat.format(d);
		}
	}

	public static StringBuilder fixArrayIds(Integer ids[]) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ids.length; i++) {
			sb.append(ids[i]).append(",");
		}

		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
			return sb;
		} else {
			return null;
		}

	}

	/**
	 * 日期转换
	 * 
	 * @param val
	 * @return
	 */
	public static Date parseDate(String val) {
		try {
			if (StringUtil.isEmpty(val))
				return null;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(val);
		} catch (Exception ex) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return sdf.parse(val);
			} catch (Exception ex2) {
				return null;
			}
		}
	}
	
	public static boolean checkSendTime(String sendtime)
	{
		try {
			Pattern a=Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
			return a.matcher(sendtime).matches();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
			//e.printStackTrace();
		}
	}

	public static StringBuilder implode(String delimiter, List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; list != null && i < list.size(); i++) {
			sb.append(list.get(i)).append(delimiter);
		}
		int len = sb.length();
		if (len > 0)
			sb.replace(len - delimiter.length(), len, "");
		return sb;
	}
	
	/**
	 * 加入分隔符
	 * @param delimiter
	 * @param list
	 * @return
	 */
	public static StringBuilder implode(String delimiter, String[] strs) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; strs != null && i < strs.length; i++) {
			sb.append(strs[i]).append(delimiter);
		}
		int len = sb.length();
		if (len > 0)
			sb.replace(len - delimiter.length(), len, "");
		return sb;
	}

	public static List<String> toList(String str) {
		List<String> list = new ArrayList<String>();
		if (str == null)
			return list;
		StringTokenizer st = new StringTokenizer(str, ",");
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (!isEmpty(s)) {
				list.add(s);
			}
		}

		return list;

	}

	public static Set<String> toSet(String str) {
		Set<String> set = new HashSet<String>();
		if (str == null)
			return set;
		StringTokenizer st = new StringTokenizer(str, ",");
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (!isEmpty(s)) {
				set.add(s);
			}
		}

		return set;

	}

	/**
	 * 判断是否为空
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isEmpty(String val) {
		if (val == null || (val.trim()).length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static String updateSqlEscape(String s) {
		return s.replace("'", "\\'");
	}

	/**
	 * 替换
	 * 
	 * @param val
	 * @return
	 */
	public static String def(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return def(obj.toString(), "");
		}
	}

	public static String def(String val, String def) {
		if (val == null) {
			return def;
		} else {
			return val;
		}
	}

	public static int def(String val, int def) {
		try {
			return Integer.parseInt(val);
		} catch (Exception ex) {
			return def;
		}
	}

	public static String generateSalt(int size) {
		Random rseed = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append((char) salts[rseed.nextInt(salts.length)]);
		}

		return sb.toString();
	}

	public static String zerofill(long number, int length) {
		String str = String.format("%0" + length + "d", number);
		return str;
	}

	public static String filterHtml(String msg) {
		if (msg == null)
			return null;
		msg = msg.replace("<", "&lt;");
		msg = msg.replace(">", "&gt;");
		return msg;
	}

	public static String hashPassword(String password, String salt) {
		String encodedPwd = null;
		if (salt == null) {
			salt = generateSalt(16);
		}

		encodedPwd = md5(password + salt);

		return encodedPwd;
	}

	public static String md5(String _msg) {

		try {
			StringBuilder digMsg = new StringBuilder();
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bmd = md.digest(_msg.getBytes());

			for (int i = 0; i < bmd.length; i++) {

				int tmp = (int) bmd[i];
				tmp = tmp & 0xFF;
				if (tmp < 0x10)
					digMsg.append("0");

				digMsg.append(Integer.toHexString(tmp));
			}

			return digMsg.toString();
		} catch (Exception e) {
			return null;
		}

	}

	public static byte OP_TYPE_CM = 1;
	public static byte OP_TYPE_UN = 2;
	public static byte OP_TYPE_TC = 3;

	public static byte getOperationType(String number) {
		try {
			number = number.trim();
			number = number.replace("+86", "");

			int flag = Integer.parseInt(number.substring(0, 3));
			if (flag == 134 || flag == 135 || flag == 136 || flag == 137 || flag == 138 || flag == 139 || flag == 147 || flag == 150 || flag == 151 || flag == 152 || flag == 157 || flag == 158 || flag == 159 || flag == 182 || flag == 187 || flag == 188 || flag == 183) {
				return OP_TYPE_CM;
			} else if (flag == 130 || flag == 131 || flag == 132 || flag == 155 || flag == 156 || flag == 185 || flag == 186 || flag == 145) {
				return OP_TYPE_UN;
			} else if (flag == 180 || flag == 189 || flag == 133 || flag == 153) {
				return OP_TYPE_TC;
			} else {
				return -1;
			}

		} catch (Exception ex) {
			return -1;
		}
	}
}
