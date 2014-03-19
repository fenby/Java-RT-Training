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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GreetingClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6666;
        try {
            System.out.println("准备连接至服务器: " + serverName + ", 端口: " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("服务器Socket地址: " + client.getRemoteSocketAddress());

            // 向服务器发送数据
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(client.getLocalSocketAddress().toString());

            // 从服务器读取数据
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("[Client:接收数据]: " + in.readUTF());

            // 关闭Socket
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}