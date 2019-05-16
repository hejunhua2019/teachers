package cn.com.yajiaotong.wface.util;


public class CheckPwd {
	public static String checkPassword(String password) {
			
			char[] chars = password.toCharArray();
			boolean b1 =true;
			for(char c:chars){				
				b1=b1&&Character.isDigit(c);				
			}
			if(b1){
				return("0");
			}
			boolean b2 =true;
			for(char c:chars){				
				b2=b2&&Character.isLetter(c);				
			}
			if(b2){
				return("0");
			}
		return "1";
	}
	
//	public static void main(String[] args) {
//		System.out.println(checkPassword("asdLKJ@")); 
//	}

}
