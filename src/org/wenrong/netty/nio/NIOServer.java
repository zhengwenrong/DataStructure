package org.wenrong.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NIOServer {

    private Selector selector;

    public void initServer(int port) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        this.selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }


    public void listen() throws IOException{

        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();

            while (iterator.hasNext()){

                SelectionKey key = iterator.next();
                iterator.remove();
                handler(key);
            }

        }


    }

    private void handler(SelectionKey key) throws IOException {

        // 是客户端连接请求
        if(key.isAcceptable()){
            handlerAccept(key);
        }else if(key.isReadable()){

            handlerRead(key);

        }

    }

    /**
     * 处理读请求
     * @param key
     */
    private void handlerRead(SelectionKey key) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        int read = channel.read(allocate);

        if (read > 0 ){
            byte[] array = allocate.array();
            String trim = new String(array).trim();
            System.out.println("服务端收到消息" + trim);
            //回写数据
            ByteBuffer outBuffer = ByteBuffer.wrap("好的".getBytes());
            channel.write(outBuffer);// 将消息回送给客户端
        } else {
            System.out.println("客户端关闭");
            key.cancel();
        }
    }

    /**
     * 处理连接请求
     * @param key
     */
    private void handlerAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel channel = server.accept();
        channel.configureBlocking(false);
        channel.register(this.selector,SelectionKey.OP_READ);
    }

    public static void main(String[] args) throws IOException {

        NIOServer server = new NIOServer();
        server.initServer(8081);

        server.listen();

    }


}
