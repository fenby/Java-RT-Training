package com.fenby.practice.crawl;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * 抓取网页的HTML内容（content）或头部（header）信息。
 */
public class WebPageFetcher {

    private static final String HTTP = "http";
    private static final String HEADER = "header";
    private static final String CONTENT = "content";
    private static final String END_OF_INPUT = "\\Z";
    private static final String NEWLINE = System.getProperty("line.separator");

    // PRIVATE
    private URL url;

    /**
     * Demo harness.
     *
     * <ul>
     * <li>args[0] : URL地址（基于HTTP协议）
     * <li>args[1] : (header | content)
     * </ul>
     */
    public static void main(String[] args) throws MalformedURLException {
        String url = args[0];
        String option = args[1];
        WebPageFetcher fetcher = new WebPageFetcher(url);
        if (HEADER.equalsIgnoreCase(option)) {
            log(fetcher.getPageHeader());
        } else if (CONTENT.equalsIgnoreCase(option)) {
            log(fetcher.getPageContent());
        } else {
            log("无效的选项");
        }
    }

    /**
     *
     * @param urlName URL地址
     * @throws MalformedURLException
     */
    public WebPageFetcher(String urlName) throws MalformedURLException {
        this(new URL(urlName));
    }

    /**
     *
     * @param url URL对象
     */
    public WebPageFetcher(URL url) {
        if (!HTTP.equals(url.getProtocol())) {
            throw new IllegalArgumentException("非HTTP协议的URL地址: " + url);
        }
        this.url = url;
    }

    /**
     *
     * @description 获取网页内容信息
     *
     * @return 网页内容信息
     */
    public String getPageContent() {
        String result = null;
        URLConnection connection = null;
        try {
            connection = url.openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter(END_OF_INPUT);
            result = scanner.next();
        } catch (IOException ex) {
            log("打开URL连接失败: " + url.toString());
        }
        return result;
    }

    /**
     *
     * @description 获取网页头部信息
     *
     * @return 网页头部信息
     */
    public String getPageHeader() {
        StringBuilder result = new StringBuilder();
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException ex) {
            log("打开URL连接失败: " + url.toString());
        }

        // not all headers come in key-value pairs - sometimes the key is
        // null or an empty String
        int headerIdx = 0;
        String headerKey = null;
        String headerValue = null;
        while ((headerValue = connection.getHeaderField(headerIdx)) != null) {
            headerKey = connection.getHeaderFieldKey(headerIdx);
            if (headerKey != null && headerKey.length() > 0) {
                result.append(headerKey);
                result.append(" : ");
            }
            result.append(headerValue);
            result.append(NEWLINE);
            headerIdx++;
        }
        return result.toString();
    }

    private static void log(Object aObject) {
        System.out.println(aObject);
    }
}
