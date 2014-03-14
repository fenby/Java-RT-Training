/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl;


public abstract class WebParser {
    protected String header;
    protected String content;

    public String getHeader() {
        return this.header;
    }

    public String getContent() {
        return this.content;
    }

    public String getHtmlOutput() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("\t<head>");
        sb.append("\t<title>" + getHeader() + "</title>");
        sb.append("\t\t<link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">");
        sb.append("\t\t<link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css\">");
        sb.append("\t\t<script src=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js\"></script>");
        sb.append("\t</head>");
        sb.append("\t<body>");
        sb.append("\t\t<div class=\"container\">");
        sb.append("\t\t\t<div class=\"header\"><h1>" + getHeader() + "</h1></div>");
        sb.append("\t\t\t<div class=\"content\">" + getContent() + "</div>");
        sb.append("\t\t</div>");
        sb.append("\t</body>");
        sb.append("</html>");

        return sb.toString();
    }

    public abstract void parseHtml(String html);
}
