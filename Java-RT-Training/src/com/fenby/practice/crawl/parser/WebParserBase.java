/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.fenby.practice.crawl.WebParser;

public abstract class WebParserBase implements WebParser {
    protected Document document;
    protected String title;
    protected String content;

    public WebParserBase(String url) throws IOException {
//    	long startedTime = System.currentTimeMillis();
        document = Jsoup.connect(url).timeout(10 * 1000).get();

//        System.out.println("连接至: [" + url + "], 耗时: [" + (System.currentTimeMillis() - startedTime) + "]");
        parseHtml();


    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String generateHTMLOutput() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"en\">\n");
        sb.append("  <head>\n");
        sb.append("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
        sb.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        sb.append("    <title>" + getTitle() + "</title>\n");
        sb.append("    <link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\n");
        sb.append("    <link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css\">\n");
        sb.append("    <script src=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js\"></script>\n");
        sb.append("  </head>\n");
        sb.append("  <body>\n");
        sb.append("    <div class=\"container\">\n");
        sb.append("      <div class=\"row\">\n");
        sb.append("        <div class=\"col-md-8 col-md-offset-2\"><h1 class=\"text-center\">" + getTitle() + "</h1></div>\n");
        sb.append("      </div>\n");
        sb.append("      <div class=\"row\">\n");
        sb.append("        <div class=\"col-md-8 col-md-offset-2\">" + getContent() + "</div>\n");
        sb.append("      </div>\n");
        sb.append("    </div>\n");
        sb.append("  </body>\n");
        sb.append("</html>\n");

        return sb.toString();
    }

    public abstract void parseHtml();
}
