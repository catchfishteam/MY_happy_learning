package com.shenzk.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(8080);
		System.out.println("server started...");
		Socket socket = server.accept();
		InputStream iStream = socket.getInputStream();
		byte[] bytes = new byte[1024];
		StringBuilder msg = new StringBuilder();
		int len;
		while((len = iStream.read(bytes)) != -1){
			msg.append(new String(bytes, 0, len, "utf-8"));
		}
		System.out.println("accept msg : "+msg.toString());
		
		OutputStream oStream = socket.getOutputStream();
		oStream.write("server accept ...".getBytes("utf-8"));
		oStream.close();
		iStream.close();
		socket.close();
		server.close();
		
	}
	
}
