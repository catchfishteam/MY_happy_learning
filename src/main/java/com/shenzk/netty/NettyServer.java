package com.shenzk.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyServer {
	
	private final Object await = new Object();
	
	private int port;
	
	public NettyServer(int port){
		this.port = port;
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println(
                    "Usage: " + NettyServer.class.getSimpleName() +
                            " <port>");
            return;
		}
		int port = Integer.parseInt(args[0]);
		new NettyServer(port).start();
	}
	
	public void start(){
		ServerBootstrap boot = new ServerBootstrap();
		EventLoopGroup boss = new NioEventLoopGroup(1);
		EventLoopGroup worker = new NioEventLoopGroup(1);
		try {
			
			boot.group(boss, worker)
				// 这里NioServerSocketChannel.class主要是创建了一个能生产次实体类的工厂类，
				// 在bind方法中能反射实例出对象
				.channel(NioServerSocketChannel.class)
				.handler(new LoggingHandler(LogLevel.INFO))
				.childHandler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel sc) throws Exception {
						sc.pipeline()
									 .addLast("decoder", new UserDecoder())
//									 .addLast("encoder", new UserEncoder())
//									 .addLast("aggregator", new HttpObjectAggregator(512*1024))
//								     .addLast(new ObjectDecoder(1024 * 1024, ClassResolvers   // 添加对象解码器，负责对序列化POJO对象解码，设置最大序列化的为1M，防止内存溢出
//								    		 		.weakCachingConcurrentResolver(this.getClass().getClassLoader())))
								     .addLast(new ObjectEncoder())
//									 .addLast(new StringDecoder())
//									 .addLast(new StringEncoder())
									 .addLast(new ServerOutHandler())
									 .addLast("handler", new NettyHandler())
									 ;
					}
				})
				.option(ChannelOption.SO_BACKLOG, 128)
				.childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
			
			// bind方法实例了一个NioServerSocketChannel对象并绑定在本地的端口上
			ChannelFuture future = boot.bind(port).sync();
			future.channel().closeFuture().sync();
			future.awaitUninterruptibly();
			if(!future.isSuccess()){
				System.out.println("NettyServer start failed... Retory in 5 seconds");
				boss.shutdownGracefully();
				worker.shutdownGracefully();
				future.channel().close();
				worker = null;
				boot = null;
				future = null;
				
				synchronized (await) {
					await.wait(5000);
				}
				
				start();
				
			}else{
				System.out.println("NettyServer started...");
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("NettyServer start Exception...");
		}
	}

}
