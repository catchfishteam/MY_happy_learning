package com.shenzk.netty;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.shenzk.web.domain.User;

public class NettyTestServer {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
			
		NettyServer server = new NettyServer(8080);
		server.start();
	
	}
	
	public static void test1() throws UnknownHostException, IOException{
		Socket socket = new Socket("localhost", 8081);
		User user = new User("Team1", 1, "2019-04-22 19:00:00");
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(user);
		OutputStream os = socket.getOutputStream();
		os.write(bo.toByteArray());
		
		InputStream iStream = socket.getInputStream();
		byte[] bytes = new byte[10];
		int len;
		StringBuilder sb = new StringBuilder();
		while((len = iStream.read(bytes)) != -1){
			sb.append(new String(bytes, 0, len, "UTF-8"));
		}
		System.out.println("客户端接受消息："+sb.toString());
		
		
		socket.shutdownOutput();
		socket.close();
	}
	
	public static void test2(){
		
	}

}
