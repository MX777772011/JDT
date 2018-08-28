package com.devplatform.business.mina.Clint;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.devplatform.common.utils.SpringContextUtil;
public class ClintTest {

	public static void main(String[] args) throws Exception {
		  // 创建客户端连接器. 
        NioSocketConnector connector = new NioSocketConnector(); 
        connector.getFilterChain().addLast( "logger", new LoggingFilter() ); 
        connector.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory(Charset.forName( "utf-8" )))); //设置编码过滤器 
        //HandlerAdapter handlerAdapter = (HandlerAdapter) SpringContextUtil.getBean("handlerAdapter");
        connector.setHandler(new HandlerAdapter());//设置事件处理器 
        ConnectFuture cf = connector.connect( 
        new InetSocketAddress("127.0.0.1", 8379));//建立连接 
        cf.awaitUninterruptibly();//等待连接创建完成 
        
        IoSession session =  cf.getSession();
        StringBuilder message = new StringBuilder();
        StringBuilder message2 = new StringBuilder();
         /**
          * 1  
          */
//        message.append("{\"sn\":\"BC0008ABEF112233\",\"cmd\":\"reg\",\"timestamp\":\"1508845817\" ,\"rand\":\"35\" ,\"sign\":\"055d764058ea64f7a65d68f8375d77f1\",\"data\":\"xxxxxxxxxxxxxxxxx\"}\r\n");
//        message.append("{\"sn\":\"BC0008ABEF112233\",\"cmd\":\"reg\",\"timestamp\":\"1508845817\" ,\"rand\":\"35\" ,\"sign\":\"055d764058ea64f7a65d68f8375d77f1\",\"data\":\"xxxxxxxxxxxxxxxxx\"}\r\n");
//        message.append("{\"sn\":\"BC0008ABEF112233\",\"cmd\":\"reg\",\"timestamp\":\"1508845817\" ,\"rand\":\"35\" ,\"sign\":\"055d764058ea64f7a65d68f8375d77f1\",\"data\":\"xxxxxxxxxxxxxxxxx\"}\r\n");
        
        /**
         * 2
         */
        message.append("{\"sn\":\"a111111111111\",\"cmd\":\"reg\",\"timestamp\":\"1508845817\" ,\"rand\":\"35\" ,\"sign\":\"055d764058ea64f7a65d68f8375d77f1\",\"data\":\"xxxxxxxxxxxxxxxxx\"}\r\n");
        message.append("{\"sn\":\"a222222222222\",\"cmd\":\"reg\",\"timestamp\":\"1508845817\" ,\"rand\":\"35\" ,\"sign\":\"055d764058ea64f7a65d68f8375d77f1\",\"data\":\"xxxxxxxxxxxxxxxxx\"}\r\n");
        message.append("{\"sn\":\"a333333333333\",\"cmd\":\"reg\",");
        session.write(message.toString());
        System.out.println(".....................................................................");
        Thread.sleep(15000);
        message2.append("\"timestamp\":\"1508845817\" ,\"rand\":\"35\" ,\"sign\":\"055d764058ea64f7a65d68f8375d77f1\",\"data\":\"xxxxxxxxxxxxxxxxx\"}\r\n");     
        message2.append("{\"sn\":\"a4444444444444\",\"cmd\":\"reg\",\"timestamp\":\"1508845817\" ,\"rand\":\"35\" ,\"sign\":\"055d764058ea64f7a65d68f8375d77f1\",\"data\":\"xxxxxxxxxxxxxxxxx\"}\r\n");
        session.write(message2.toString());
        
        /**
         * 3
         */
//        message.append("{\"sn\":\"BC0008ABEF112233\",\"cmd\":\"reg\",");
//        session.write(message.toString());
//        Thread.sleep(15000);
//        message2.append("\"timestamp\":\"1508845817\" ,\"rand\":\"35\" ,\"sign\":\"055d764058ea64f7a65d68f8375d77f1\",\"data\":\"xxxxxxxxxxxxxxxxx\"}\r\n"); 
//        session.write(message2.toString());
      //  cf.getSession().write("client ...test data mina ......\r\n");//发送消息 
       // session.write(message.toString());
        cf.getSession().close(true);
        cf.getSession().getCloseFuture().awaitUninterruptibly();//等待连接断开 
        connector.dispose();

	}

}
