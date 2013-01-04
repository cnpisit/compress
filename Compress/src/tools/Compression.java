package tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Compression {
	public void compress(InputStream inp, OutputStream out) throws IOException;
	public void decompress(InputStream inp, OutputStream out) throws IOException;
}