/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.fenby.practice.crawl.WebParser;

public class WebParserU148 extends WebParser {

    @Override
    public void parseHtml(String html) {

        Document document = Jsoup.parse(html);

        this.header = document.select("div.u148content > h1 > a").first().html();
        this.content = document.select("div.u148content > div.content").first().html();
    }
}
