package cn.com.yajiaotong.wface.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TxtFileParser implements FileParser {

	private static final Logger log=LoggerFactory.getLogger(cn.com.yajiaotong.wface.util.TxtFileParser.class);
	
	@Override
	public void parse(InputStream in) {
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			line = reader.readLine();
			while(StringUtils.isNotBlank(line)){
				
			}
		} catch (IOException e) {
			log.error("",e);
		}
	}

}
