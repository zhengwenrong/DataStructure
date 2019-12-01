package org.wenrong.netty.client;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {

        ClientBootstrap clientBootstrap = new ClientBootstrap();
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        clientBootstrap.setFactory(new NioClientSocketChannelFactory(boss,worker));

        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {

                ChannelPipeline pipeline = Channels.pipeline();

                pipeline.addLast("decoder",new StringDecoder());
                pipeline.addLast("encoder",new StringEncoder());
                pipeline.addLast("hiHandler",new SimpleChannelHandler(){

                    @Override
                    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
                        String s = (String) e.getMessage();
                        System.out.println(s);
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
                    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
                        System.out.println("channelDisconnected");
                        super.channelDisconnected(ctx, e);
                    }

                    @Override
                    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
                        System.out.println("channelClosed");
                        super.channelClosed(ctx, e);
                    }
                });
                return pipeline;
            }
        });

        ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 8080));

        Channel channel = connect.getChannel();

        System.out.println("client start");

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 10;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(int j = 0; j < 100; j++){

                        channel.write("hello " + j);

                    }

                }
            }).start();

        }


    }


}
