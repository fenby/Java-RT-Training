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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class CapitalizeServer  {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int port = 6666;
        int clientNumber = 0;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器监听端口: " + serverSocket.getLocalPort() + "...");

            while (true) {
                try {
                    clientNumber++;

                    // 等待客户端请求
                    Socket server = serverSocket.accept();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(server.getInputStream()));
                    PrintWriter out = new PrintWriter(server.getOutputStream(), true);

                    // 给客户端发送提示信息
                    out.println("你好, 你是第" + clientNumber + "个客户.");
                    out.println("输入.退出\n");

                    // 获取客户端的数据, 逐行处理, 将数据转换为大写后发送给客户端
                    while (true) {
                        String input = in.readLine();
                        System.out.println("[服务器接收数据]: " + input);

                        if (input == null || input.equals(".")) {
                            break;
                        }

                        out.println(input.toUpperCase());
                        System.out.println("[服务器发送数据]: " + input.toUpperCase());
                    }

                    // 关闭Socket
                    server.close();
                } catch (SocketTimeoutException s) {
                    System.out.println("Socket超时");
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}