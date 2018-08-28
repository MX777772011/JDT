package com.devplatform.business.mina.server;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;

public class MyTextLineDecoder extends CumulativeProtocolDecoder {
	Charset charset = Charset.forName("utf-8");
	IoBuffer buf = IoBuffer.allocate(1024).setAutoExpand(true);
    private static byte ASCII_R = 13;// 回车ASCII
    private static byte ASCII_N = 10;//换行ASCII
	//以\r\n为结尾，处理数据包
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		int start = in.position();
		byte previous = 0;
		while (in.hasRemaining()) {
			byte current = in.get();
			if (previous == ASCII_R && current == ASCII_N) {
				int position = in.position();
				int limit = in.limit();
				try {
					in.position(start);
					in.limit(position);
					out.write(parseString(in.slice()));
				} finally {
					in.position(position);
					in.limit(limit);
				}
				return true;
			}
			previous = current;
		}
		in.position(start);
		return false;
	}
	//转换为字符串
	public String parseString(IoBuffer in) throws Exception {
		byte[] b = new byte[in.limit()];
		in.get(b);
		String message = new String(b, charset);
		return message;
	}

	public void dispose(IoSession arg0) throws Exception {

	}

	public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1) throws Exception {

	}

}
