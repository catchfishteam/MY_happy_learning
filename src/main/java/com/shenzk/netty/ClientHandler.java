package com.shenzk.netty;

import com.shenzk.web.domain.User;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class ClientHandler extends ChannelOutboundHandlerAdapter {
	
	
	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		if(msg instanceof String){
			System.out.println("client outbound...");
			ctx.channel().writeAndFlush(msg);
		}
		
	}

}
