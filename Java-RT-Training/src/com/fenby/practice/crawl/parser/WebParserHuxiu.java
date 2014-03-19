/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl.parser;

import java.io.IOException;


public class WebParserHuxiu extends WebParserBase {

    public WebParserHuxiu(String url) throws IOException {
        super(url);
    }

    @Override
    public void parseHtml() {

        this.title = document.select("div.neirong > h1").first().html();
        this.content = document.select("div.neirong > table.neirong-box").first().html();
    }
}
