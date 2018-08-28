package com.devplatform.business.mina.server.heart;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;

public class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	/*
	 * 心跳超时 关闭连接
	 */
	@Override
	public void keepAliveRequestTimedOut(KeepAliveFilter filter, IoSession session) throws Exception {
		System.out.println("心跳超时！  there is a session closed");
		// TODO Auto-generated method stub
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
}
