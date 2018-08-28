package com.devplatform.business.mina.server;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import com.devplatform.business.mina.server.entity.MessageEntity;
import com.devplatform.business.utils.JsonUtil;

/**
 * 接受信息服务
 *
 */
public class ServerHandler implements IoHandler {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	public void exceptionCaught(IoSession session, Throwable arg1)
			throws Exception {
		 
		logger.warn("服务器启动发生异常have a exception : " + arg1.getMessage());
		 
	}
    /**
     * 接受数据包
     */
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		MessageEntity messageEntity = (MessageEntity) JsonUtil.getObjectFromJsonString((String) message, MessageEntity.class);
		MessageHandler.handle(messageEntity, session);
	}

	public void messageSent(IoSession session, Object message) throws Exception {
		logger.info("服务器成功发送信息: " + message.toString());
	}

	public void sessionClosed(IoSession session) throws Exception {
		logger.info("there is a session closed");
		CloseFuture future = session.close(true);
		future.addListener(new IoFutureListener() {
			public void operationComplete(IoFuture future) {
				if (future instanceof CloseFuture) {
					((CloseFuture) future).setClosed();
					logger.info("have do the future set to closed");
				}
			}
		});
	}

	public void sessionCreated(IoSession session) throws Exception {
		 
		logger.info("there is a session created");
	 
	}

	public void sessionIdle(IoSession session, IdleStatus arg1)
			throws Exception {
		 
		logger.info(session.getId() + "(SesssionID) is idle in the satate-->"+ arg1);
	}

	public void sessionOpened(IoSession arg0) throws Exception {
		 

	}
	
	public void initServer(){
		logger.info("。。。。。。。接受器服务器启动。。。。。。。。");
	}

}
