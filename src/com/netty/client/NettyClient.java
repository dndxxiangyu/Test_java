package com.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-29 下午2:41:29
 */
public class NettyClient {
	private ChannelFuture channelFuture = null;
	private EventLoopGroup group = new NioEventLoopGroup(100);
	private String host;
	private int port;
	private Bootstrap bootstrap;
	
	/**
	 * 创建一个新的实例NettyClient.
	 * <p>
	 * {详述}
	 */
	public NettyClient() {
		init();
	}
	private void init(){
		bootstrap = new Bootstrap();
		bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true);
		bootstrap.handler(new ChannelInitializer<Channel>() {
			@Override
			protected void initChannel(Channel ch) throws Exception {
				ch.pipeline().addLast();
			}
		});
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
	}
	public boolean connect(String host, int port) {
		// TODO Auto-generated method stub
		this.host = host;
		this.port = port;
		if (channelFuture != null) {
			channelFuture.channel().closeFuture().awaitUninterruptibly();
		}
		channelFuture = bootstrap.connect(host, port);
		channelFuture.awaitUninterruptibly(5000);
		if (channelFuture.isSuccess()) {
			return true;
		}
		return false;
	}
	public boolean send(String message) {
		if (null != channelFuture && null != channelFuture.channel()) {
			channelFuture.channel().writeAndFlush(message);
			return true;
		} else {
//			log.warn("消息发送失败,与[{}:{}]连接尚未建立!", host, port);
			return false;
		}
	}
}
