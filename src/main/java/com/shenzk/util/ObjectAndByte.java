package com.shenzk.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectAndByte {
	
	/**
	 * 对象转数组
	 * @param object
	 * @return
	 */
	public static byte[] objectToByte(Object object){
		
		byte[] bytes = null;
		ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(byteOS);
			oos.writeObject(object);
			oos.flush();
			bytes = byteOS.toByteArray();
			oos.close();
			byteOS.close();
			
		} catch (Exception e) {
			System.out.println("object to byte ERROR");
		}
		
		return bytes;
	}
	
	/**
	 * 数组转对象
	 * @param bytes
	 * @return
	 */
	public static Object byteToObject(byte[] bytes){
		
		Object obj= null;
		ByteArrayInputStream byteIS = new ByteArrayInputStream(bytes);
		try {
			
			ObjectInputStream ois = new ObjectInputStream(byteIS);
			obj = ois.readObject();
			ois.close();
			byteIS.close();
			
		} catch (Exception e) {
			System.out.println("byte to ojbect ERROR");
		}
		
		return obj;
	}

}
