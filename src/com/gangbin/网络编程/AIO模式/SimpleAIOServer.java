package com.gangbin.网络编程.AIO模式;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.concurrent.*;
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
public class SimpleAIOServer
{
	static final int PORT = 30000;
	public static void main(String[] args)
		throws Exception
	{
		try(

			AsynchronousServerSocketChannel serverChannel =
				AsynchronousServerSocketChannel.open())
		{

			serverChannel.bind(new InetSocketAddress(PORT));
			while (true)
			{

				Future<AsynchronousSocketChannel> future
					= serverChannel.accept();

				AsynchronousSocketChannel socketChannel = future.get();

				socketChannel.write(ByteBuffer.wrap(""
					.getBytes("UTF-8"))).get();
			}
		}
	}
}
