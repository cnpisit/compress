package tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import asset.Asset;

public class MainTestLZW {
	public static void main(String[] args) {
		LZW lzw = new LZW();

		InputStream is, isDecompress;
		OutputStream os, osDecompress;
		String filename = "Input-File.txt";
		String filePath = Asset.class.getResource("input/"+filename).getPath();
		
		
		try {
			is = new FileInputStream(filePath);
			os = new FileOutputStream(new String(filePath + ".lzw"));
			lzw.compress(is, os);
			os.close(); is.close();
			
			isDecompress = new FileInputStream(new String(filePath + ".lzw"));
			osDecompress = new FileOutputStream(new String(filePath + ".lzw.decompressed.txt"));
			lzw.decompress(isDecompress, osDecompress);
			
			System.out.println("Done");
			System.out.println(new String(filePath));
		} catch (Exception e) {
		}
	}
}