package com.shenzk.netty;

import com.shenzk.web.domain.User;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientInHandler extends ChannelInboundHandlerAdapter{
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		String msg = "hello world";
		User user = new User("userName", 1, "lastTime");
		ctx.write(user);
		ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if(msg instanceof String){
			System.out.println("server said: "+msg);
//			ctx.channel().writeAndFlush(msg);
		}
	}
	
}
