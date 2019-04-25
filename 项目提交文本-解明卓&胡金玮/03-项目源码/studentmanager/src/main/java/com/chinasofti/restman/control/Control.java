package com.chinasofti.restman.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Control {
	private ServerSocket server;
	private static final int port = 9999;
	// 线程池对象
	private ExecutorService es;
	//被代理对象
	private SMSservice service;

	public Control() {
		super();
		try {
			server = new ServerSocket(port);
			System.out.println("服务器已启动！");
			es = Executors.newCachedThreadPool();
			this.service = new SMSserviceImpl();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 流程
	public void start() {
		while (true) {
			try {
				Socket client = this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"已连接");
				// 创建线程对象
				ControlThread serverThread = new ControlThread(client, service);
				es.submit(serverThread);
				System.out.println("当前在线活跃用户：" + ((ThreadPoolExecutor)es).getActiveCount());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
