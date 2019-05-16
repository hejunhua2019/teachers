package cn.com.yajiaotong.wface.util;

/**
 * 
 * @ClassName: MOThreadCount
 * @Description: 控制同步接口的并发数,减轻对商户网关的压力
 */
public class MOThreadCount {
	private static int THREAD_NUM = 0;
	private static long THREAD_ID = 0L;
	public final static int MAX_THREAD_NUM = 20;

	private MOThreadCount() {
	}

	public synchronized static void addThread() {
		THREAD_NUM++;
	}

	public synchronized static void decThread() {
		THREAD_NUM--;
	}

	public static int getThreadNum() {
		return THREAD_NUM;
	}

	public synchronized static long getNextID() {
		return ++THREAD_ID;
	}

	public static int getThread() {
		return THREAD_NUM;
	}
}
