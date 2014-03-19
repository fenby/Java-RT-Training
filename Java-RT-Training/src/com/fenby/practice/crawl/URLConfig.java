/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl;

public class URLConfig {
    private String code;
    private String url;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUniqueFilename() {
    	String filename = null;
    	if (code.equalsIgnoreCase("huxiu")) {
    		String tmp = getUrl().replaceFirst("/1\\.html", "_1.html");
    		filename = tmp.substring(tmp.lastIndexOf("/"));
    	} else {
    		filename = getUrl().substring(getUrl().lastIndexOf("/"));
    	}

    	return filename;
    }
}
