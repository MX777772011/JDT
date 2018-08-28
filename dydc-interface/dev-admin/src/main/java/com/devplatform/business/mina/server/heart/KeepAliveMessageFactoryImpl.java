package com.devplatform.business.mina.server.heart;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

public class KeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	/** 心跳包内容 */
	private static final String HEARTBEATREQUEST = "q";// heartbeatrequest
	private static final String HEARTBEATRESPONSE = "p";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.mina.filter.keepalive.KeepAliveMessageFactory#getRequest
	 * (org.apache.mina.core.session.IoSession)
	 */
	@Override
	public Object getRequest(IoSession session) {
		return HEARTBEATREQUEST;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.mina.filter.keepalive.KeepAliveMessageFactory#getResponse
	 * (org.apache.mina.core.session.IoSession, java.lang.Object)
	 */
	@Override
	public Object getResponse(IoSession session, Object request) {

		return HEARTBEATRESPONSE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.mina.filter.keepalive.KeepAliveMessageFactory#isRequest
	 * (org.apache.mina.core.session.IoSession, java.lang.Object)
	 */
	@Override
	public boolean isRequest(IoSession session, Object message) {

		if (message.equals(HEARTBEATREQUEST))
			return true;

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.mina.filter.keepalive.KeepAliveMessageFactory#isResponse
	 * (org.apache.mina.core.session.IoSession, java.lang.Object)
	 */
	@Override
	public boolean isResponse(IoSession session, Object message) {

		if (message.equals(HEARTBEATRESPONSE))
			return true;
		return false;
	}
}
