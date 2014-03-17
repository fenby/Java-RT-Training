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

public abstract class WebParserBase {
    protected Document document;
    protected String header;
    protected String content;

    public WebParserBase(String url) throws IOException {
        document = Jsoup.connect(url).get();

        parseHtml();
    }

    public String getHeader() {
        return this.header;
    }

    public String getContent() {
        return this.content;
    }

    public String getHtmlOutput() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"en\">\n");
        sb.append("  <head>\n");
        sb.append("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
        sb.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        sb.append("    <title>" + getHeader() + "</title>\n");
        sb.append("    <link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\n");
        sb.append("    <link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css\">\n");
        sb.append("    <script src=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js\"></script>\n");
        sb.append("  </head>\n");
        sb.append("  <body>\n");
        sb.append("    <div class=\"container\">\n");
        sb.append("      <div class=\"row\">\n");
        sb.append("        <div class=\"col-md-8 col-md-offset-2\"><h1 class=\"text-center\">" + getHeader() + "</h1></div>\n");
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
