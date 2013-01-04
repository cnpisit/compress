package tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import asset.Asset;

public class MainTestLZ78 {
	public static void main(String[] args) {
		LZ78 lz78 = new LZ78();

		InputStream is, isDecompress;
		OutputStream os, osDecompress;
		String filename = "Lorem-3MB.txt";
		String filePath = Asset.class.getResource("input/" + filename).getPath();

		try {
			is = new FileInputStream(filePath);
			os = new FileOutputStream(new String(filePath + ".lz78"));
			lz78.compress(is, os);

			isDecompress = new FileInputStream(new String(filePath + ".lz78"));
			osDecompress = new FileOutputStream(new String(filePath + ".lz78.decompressed.txt"));
			lz78.decompress(isDecompress, osDecompress);

			System.out.println("Done");
			System.out.println(new String(filePath));
		} catch (Exception e) {
		}
	}
}