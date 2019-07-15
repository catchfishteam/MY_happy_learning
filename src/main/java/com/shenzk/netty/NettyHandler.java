package com.shenzk.netty;

import com.shenzk.util.ObjectAndByte;
import com.shenzk.web.domain.User;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		
		System.out.println("nettyserver handler...");
		System.out.println("msg instanceof: "+(msg instanceof String));
		try{
			if (msg instanceof User) {
				System.out.println("NettyHandler --->  msg instanceof User");
				User user = (User) msg;
				if (user.getFinishNum() > 0) {
					ctx.write(user);
				}
			}else if (msg instanceof String) {
				System.out.println("server channelRead : "+msg);
				ctx.write("hi, i accept the String");
			} else if (msg instanceof MsgInBoundTransforObject) {
				MsgInBoundTransforObject object = (MsgInBoundTransforObject) msg;
				if( "User".equals(object.getFlag()) ){
					User user = (User) ObjectAndByte.byteToObject(object.getBytes());
					System.out.println("User: "+user.toString());
					ctx.write("yes, i accept the User");
				}else if ( "String".equals(object.getFlag()) ) {
					System.out.println("String: "+object.getBytes().toString());
					ctx.write("yes, i accept the String");
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelInactive:  " + ctx.channel());
		// ctx.fireChannelInactive();
	}
	

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

	
//
//	@Override
//	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//		// 出现异常
//		System.out.println("NettyHandler Exception");
//	}

}
