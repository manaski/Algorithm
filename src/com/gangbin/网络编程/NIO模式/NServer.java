package com.gangbin.网络编程.NIO模式;

import java.net.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
public class NServer
{
	//
	private Selector selector = null;
	static final int PORT = 30000;
	//定义字符集
	private Charset charset = Charset.forName("UTF-8");
	public void init()throws IOException
	{
		selector = Selector.open();
		// ͨ打开channel实例
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
		// 绑定一个inetSocketAddress
		server.bind(isa);
		// 配置channel为非阻塞
		server.configureBlocking(false);
		// 把channel注册到选择器上，这里配置连接类型
		server.register(selector, SelectionKey.OP_ACCEPT);
		while (selector.select() > 0)
		{
			// 当有channel需要处理IO时
			for (SelectionKey sk : selector.selectedKeys())
			{
				// 删除正在处理的SelectionKey
				selector.selectedKeys().remove(sk);
				// 如果是连接请求
				if (sk.isAcceptable())
				{
					// 获得一个SocketChannel
					SocketChannel sc = server.accept();
					// 配置为非阻塞
					sc.configureBlocking(false);
					// 注册到选择器
					sc.register(selector, SelectionKey.OP_READ);
					// 再次接受其他请求
					sk.interestOps(SelectionKey.OP_ACCEPT);
				}
				// 有数据读取
				if (sk.isReadable())
				{
					// 获得channel
					SocketChannel sc = (SocketChannel)sk.channel();
					System.out.println("接受到一个连接");
					// ByteBuffer
					ByteBuffer buff = ByteBuffer.allocate(1024);
					String content = "";
					try
					{
						//读取到buffer中
						while(sc.read(buff) > 0)
						{
							buff.flip();//读取完毕
							content += charset.decode(buff);//转码
							System.out.println(content);
						}
						//继续接受其他连接
						sk.interestOps(SelectionKey.OP_READ);
					}
					catch (IOException ex)
					{
						sk.cancel();
						if (sk.channel() != null)
						{
							sk.channel().close();
						}
					}

					if (content.length() > 0)
					{
						//
						for (SelectionKey key : selector.keys())
						{
							// 从key获得channel
							Channel targetChannel = key.channel();
							//
							if (targetChannel instanceof SocketChannel)
							{
								//
								SocketChannel dest = (SocketChannel)targetChannel;
								dest.write(charset.encode(content));
							}
						}
					}
				}
			}
		}
	}
	public static void main(String[] args)
		throws IOException
	{
		new NServer().init();
	}
}
