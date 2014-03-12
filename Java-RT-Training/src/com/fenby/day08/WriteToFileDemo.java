package com.fenby.day08;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFileDemo {
    public static void main(String[] args) {

        // 需要写入文件的数组
        byte byteArray[] = { 23, 34, 55, 65, 45, 78, 88 };

        try {
            // 如果文件不存在我们先创建文件
            String filePath = CreateSampleFile();

            // 创建FileOutputStream实例
            FileOutputStream output = new FileOutputStream(filePath);

            for (int x = 0; x < byteArray.length; x++) {
                output.write(byteArray[x]); // writes the bytes
            }

            // 关闭流
            output.close();

            System.out.println("目标文件: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建sample文件
    private static String CreateSampleFile() {
        String filePath = "";
        try {
            String dirName = "/tmp/java";
            File dir = new File(dirName);
            dir.mkdirs();

            File file = new File(dir, "sample.txt");
            filePath = file.getAbsolutePath();
            // 如果文件不存在就创建一个新文件
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}