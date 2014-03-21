package com.fenby.practice.crawl;


public class URLThreadProcessor implements Runnable {
	private URLConfig urlConfig;

	public URLThreadProcessor(URLConfig urlConfig) {
		this.urlConfig = urlConfig;
	}

	@Override
	public void run() {
		URLProcessor.process(urlConfig);
	}
}
