package com.fenby.practice.crawl;

import java.io.File;
import java.io.IOException;

import com.fenby.practice.crawl.parser.WebParserHuxiu;
import com.fenby.practice.crawl.parser.WebParserImeise;
import com.fenby.practice.crawl.parser.WebParserU148;
import com.fenby.practice.crawl.util.IO;

public class URLProcessor {
	public static void process(URLConfig urlConfig) {
		WebParser webParser = null;

		try {
			if (urlConfig.getCode().equalsIgnoreCase("u148")) {
				webParser = new WebParserU148(urlConfig.getUrl());
			} else if (urlConfig.getCode().equalsIgnoreCase("huxiu")) {
				webParser = new WebParserHuxiu(urlConfig.getUrl());
			} else if (urlConfig.getCode().equalsIgnoreCase("meizitu")) {
				webParser = new WebParserImeise(urlConfig.getUrl());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String outPath = System.getProperty("user.dir") + File.separator + "crawled" + File.separator
				+ urlConfig.getCode();
		String outFile = urlConfig.getUniqueFilename();

		IO.writeBytesToFile(webParser.generateHTMLOutput().getBytes(), outPath,
				outFile);
	}
}
