package com.sinokj.code.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class IOUtils {
	public static final Charset UTF8_CHARSET = Charset.forName("utf-8");

	public static byte[] readBytesFromStream(InputStream in) throws IOException {
		int i = in.available();
		if (i < 4096) {
			i = 4096;
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream(i);
		copy(in, bos);
		in.close();
		return bos.toByteArray();
	}

	public static int copy(InputStream input, OutputStream output)
			throws IOException {
		return copy(input, output, 4096);
	}

	public static int copy(InputStream input, OutputStream output,
			int bufferSize) throws IOException {
		int avail = input.available();
		if (avail > 262144) {
			avail = 262144;
		}
		if (avail > bufferSize) {
			bufferSize = avail;
		}
		byte[] buffer = new byte[bufferSize];
		int n = 0;
		n = input.read(buffer);
		int total = 0;
		while (-1 != n) {
			if (n == 0) {
				throw new IOException(
						"0 bytes read in violation of InputStream.read(byte[])");
			}
			output.write(buffer, 0, n);
			total += n;
			n = input.read(buffer);
		}
		return total;
	}

}