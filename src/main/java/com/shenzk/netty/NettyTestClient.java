package com.shenzk.netty;

public class NettyTestClient {
	
	public static void main(String[] args) {
		
		NettyClient client = new NettyClient();
		client.connect("localhost", 8080);
		
	}

}
