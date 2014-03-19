package com.fenby.practice.crawl.parser;

import java.io.IOException;

public class WebParserImeise extends WebParserBase {

	public WebParserImeise(String url) throws IOException {
		super(url);
	}

	@Override
	public void parseHtml() {
		 this.title = document.select("div.metaRight > h2 > a").first().html();
        this.content = document.select("div.postContent").first().html();
	}

}
