package org.wenrong.netty.server;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        serverBootstrap.setFactory(new NioServerSocketChannelFactory(boss,worker));

        serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {

                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder",new StringDecoder());
                pipeline.addLast("encoder",new StringEncoder());
                pipeline.addLast("helloHandler",new SimpleChannelHandler(){

                    @Override
                    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

                        String message = (String) e.getMessage();

                        System.out.println(message);

                        ctx.getChannel().write("hi");

                        super.messageReceived(ctx, e);
                    }


                    @Override
                    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
                        System.out.println("exceptionCaught");
                        super.exceptionCaught(ctx, e);
                    }

                    @Override
                    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
                        System.out.println("channelConnected");
                        super.channelConnected(ctx, e);
                    }

                    @Override
                    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
                        System.out.println("channelClosed");
                        super.channelClosed(ctx, e);
                    }

                    @Override
                    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
                        System.out.println("channelDisconnected");
                        super.channelDisconnected(ctx, e);
                    }


                });

                return pipeline;
            }
        });

        serverBootstrap.bind(new InetSocketAddress(8080));

    }
}
