package cn.com.yajiaotong.wface.util.excel;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.yajiaotong.wface.util.StringUtil;


public class ExcelHelper {
	private static Logger log = LoggerFactory.getLogger(ExcelHelper.class);

	/**
	 * 获取excel处理对象
	 * 
	 * @param fileType
	 *            文件类型,支持txt、xls、xlsx三种格式
	 * @param startNo
	 *            行号从0开始
	 * @param file
	 *            要导入的文件实例
	 * @return
	 */
	public static BExcel getExcel(String fileType, int startNo, InputStream file) throws Exception{
		BExcel excel = null;
		log.info("ExcelFactory create BExcel:[fileType:"+fileType+",startNo:"+startNo+",file:"+file+"]......");
		if (!StringUtil.isEmpty(fileType) && file != null) {
			if (BExcel.FILE_TYPE_XLSX.equals(fileType.toLowerCase().trim())) {
				excel = new Excel07(startNo, file);
			}else if (BExcel.FILE_TYPE_XLS.equals(fileType.toLowerCase().trim())) {
				if ("xls".equals(fileType.toLowerCase().trim())) {
					excel = new Excel03(startNo, file);
				}
			} else {
				log.error("ExcelFactory get BExcel faild,Illegal file type:"+fileType);
				throw new Exception("Illegal file type:"+fileType);
			}
		} else {
			log.error("create Excel object faild:fileType or file is null");
			throw new Exception("ExcelFactory get BExcel faild[file:"+file+",fileType:"+fileType+"]");
		}
		log.info("ExcelFactory create BExcel sucess:[]......");
		return excel;
	}

//	public static void main(String[] args) throws Exception{
//		BExcel excel = ExcelFactory.getExcel("xlsx", 1, new File(
//				"D:\\0-0-工作\\0-8-开发\\EMAS2.0\\联系人上传\\tmp.xlsx"));
//		int columns = 8;
//		int limit = 30000;
//		int readNum = 0;
//		long total = 0;
//		long start = System.currentTimeMillis();
//		try {
//			List<String[]> list = null;
//			while (excel.hasNext()) {
//				long _s = System.currentTimeMillis();
//				list = excel.doRead(0, columns, limit);
//				long _e = System.currentTimeMillis();
//				System.out.println("readNum:=" + (++readNum) + "  耗时："
//						+ (_e - _s));
//				Thread.sleep(500);
//				total += list.size();
//				if (list.size() <= 0) {
//					break;
//				}
//				list.clear();
//			}
//		} catch (Throwable e) {
//			e.printStackTrace();
//		} finally {
//			excel.release();
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("总耗时：" + (end - start));
//		System.out.println("total:=" + total);
//	}
}
