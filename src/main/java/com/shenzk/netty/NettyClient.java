package com.shenzk.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyClient {
	
	public void connect(String host, int port){
		
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			
			Bootstrap b = new Bootstrap();
			b.group(group)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new ObjectDecoder(1024, ClassResolvers.cacheDisabled(this
									.getClass().getClassLoader())))
//											.addLast("decoder", new UserDecoder())
											.addLast("encoder", new UserEncoder())
											.addLast(new ObjectDecoder(1024 * 1024, ClassResolvers   // 添加对象解码器，负责对序列化POJO对象解码，设置最大序列化的为1M，防止内存溢出
								    		 		.weakCachingConcurrentResolver(this.getClass().getClassLoader())))
//											.addLast(new ObjectEncoder())
//											.addLast(new StringDecoder())
//											.addLast(new StringEncoder())
											.addLast(new ClientInHandler())
//											.addLast(new ClientHandler())
											;
							
						}
					});
			ChannelFuture future = b.connect(host, port).sync();
			
			future.channel().closeFuture().sync();
			
		} catch (Exception e) {
			group.shutdownGracefully();
			System.out.println(e);
			System.out.println("听说这样释放线程是优雅的...");
		}
		
	}

}
