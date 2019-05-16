package cn.com.yajiaotong.wface.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BExcel {
	public final static String FILE_TYPE_XLS  = "xls";
	public final static String FILE_TYPE_XLSX  = "xlsx";
	
	private static Logger log = LoggerFactory.getLogger(BExcel.class);
	/**
	 * 下一次读取起始行
	 */
	protected int startNo;

	/**
	 * 是否存在未读取记录
	 */
	protected boolean hasNext = true;

	/**
	 * 
	 * excel文件输入流
	 */
	protected InputStream input;

	
	public BExcel(int startNo,InputStream input){
		this.input=input;
		this.startNo = startNo;
		log.info("IExcel create :[file:"+input+"]");
	}
	
	public List<String[]> doRead(int sheetIndex, int columns, int limit){
		log.info("IExcel begin do read file[sheetIndex:"+sheetIndex+",columns size:"+columns+",limit:"+limit+",startNo:"+this.startNo+"]");
		List<String[]> list = read(sheetIndex, columns, limit);
		log.info("IExcel read file over......");
		closeStream();//关闭数据流
		release();//释放其他资源
		return list;
	}
	
	public Collection<String> doRead(int sheetIndex, int columns, int limit,int cloumnNo){
		log.info("IExcel begin do read file[sheetIndex:"+sheetIndex+",columns size:"+columns+",limit:"+limit+",startNo:"+this.startNo+"]");
		Collection<String> list = read(sheetIndex, columns, limit,cloumnNo);
		log.info("IExcel read file over......");
		closeStream();//关闭数据流
		release();//释放其他资源
		return list;
	}
	
	/**
	 * 关闭数据流
	 */
	protected void closeStream(){
		if(this.input!=null){
			try {
				this.input.close();
				this.input = null;
			} catch (IOException e) {
				e.printStackTrace();
				log.error("IExcel close inputstream faild:"+e.getMessage());
			}
		}
		log.info("IExcel has closed inputstream......");
	}
	
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	
	/**
	 * 是否存在未读取记录
	 * @return
	 */
	public boolean hasNext(){
		return this.hasNext;
	}

	/**
	 * 每一次查询起始行号
	 * @return int
	 */
	public int getStartNo() {
		return startNo;
	}
	
	/**
	 * 读取excel，在读取调用关闭方法之前，可以重复调用
	 * 
	 * @param sheetIndex
	 *            标签页索引
	 * @param columns
	 *            读取列数
	 * @param limit
	 *            一次读取条数限制
	 * @return
	 */
	protected abstract List<String[]> read(int sheetIndex, int columns, int limit);
	
	/**
	 * 读取excel，在读取调用关闭方法之前，可以重复调用
	 * 
	 * @param sheetIndex
	 *            标签页索引
	 * @param columns
	 *            读取列数
	 * @param limit
	 *            一次读取条数限制
	 * @param columnNo 指定列 
	 * @return
	 */
	protected abstract Collection<String> read(int sheetIndex, int columns, int limit,int colunNum);
	
	/**
	 * 释放excel资源
	 */
	protected abstract void release();
}
