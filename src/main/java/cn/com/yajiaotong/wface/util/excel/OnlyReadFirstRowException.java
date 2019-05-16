package cn.com.yajiaotong.wface.util.excel;

import org.xml.sax.SAXException;

public class OnlyReadFirstRowException extends SAXException {
	public OnlyReadFirstRowException(String error){
		super(error);
	}
}
