package com.devplatform.business.mina.server;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

//编码工厂
public class ServerCodeFactory implements ProtocolCodecFactory {
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		 
		return new MyTextLineDecoder();
	}

	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		return new MyTextLineEncoder();
	}
}
