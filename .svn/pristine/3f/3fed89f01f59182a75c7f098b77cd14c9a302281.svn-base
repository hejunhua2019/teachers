package cn.com.yajiaotong.wface.util.excel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class Excel07 extends BExcel{
	private static Logger log = LoggerFactory.getLogger(Excel07.class);
	/**
	 * POI操作对象
	 */
	private XSSFWorkbook excel;

	/**
	 * 
	 * @param file
	 * @param startNo 行号从0开始
	 */
	Excel07(int startNo,InputStream input){
		super(startNo,input);
	}

	/**
	 * 读取excel，不需要起始行参数，在读取调用关闭方法之前，可以重复调用
	 * 
	 * @param sheetIndex
	 *            标签页索引
	 * @param columns
	 *            读取列数
	 * @param limit
	 *            一次读取条数限制
	 * @return
	 */
	public List<String[]> read(int sheetIndex, int columns, int limit) {
		List<String[]> list = new ArrayList<String[]>();
		try {
			this.excel = new XSSFWorkbook(input);
			XSSFSheet sheet = this.excel.getSheetAt(sheetIndex);
			
			int lastRN = sheet.getLastRowNum();
			
			int end = startNo + limit-1;// 计算截止行数，excel第1行从0开始，所以截止行要减1
			end=end>lastRN?lastRN:end;

			String[] strs = null;
			XSSFRow row = null;
			for (int i=startNo; i <= end; i++) {
				strs = new String[columns];
				row = sheet.getRow(i);
				if(row!=null){
					int nullCounter = 0;//空白单元格计数器
					Cell cell = null;
					for (int c = 0; c < columns; c++) {
						cell = row.getCell(c, Row.CREATE_NULL_AS_BLANK);
						if (cell != null) {
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							strs[c] = row.getCell(c).toString().trim();
						} else {
							nullCounter++;
						}
					}
					//计数器等于columns，则此行为空行，不加入到list
					if(nullCounter!=columns){
						list.add(strs);	
					}
				}
			}
			if(end>=lastRN){
				hasNext=false;
			}
			startNo = end+1;// 标记为下次起始行
			log.info("excel07 read over:[hasNext:"+hasNext+",next read startNo:"+startNo+",list.size:"+list.size()+"]");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("excel07 read faild:"+e.getMessage());
		} catch (Exception e){
			e.printStackTrace();
			log.error("excel07 read faild:"+e.getMessage());
		}
		finally{
			release();
		}
		return list;
	}
	
	protected Collection<String> read(int sheetIndex, int columns, int limit,int colunNum){

		List<String> list = new ArrayList<String>();
		try {
			this.excel = new XSSFWorkbook(input);
			XSSFSheet sheet = this.excel.getSheetAt(sheetIndex);
			
			int lastRN = sheet.getLastRowNum();
			
			int end = startNo + limit-1;// 计算截止行数，excel第1行从0开始，所以截止行要减1
			end=end>lastRN?lastRN:end;

			String strs = null;
			XSSFRow row = null;
			for (int i=startNo; i <= end; i++) {
				row = sheet.getRow(i);
				if(row!=null){
					int nullCounter = 0;//空白单元格计数器
					Cell cell = null;
//					for (int c = 0; c < columns; c++) {
						int c = colunNum;
						cell = row.getCell(c, Row.CREATE_NULL_AS_BLANK);
						if (cell != null) {
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							strs = row.getCell(c).toString().trim();
						} else {
							nullCounter++;
						}
//					}
					//计数器等于columns，则此行为空行，不加入到list
					if(nullCounter!=columns){
						list.add(strs);	
					}
				}
			}
			if(end>=lastRN){
				hasNext=false;
			}
			startNo = end+1;// 标记为下次起始行
			log.info("excel07 read over:[hasNext:"+hasNext+",next read startNo:"+startNo+",list.size:"+list.size()+"]");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("excel07 read faild:"+e.getMessage());
		} catch (Exception e){
			e.printStackTrace();
			log.error("excel07 read faild:"+e.getMessage());
		}
		finally{
			release();
		}
		return list;
	
	}
	
	/**
	 * 释放excel资源
	 */
	public void release() {
		if (this.excel != null) {
			try {
				this.excel.close();
				this.excel = null;
			} catch (IOException e) {
				e.printStackTrace();
				log.error("close excel workbook faild:" + e.getMessage());
			}
		}
		log.info("close excel workbook success");
	}
}
