package com.test.cc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {描述: 功能，使用对象，使用方法等}
 * 
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-29 上午11:20:07
 */
public class DownloadExecutor {
	private static int CORE_POOL_SIZE = 5;
	private static int MAX_POOL_SIZE = 12;
	private final static int KEEP_ALIVE = 1;
	private static final ThreadFactory sThreadFactory = new ThreadFactory() {
		private final AtomicInteger mCount = new AtomicInteger(1);

		public Thread newThread(Runnable r) {
			return new Thread(r, "download #" + mCount.getAndIncrement());
		}
	};
	private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(
			10);
	public static final Executor EXECUTOR = new ThreadPoolExecutor(
			CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS,
			sPoolWorkQueue, sThreadFactory);
}
