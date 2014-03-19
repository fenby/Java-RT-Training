/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day12.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CapitalizeClient {

    public static void main(String[] args) {

        BufferedReader in;
        PrintWriter out;

        String serverName = "localhost";
        int port = 6666;

        try {
            System.out.println("准备连接至服务器: " + serverName + ", 端口: " + port);
            Socket client = new Socket(serverName, port);

            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);

            // 显示服务器端发送的提示信息
            for (int i = 0; i < 3; i++) {
                System.out.println(in.readLine());
            }

            // 从服务器读取数据
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while (true) {
                str = br.readLine();
                System.out.println("[客户端发送数据]: " + str);
                out.println(str);

                if (str.equals(".")) {
                    break;
                }

                System.out.println("[客户端接收数据]: " + in.readLine());
            }

            // 关闭Socket
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}