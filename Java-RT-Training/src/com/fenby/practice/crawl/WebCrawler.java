/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl;

import java.net.MalformedURLException;

import com.fenby.practice.crawl.parser.WebParserU148;
import com.fenby.practice.crawl.util.IO;

public class WebCrawler {
    public static void main(String[] args) throws MalformedURLException {
        String targetURL = "http://www.u148.net/article/100798.html";

        WebURL webURL = new WebURL(targetURL);

        WebParser webParser = new WebParserU148();

        webParser.parseHtml(webURL.getContent());
        System.out.println("Header: " + webParser.getHeader());
        System.out.println("Content: " + webParser.getContent());

        IO.writeBytesToFile(webParser.getHtmlOutput().getBytes(), "/tmp/u148.html");
    }
}
