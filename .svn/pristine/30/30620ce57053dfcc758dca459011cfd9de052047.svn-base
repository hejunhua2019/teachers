package cn.com.yajiaotong.wface.statics;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GroupStatics {
	public static List<Map<String,String>> GROUP_TYPES = new ArrayList<>();
	
	static {
		 try(InputStream input = GroupStatics.class.getClassLoader().getResourceAsStream("statics/groupStatics.xml");){
        	SAXParserFactory factory = SAXParserFactory.newInstance();
			//打开命名空间识别功能(可选)
			factory.setNamespaceAware(true);
			SAXParser parser = factory.newSAXParser();
			DefaultHandler handler = new GroupStaticHandler();//实例化上一步骤定义的个性化处理逻辑类
			parser.parse(input, handler);//读入xml文件及相关处理逻辑来进行解析操作
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	private static class GroupStaticHandler extends DefaultHandler{
		//private String preTag;
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if("type".equals(qName)){
				Map<String,String> type = new HashMap<>();
				type.put("value",attributes.getValue("value"));
				type.put("name", attributes.getValue("name"));
				GROUP_TYPES.add(type);
			}
			//preTag = qName;
		}
	}
	
}
