/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl;

import java.util.ArrayList;
import java.util.List;

import com.fenby.practice.crawl.util.IO;

public class WebCrawler {
	private static int counter = 0;
	private static String userDir = null;
	private static boolean multithreadMode = true;

	public static void main(String[] args) {
		long mainThreadStartTime = System.currentTimeMillis();

		userDir = System.getProperty("user.dir");
		URLConfig[] urlConfigs = IO.readURLConfigFromFile(userDir
				+ "/url_config.list");

		log("爬虫开始执行...");

		// 子线程列表
		List<Thread> list = new ArrayList<Thread> ();

		for (URLConfig urlConfig : urlConfigs) {
			if (multithreadMode) {
				URLThreadProcessor task = new URLThreadProcessor(urlConfig);
				Thread thread = new Thread(task);
				thread.start();

				list.add(thread);
			} else {
				URLProcessor.process(urlConfig);
			}
			log("处理第" + ++counter + "条记录. 网站[" + urlConfig.getCode() + "], URL[" + urlConfig.getUrl() + "]");
		}

		// 等待全部子线程处理完成后主线程继续执行
		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		log("爬虫结束执行...");
		log("总共处理" + counter + "条记录, 总共耗时 "
				+ (System.currentTimeMillis() - mainThreadStartTime) + " 毫秒");

	}

	private static void log(String msg) {
		System.out.println("> " + msg);
	}
}
