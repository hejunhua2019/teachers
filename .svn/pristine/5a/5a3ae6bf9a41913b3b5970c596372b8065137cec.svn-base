package cn.com.yajiaotong.wface.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.com.yajiaotong.wface.util.excel.XLSX2CSV;
public class ImportUtil { 
	public static List Xls(File file){ 
		Map<String, String[]> map = new HashMap<String, String[]>(); 
		List<String[]> list=new ArrayList<String[]>();
		Workbook workbook = null;
		Sheet sheet[] = null;
		try{
			workbook = Workbook.getWorkbook(file);
			sheet = workbook.getSheets(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		 
//		for(int a=0;a<sheet.length;a++){
			int a=0;
//			System.out.println(sheet[a].getColumns());
//			System.out.println(sheet[a].getRows());
			for(int i=1;i<sheet[a].getRows();i++){
				String[] strs = new String[sheet[a].getColumns()];
				for(int j=0;j<sheet[a].getColumns();j++){
					strs[j] = sheet[a].getCell(j,i).getContents();					
				}
				if(strs[1].length()==11&&strs[1].matches("[0-9]{11}||[0-9]{15}")&&strs[1].startsWith("1")){
					if(!map.containsKey(strs[1])){
						map.put(strs[1], strs);
					}
				}
			}
//		}
			/*Set keys = map.keySet();
			Iterator it = keys.iterator();			
			while(it.hasNext()){
				Object key = it.next();
				list.add(map.get(key));
			}*/
			list.addAll(map.values());

		workbook.close();

		return list;
	}
	
	public static String StringXls(File file){
		StringBuffer sb = new StringBuffer();
		Workbook workbook = null;
		Sheet sheet[] = null;
		try{
			workbook = Workbook.getWorkbook(file);
			sheet = workbook.getSheets(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		int a=0;
		for(int i=1;i<sheet[a].getRows();i++){
			for(int j=0;j<1;j++){
				sb.append(sheet[a].getCell(j,i).getContents()+",");
			}				
		}
		workbook.close();
		return sb.toString();
	}
	
	public static List Excel(File file){
		Map<String, String[]> map = new HashMap<String, String[]>(); 
		List<String[]> list=new ArrayList<String[]>();
		XSSFWorkbook xwb=null;
		try {
			xwb = new XSSFWorkbook(new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 读取第一章表格内容

		XSSFSheet sheet = xwb.getSheetAt(0);  
		XSSFRow row; 

		// 循环输出表格中的内容 
		int length = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			String[] strs=new String[length];
			if(row!=null){
				for (int j = 0; j < length; j++) {
					// 通过 row.getCell(j).toString() 获取单元格内容，
					if(row.getCell(j)!=null){
						row.getCell(j).setCellType(HSSFCell.CELL_TYPE_STRING); 
						strs[j] = row.getCell(j).toString();
					}
					else {
						strs[j]="";					
					}			
				}	
				if(strs[1].length()==11&&strs[1].matches("[0-9]{11}||[0-9]{15}")&&strs[1].startsWith("1")){
					if(!map.containsKey(strs[1])){
						map.put(strs[1], strs);
					}
				}
			}			
		}
		/*Set keys = map.keySet();
		Iterator it = keys.iterator();			
		while(it.hasNext()){
			Object key = it.next();
			list.add(map.get(key));
		}*/
		list.addAll(map.values());
		return list;
	}
	
	public static String StringExcel(File file) throws Exception{
		StringBuffer sb = new StringBuffer();
		List<String> list= (List<String>)XLSX2CSV.readExcel07Bycsv(file, 1, 0);
		for(String s:list){
			sb.append(s.split(",")[0]+",");
		}
		return sb.toString();
	}
	
	public static List Txt(File file){
		Map<String, String[]> map = new HashMap<String, String[]>(); 
		List<String[]> list=new ArrayList<String[]>();
		BufferedReader br = null; 
		try {
//			br = new BufferedReader(new FileReader(file));
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String content = null;
		try {
			while((content = br.readLine())!=null){//使用readLine方法，一次读一行
				content = StringDo.Comma(content);
	            String[] strs = content.split(",");
	            for(int i=0;i<strs.length;i++){
	            	if(strs[i].equals("#")){
	            		strs[i]="";
	            	}
	            }
	            if(strs.length==8){
	            	if(strs[1].length()==11&&strs[1].matches("[0-9]{11}||[0-9]{15}")&&strs[1].startsWith("1")){
						if(!map.containsKey(strs[1])){
							map.put(strs[1], strs);
						}
					}
	            }
	        }
	        br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*Set keys = map.keySet();
		Iterator it = keys.iterator();
		while(it.hasNext()){
			Object key = it.next();
			list.add(map.get(key));
		}*/		
		list.addAll(map.values());
		return list;
	}
	
	public static String StringTxt(File file){
		BufferedReader br = null; 
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		String content = null;
		try {
			while((content = br.readLine())!=null){
				sb.append(content+",");//使用readLine方法，一次读一行
	        }
	        br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
/*	public static void main(String[] args) {
		File file = new File("D:/1.txt");
		List<String[]> list=Txt(file);
		for(String[] ss:list){
			System.out.println(ss[1]);
		}
	}*/
}
