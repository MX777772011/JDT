package com.devplatform.business.mina.server;

import org.apache.mina.core.session.IoSession;


public interface MessageReceivedImp {
	public void messageReceived(IoSession session, Object message) throws Exception;
}
