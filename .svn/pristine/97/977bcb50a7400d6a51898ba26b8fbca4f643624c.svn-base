package cn.com.yajiaotong.wface.util;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JZDynamicFieldUtil {
	private final static NumberFormat moneyFormater=NumberFormat.getInstance();
	
	/**
	 * 金额输出，添加千分位显示.
	 * @param v
	 * @return
	 */
	public String money(double v) {
		return moneyFormater.format(v);
	}
	/**
	 * 金额输出，添加千分位显示.
	 * @param v
	 * @return
	 */
	public String money(String v) {
		if(v==null) return null;
		double dbl=0;
		try {
			dbl=Double.parseDouble(v);
		}
		catch(Exception e) {
			return null;
		}
		return moneyFormater.format(dbl);
	}
	/**
	 * 显示字符串后几位，常用来显示账号后若干位.
	 * @param s 要处理的字符串.
	 * @param n  显示尾部位数.
	 * @return
	 */
	public String tail(String s,int n) {
		if(s==null) return null;
		int len=s.length();	
		if(len<=n) return s;
		else return s.substring(len-n);
	}
	/**
	 * 从字符串尾部数起，隐藏从begin到end的位数，用指定符号，通常是*代替.
	 * 比如从账号后3-6位用*代替，则调用方式为：
	 * hideTail(s,3,6,'*');
	 * @param s
	 * @param begin
	 * @param end
	 * @parm hideC
	 * @return
	 */
	public String hideTail(String s,int begin,int end,String c) {
		if(s==null) return null;
		int len=s.length();
		String ns="";
		int nsLen=end-begin+1;
		for(int i=0;i<nsLen;i++) ns+=c;
		s=s.substring(0,len-end)+ns+s.substring(len-begin+1);
		return s;
	}
	
	/**
	 * 按指定分割符，取某段字符串.
	 * @param str 要处理的字符串.
	 * @param sign 分割符.
	 * @param position 要取字符串的位置：1表示取第一段；-1表示取最后一段；0与其他无效范围按最后一段取值.
	 * 				   <br/>在方法的内部处理逻辑中，使用position-1作为数组角标
	 * @return 处理结果
	 * @since 1.1
	 */
	public String stringSplit(String str,String sign, int position) {
		if(null == str){
			return "";
		}
		
		if(null == sign){
			return str;
		}
		
		try {
			//处理后的分隔符
			String splitSign = "";
			
			//特殊字符转义处理
			for(int i=0;i<sign.length();i++){
				String value = specialSigns.get(String.valueOf(sign.charAt(i)));
				if(null == value){
					splitSign += String.valueOf(sign.charAt(i));
				}
				else {
					splitSign += value;
				}
			}
			
			String[] infos = str.split(splitSign);

			//对边界处理
			if(position<1 || position>infos.length){
				//无效边界，取最后一段
				return infos[infos.length-1];
			}
			else {
				//正常边界
				return infos[position-1];
			}
		}
		catch(Exception e){
			//其他未收录的特殊字符处理时可能会出现异常
			logger.error(e.getMessage()+"\n待处理字符串["+str+"], 分割符["+sign+"], 位置["+position+"]");
		}

		return str;
	}
	/**
	 * 字典翻译.
	 * @param dictName 字典名称.
	 * @param key 数据关键词.
	 * @return 翻译后的结果，如果字典未定义，返回报错信息没找到字典，否则返回字典的value，如果字典中无对应的数据项，返回null.
	 */
	public String trans(String dictName,String key) {
		try {
			return getOuterDictionary().get(dictName).get(key);
		}
		catch(Exception e) {
			return "outer dictionary["+dictName+"] undefined!";
		}
	}
	/**
	 * 外部扩展字典，弥补模板数据内容有限约束。
	 * 其中String的key表示字典名称，对应的map为字典内容.
	 */
	private static Map<String,Map<String,String>> outerDictionary=null;

	public static Map<String, Map<String,String>> getOuterDictionary() {
		return outerDictionary;
	}
	/**
	 * 注入外部字典.
	 * @param outDictionary
	 */
	public void setOuterDictionary(Map<String, Map<String,String>> outerDictionary) {
		JZDynamicFieldUtil.outerDictionary = outerDictionary;
	}
//	/**
//	 * 根据机构代码获得名称.
//	 * @param code
//	 * @return
//	 */
//	public String branchName(String code) {
//		BranchData bd=BranchData.getInstance(code);
//		if(bd!=null) 
//			return bd.getName();
//		logger.error("没找到机构{}对应的名称",code);
//		return "";
//	}
	/**
	 * 将字符串左侧为0的数字删除掉。
	 * @param s
	 * @return
	 */
	public String trimZero(String s) {
		if(s==null) return null;
		int i=0;
		while(i<s.length() && s.charAt(i)=='0') {
			i++;
		}
		if(i<s.length())
			return s.substring(i);
		else
			return "";
	}

	/**
	 * 日志记录
	 * @since 1.1
	 */
	private static Logger logger = LoggerFactory.getLogger(JZDynamicFieldUtil.class);
		
	/**
	 * 特殊字符hash表
	 * @since 1.1
	 */
	private static final Map<String, String> specialSigns = new HashMap<String, String>();

	/**
	 *  @since 1.1
	 */
	static
	{
		/*
		 * 已收录的特殊字符转义处理
		 * 
		 *   如下特殊字符
		 *     $.+|*^?()[]{}
		 *   需要使用\\做转义处理，如\\$。、
		 * 
		 *   如下特殊字符的转义处理如下:
		 *     \n 回车(\\u000a)
		 *     \t 水平制表符(\\u0009)
		 *     \b 空格(\\u0008)
		 *     \r 换行(\\u000d)
		 *     \f 换页(\\u000c)
		 *     \' 单引号(\\u0027)
		 *     \" 双引号(\\u0022)
		 *     \\ 反斜杠(\\u005c)
		*/

		specialSigns.put("$", "\\$");
		specialSigns.put(".", "\\.");
		specialSigns.put("+", "\\+");
		specialSigns.put("|", "\\|");
		specialSigns.put("*", "\\*");
		specialSigns.put("^", "\\^");
		specialSigns.put("?", "\\?");
		specialSigns.put("(", "\\(");
		specialSigns.put(")", "\\)");
		specialSigns.put("[", "\\[");
		specialSigns.put("]", "\\]");
		specialSigns.put("{", "\\{");
		specialSigns.put("}", "\\}");
		
		specialSigns.put("\n", "\\u000a");
		specialSigns.put("\t", "\\u0009");
		specialSigns.put("\b", "\\u0008");
		specialSigns.put("\r", "\\u000d");
		specialSigns.put("\f", "\\u000c");
		specialSigns.put("\'", "\\u0027");
		specialSigns.put("\"", "\\u0022");
		specialSigns.put("\\", "\\u005c");	
	}
	/**
	 * 相对当前日期的日期对比.
	 * @param cdate 格式为yyyyMMdd
	 * @return 返回参数日期减去当天的日期天数值，在当前日期之后的返回正数，之前的返回负数.
	 */
	public int daysDiff(String cdate) {
		Calendar today=Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
//		System.out.println("today:"+today.getTime());
		Calendar cld=Calendar.getInstance();
		cld.set(Calendar.YEAR, Integer.parseInt(cdate.substring(0,4)));
		cld.set(Calendar.MONTH, Integer.parseInt(cdate.substring(4,6))-1);
		cld.set(Calendar.DAY_OF_MONTH, Integer.parseInt(cdate.substring(6,8)));
		cld.set(Calendar.HOUR_OF_DAY, 0);
		cld.set(Calendar.MINUTE, 0);
		cld.set(Calendar.SECOND, 0);
		cld.set(Calendar.MILLISECOND, 0);
//		System.out.println("cld:"+cld.getTime());
		return (int)((cld.getTimeInMillis()-today.getTimeInMillis())/24/3600/1000);
	}
	// !! 张通补上此部分代码！！
	public static String numberFormat(String s,int n) {
		return s;
	}
	
//	取绝对值，并强制保留两位小数--主要用于金额
	public static String numberABS(String s){
		if(s == null || s == "")
			s = "0.00";
//		Double ss1 = Integer.getInteger(s);//空指针异常
		double d = Math.abs(Double.parseDouble(s)); 
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(d);
	}
	
	public static int strlength(String s){
		return s.length();
	}
}
