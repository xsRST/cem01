package com.shsxt.crm.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author 殇丶无求
 */
public class Md5Util {
	
	public static String  encode(String msg){
		 try {
			MessageDigest messageDigest=MessageDigest.getInstance("md5");
			return Base64.encodeBase64String(messageDigest.digest(msg.getBytes())) ;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		 return null;
	}

	public static String  decode(String msg){
		try {
			MessageDigest messageDigest=MessageDigest.getInstance("md5");
			return new String(Base64.decodeBase64(messageDigest.digest(msg.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(encode("123456"));
		System.out.println(decode("lueSGJZetyySpUndWjMBEg=="));
	}

}
