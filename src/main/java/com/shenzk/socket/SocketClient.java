package com.shenzk.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("127.0.0.1", 8080);
		socket.getOutputStream().write("hi server".getBytes("utf-8"));
		socket.shutdownOutput();
		
		InputStream  iStream = socket.getInputStream();
		StringBuilder msg = new StringBuilder();
		int len;
		byte[] bytes = new byte[1024];
		while((len = iStream.read(bytes)) != -1){
			msg.append(new String(bytes ,0 ,len , "utf-8"));
		}
		System.out.println("server back : "+msg.toString());
		iStream.close();
		socket.close();
		
	}
	
}
