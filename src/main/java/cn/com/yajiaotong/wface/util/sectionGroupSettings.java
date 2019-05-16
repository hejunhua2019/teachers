package cn.com.yajiaotong.wface.util;

import java.util.HashMap;

public class sectionGroupSettings {
	private HashMap<String,sectionGroupData> settings=new HashMap<String, sectionGroupData>();
	public void add(String Key,sectionGroupData Value)
	{
		if(!settings.containsKey(Key))
		{
			settings.put(Key, Value);
		}
	}
	public sectionGroupData getProperty(String Key)
	{
		if(settings.containsKey(Key))
		{
			return settings.get(Key);
		}
		return null;
	}
	public HashMap<String, sectionGroupData> getsectionGroupList()
	{
		return this.settings;
	}
}
