/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl;

import java.net.MalformedURLException;

public class WebCrawler {
    public static void main(String[] args) throws MalformedURLException {
        String targetURL = "http://www.u148.net/article/100798.html";

        WebURL webURL = new WebURL(targetURL);

        System.out.println(">>>" + webURL.getContent());
    }
}
