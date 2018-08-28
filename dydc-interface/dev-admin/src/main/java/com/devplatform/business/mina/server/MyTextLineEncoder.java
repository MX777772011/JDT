package com.devplatform.business.mina.server;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class MyTextLineEncoder implements ProtocolEncoder {
	Charset charset = Charset.forName("utf-8");

	public void dispose(IoSession session) throws Exception {
		 

	}

	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput output) throws Exception {

		if (message == null) {
			output.write("");
		}

		
		IoBuffer buf = IoBuffer.allocate(1024).setAutoExpand(true);

		buf.putString(message.toString(), charset.newEncoder());

//		 buf.putString(LineDelimiter.DEFAULT.getValue(),
//		 charset.newEncoder());
		buf.flip();

		output.write(buf);

	}
}
