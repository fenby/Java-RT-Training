/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.practice.crawl.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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
