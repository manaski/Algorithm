package com.gangbin.网络编程.多线程模式;

import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class MyServer
{
	public static List<Socket> socketList
		= Collections.synchronizedList(new ArrayList<>());
	public static void main(String[] args)
		throws IOException
	{
		ServerSocket ss = new ServerSocket(30000);
		while(true)
		{
			// 监听连接
			Socket s = ss.accept();
			socketList.add(s);
			// 开启新线程进行广播
			new Thread(new ServerThread(s)).start();
		}
	}
}
