package com.base.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
/** 
 * @类说明 : 创建线程池
 * @copyright eprint 
 */
public class ThreadPool {
	//核心线程数
	public static Integer corePoolSize = 8;
	//最大線程數 (任務隊列為無界隊列則無效  線程池只會保持核心線程數量的線程執行任務)
	public static Integer maximumPoolSize = 20;
	//任務隊列數 小於一則為無界隊列
	public static Integer workQueueSize = 0;
	//線程保持時間
	public static Long keepAliveTime = Long.MAX_VALUE;
	//線程池對象
	public static ThreadPoolExecutor executor; 
	//任務隊列
	public static BlockingQueue<Runnable> queue;
	//備用務隊列
	public static BlockingQueue<Runnable> spareQueue = new LinkedBlockingQueue<Runnable>();
	private final static Logger log = Logger.getLogger(ThreadPool.class);
	public static Map<String, Thread> threadMap = new HashMap<String, Thread>();
	public static Map<String, Timer> timerMap = new HashMap<String, Timer>();
	
	/** 
	 * @方法说明 线程池初始化
	 */
	public static void ThreadPoolInit() {
		if (workQueueSize >= 1) {
			queue = new ArrayBlockingQueue<Runnable>(workQueueSize); //固定为workQueueSize的线程队列  
		}else{
			queue = new LinkedBlockingQueue<Runnable>(); 
		}
		executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, workQueueSize, TimeUnit.DAYS, queue);

	}
	
	
	/** 
	 * @方法说明 添加线程任务
	 */
	public static void addTaskToQueue(Runnable command) {
		log.warn("添加任务："+command.toString());
		executor.execute(command);
	}
	
	
	/** 
	 * @方法说明 获取线程池任务队列任务數量
	 */
	public static Integer getQueueSize() {
		if (queue != null) {
			return queue.size();
		}else{
			return null;
		}
	}
	
	/** 
	 * @方法说明  获取线程池中執行任務的線程數
	 */
	public static Integer getActiveCount() {
		if (executor.isShutdown()) {
			return null;
		}else {
			return executor.getActiveCount();
		}

	}
	/** 
	 * @方法说明 執行備用任務隊列的任務
	 */
	public static void spareQueueTaskRun() {
		if (spareQueue.size() > 0) {
			for (Runnable runnable : spareQueue) {
				executor.execute(runnable);
			}
		} else {
			return;
		}
		spareQueue.clear();
	}
	
}
