package com.chinasofti.restman.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class ControlThread extends Thread {
	private Socket client;
	// 被代理的对象
	private Object o;

	public ControlThread(Socket client, Object o) {
		super();
		this.client = client;
		this.o = o;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
			// 获取方法名称 参数类型列表 参数列表
			String methodName = ois.readUTF();
			Class<?>[] methodTypes = (Class<?>[]) ois.readObject();
			Object[] methodParams = (Object[]) ois.readObject();
			// 获取方法对象
			Method method = o.getClass().getMethod(methodName, methodTypes);
			Object result = method.invoke(o, methodParams);
			// 返回输出结果
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			oos.writeObject(result);
			oos.flush();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}