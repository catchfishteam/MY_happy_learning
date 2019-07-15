package com.shenzk.netty;

import com.shenzk.util.ObjectAndByte;
import com.shenzk.web.domain.User;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class UserEncoder extends MessageToByteEncoder<Object> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
		
		byte[] bytes = null;
		if(msg instanceof User){
			out.writeInt(1);
			User user = (User) msg;
			bytes = ObjectAndByte.objectToByte(user);
		}else {
			out.writeInt(2);
			bytes = msg.toString().getBytes();
		}
		
		if(bytes != null){
			out.writeInt(bytes.length);
			out.writeBytes(bytes);
		}
		
	}

}
