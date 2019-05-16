package cn.com.yajiaotong.wface.util;

public class ReportThreadCount {
	private static int THREAD_NUM = 0;
	private static long THREAD_ID = 0L;
	public final static int MAX_THREAD_NUM = 30;

	private ReportThreadCount() {
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
