package cn.com.yajiaotong.wface.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

public class CommonFileParser{

	Map<String,FileParser> m=new HashMap<String,FileParser>();

	public void parse(String extension,InputStream in) {
		m.get(extension).parse(in);
	}

}
