package com.chandlertu.java.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ZipXmlReader {

	public static void main(String[] args) {
		Path path = Paths.get("results", "5710_39_2339227_17_40000_20170914132234.788.zip");

		try (ZipInputStream in = new ZipInputStream(new BufferedInputStream(new FileInputStream(path.toFile())))) {
			unzip(in);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void unzip(ZipInputStream in) {
		try {
			ZipEntry entry;
			while ((entry = in.getNextEntry()) != null) {
				if (entry.getName().equals("Resources.xml")) {

					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					try {
						DocumentBuilder builder = factory.newDocumentBuilder();
						Document doc = builder.parse(in);

						Element element = doc.getDocumentElement();
						System.out.println(element.getNodeName());

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void unzip(ZipEntry entry, ZipInputStream in) {
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
