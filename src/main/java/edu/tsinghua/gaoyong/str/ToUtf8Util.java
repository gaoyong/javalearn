package edu.tsinghua.gaoyong.str;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ToUtf8Util {
	
	public static String toHexString(String s) 
	{ 
	String str=""; 
	for (int i=0;i<s.length();i++) 
	{ 
	int ch = (int)s.charAt(i); 
	String s4 = Integer.toHexString(ch); 
	str = str + s4; 
	} 
	return str; 
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" +ToUtf8Util.toHexString("大连"));
		try {
			System.out.println("" + URLEncoder.encode("大连","utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
