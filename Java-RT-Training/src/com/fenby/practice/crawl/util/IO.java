/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.Set;

import com.fenby.practice.crawl.URLConfig;

public class IO {
    public static boolean deleteFolder(File folder) {
        return deleteFolderContents(folder) && folder.delete();
    }

    public static boolean deleteFolderContents(File folder) {
        System.out.println("Deleting content of: " + folder.getAbsolutePath());
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                if (!file.delete()) {
                    return false;
                }
            } else {
                if (!deleteFolder(file)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static URLConfig[] readURLConfigFromFile(String destination) {
        Set<URLConfig> sites = new HashSet<URLConfig>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(destination));
            String line = null;
            while ((line = br.readLine()) != null) {
                sites.add(processURLConfigLine(line));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sites.toArray(new URLConfig[0]);
    }

    private static URLConfig processURLConfigLine(String line) {
        String[] config = line.split("[\\s|\\t]+");

        URLConfig urlConfig = new URLConfig();
        urlConfig.setCode(config[0]);
        urlConfig.setUrl(config[1]);

        return urlConfig;
    }

    public static void writeBytesToFile(byte[] bytes, String path, String file) {
        File filePath = new File(path);

        if (!filePath.exists()) {
            filePath.mkdirs();
        }

        writeBytesToFile(bytes, path + file);
    }

    public static void writeBytesToFile(byte[] bytes, String destination) {

        FileOutputStream fos = null;
        FileChannel fc = null;
        try {
            fos = new FileOutputStream(destination);
            fc = fos.getChannel();

            fc.write(ByteBuffer.wrap(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fc.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
