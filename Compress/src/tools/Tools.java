package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

import asset.Asset;

public class Tools {

	public static void main(String[] args) throws IOException {
		String absolutePathToTextFile = Asset.class.getResource("input/Input-File").getPath();
		if (null != absolutePathToTextFile) {
			
		}
	}

	@SuppressWarnings("resource")
	public static String readFile(String absolutePathToTextFile) throws FileNotFoundException, IOException {
		return new Scanner(new File(absolutePathToTextFile), "UTF-8").useDelimiter("\\Z").next();
	}

	public static String readFileJDK7(String path) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}
}
