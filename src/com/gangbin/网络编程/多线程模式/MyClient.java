package com.gangbin.网络编程.多线程模式;

import java.io.*;
import java.net.*;
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
public class MyClient
{
	public static void main(String[] args)throws Exception
	{
		Socket s = new Socket("127.0.0.1" , 30000);
		// 创建新线程，接收服务器传来的信息
		new Thread(new ClientThread(s)).start();
		// 获得输出流，写给服务器
		PrintStream ps = new PrintStream(s.getOutputStream());
		String line = null;
		// 输出的内容来自键盘输入
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		while ((line = br.readLine()) != null)
		{
			// 输出到服务器
			ps.println(line);
		}
	}
}
