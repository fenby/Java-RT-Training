/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl;

import java.io.File;
import java.io.IOException;

import com.fenby.practice.crawl.parser.WebParserBase;
import com.fenby.practice.crawl.parser.WebParserHuxiu;
import com.fenby.practice.crawl.parser.WebParserImeise;
import com.fenby.practice.crawl.parser.WebParserU148;
import com.fenby.practice.crawl.util.IO;

public class WebCrawler {
	private static int counter = 0;
	private static String userDir = null;

    public static void main(String[] args) {

        userDir = System.getProperty("user.dir");
        URLConfig[] urlConfigs = IO.readURLConfigFromFile(userDir + "/url_config.list");
        log("爬虫开始执行...");

        for (URLConfig urlConfig : urlConfigs) {
            log("处理第" + ++counter + "条记录. 网站[" + urlConfig.getCode() + "]");

            try {
                process(urlConfig);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        log("爬虫结束执行...");
        log("总共处理" + counter + "条记录.");

    }

    private static void process(URLConfig urlConfig) throws IOException {

        WebParserBase webParser = null;
        if (urlConfig.getCode().equalsIgnoreCase("u148")) {
            webParser = new WebParserU148(urlConfig.getUrl());
        } else if (urlConfig.getCode().equalsIgnoreCase("huxiu")) {
            webParser = new WebParserHuxiu(urlConfig.getUrl());
        } else if (urlConfig.getCode().equalsIgnoreCase("imeise")) {
        	webParser = new WebParserImeise(urlConfig.getUrl());
        }

        webParser.parseHtml();

        String outPath = userDir + File.separator + "crawled" + File.separator + urlConfig.getCode();
        String outFile = urlConfig.getUniqueFilename();
        IO.writeBytesToFile(webParser.generateHTMLOutput().getBytes(), outPath, outFile);
    }

    private static void log(String msg) {
        System.out.println("> " + msg);
    }
}
