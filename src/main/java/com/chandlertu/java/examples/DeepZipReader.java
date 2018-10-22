package com.chandlertu.java.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeepZipReader {

	public void unzip(String path) {
		try (ZipInputStream in = new ZipInputStream(new BufferedInputStream(new FileInputStream(path)))) {
			unzip(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void unzip(ZipInputStream in) {
		try {
			ZipEntry entry;
			while ((entry = in.getNextEntry()) != null) {
				if (entry.getName().endsWith(".zip")) {
					unzip(new ZipInputStream(in));
				} else {
					unzip(entry, in);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void unzip(ZipEntry entry, ZipInputStream in) {
		int bufferSize = 8192;
		try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(entry.getName()), bufferSize)) {
			byte b[] = new byte[bufferSize];
			int off = 0;
			int len;
			while ((len = in.read(b, off, bufferSize)) != -1) {
				out.write(b, off, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
