/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl.parser;

import java.io.IOException;

public class WebParserU148 extends WebParserBase {

    public WebParserU148(String url) throws IOException {
        super(url);
    }

    public void parseHtml() {

        this.title = document.select("div.u148content > h1 > a").first().html();
        this.content = document.select("div.u148content > div.content").first().html();
    }
}
