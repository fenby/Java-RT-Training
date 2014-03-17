/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl;

import java.io.IOException;

import com.fenby.practice.crawl.parser.WebParserBase;
import com.fenby.practice.crawl.parser.WebParserHuxiu;
import com.fenby.practice.crawl.parser.WebParserU148;
import com.fenby.practice.crawl.util.IO;

public class WebCrawler {

    public static void main(String[] args) {
        int counter = 0;
        URLConfig[] urlConfigs = IO.readURLConfigFromFile(System.getProperty("user.dir") + "/url_config.list");
        log("爬虫开始执行...");

        for (URLConfig urlConfig : urlConfigs) {
            log("处理第" + ++counter + "条记录.");

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
        if (urlConfig.getCode().equals("U148")) {
            webParser = new WebParserU148(urlConfig.getUrl());
        } else if (urlConfig.getCode().equals("HUXIU")) {
            webParser = new WebParserHuxiu(urlConfig.getUrl());
        }

        webParser.parseHtml();

        String outPath = "/tmp/" + urlConfig.getCode();
        String outFile = urlConfig.getUrl().substring(urlConfig.getUrl().lastIndexOf("/"));
        IO.writeBytesToFile(webParser.getHtmlOutput().getBytes(), outPath, outFile);
    }

    private static void log(String msg) {
        System.out.println("> " + msg);
    }
}
