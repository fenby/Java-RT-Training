/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WebURL {
    private static final String HTTP = "http";
    private static final String END_OF_INPUT = "\\Z";

    private URL url;

    public WebURL(String url) throws MalformedURLException {
        this.url = new URL(url);
        if (!HTTP.equals(this.url.getProtocol())) {
            throw new IllegalArgumentException("非HTTP协议的URL地址: " + url);
        }
    }

    public String getDomain() {
        return this.url.getHost();
    }

    public String getPath() {
        return this.url.getPath();
    }

    public String getContent() {
        String result = null;
        URLConnection connection = null;
        try {
            connection = url.openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter(END_OF_INPUT);
            result = scanner.next();

            scanner.close();
        } catch (IOException ex) {
            System.out.println("打开URL连接失败: " + url.toString());
        }

        return result;
    }
}
