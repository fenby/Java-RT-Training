/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day12.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer  {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int port = 6666;

        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                try {
                    System.out.println("服务器监听端口: " + serverSocket.getLocalPort() + "...");

                    // 等待客户端请求
                    Socket server = serverSocket.accept();
                    System.out.println("客户端Socket地址: " + server.getRemoteSocketAddress());

                    // 读取客户端发送的数据
                    DataInputStream in = new DataInputStream(server.getInputStream());
                    System.out.println("[Server:接收数据]: " + in.readUTF());

                    // 将结果返回给客户端
                    DataOutputStream out = new DataOutputStream(server.getOutputStream());
                    out.writeUTF("感谢访问<" + server.getLocalSocketAddress() + ">, 再见!");

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