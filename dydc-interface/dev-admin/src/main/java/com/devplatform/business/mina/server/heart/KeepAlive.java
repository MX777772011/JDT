package com.devplatform.business.mina.server.heart;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;

public class KeepAlive extends KeepAliveFilter {
	public KeepAlive(KeepAliveMessageFactory messageFactory, KeepAliveRequestTimeoutHandler heartBeatHandler,
			int HEARTBEATRATE, int keepAliveRequestTimeout) {
		super(messageFactory, IdleStatus.BOTH_IDLE, heartBeatHandler);

		this.setForwardEvent(true);
		this.setRequestTimeout(keepAliveRequestTimeout);
		/** 15秒发送一次心跳包 */
		this.setRequestInterval(HEARTBEATRATE);//
	}
}
