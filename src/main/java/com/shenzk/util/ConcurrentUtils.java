package com.shenzk.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrentUtils {

	/**
	 * 关闭线程池，最多等待现成结束时间：60s
	 * @param executors
	 */
	public static void stop(ExecutorService executors){
		try {
			executors.shutdown();
			executors.awaitTermination(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("中断");
		} finally {
			if(!executors.isTerminated()){
				System.out.println("关闭了未完成的任务");
			}
			executors.shutdownNow();
		}
	}

	/**
	 * 线程睡眠
	 * @param sleepSeconds
	 */
	public static void sleep(int sleepSeconds){
		try {
			TimeUnit.SECONDS.sleep(sleepSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
