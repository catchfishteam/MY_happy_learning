package com.shenzk.netty;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class UserDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		
		int flag = in.readInt();
		int msgLength = in.readInt();
		byte[] bytes = new byte[msgLength];
		System.out.println("flag: "+flag+" , msglength: "+msgLength);
		MsgInBoundTransforObject msg = new MsgInBoundTransforObject();
		if(flag == 1){   // User
			msg.setFlag("User");
		}else if(flag == 2){   // String
			msg.setFlag("String");
		}

		if(msgLength == in.readableBytes()){
			in.readBytes(bytes);
			msg.setBytes(bytes);
			out.add(msg);
		}else{
			System.out.println("decode failed...");
		}
		
	}

}
