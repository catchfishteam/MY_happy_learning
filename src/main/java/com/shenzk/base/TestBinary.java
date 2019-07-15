package com.shenzk.base;

public class TestBinary {

	public static void main(String[] args) {
//		test1();
		switchNum();
	}
	
	/**
	 * 使用位运算来计算一个数能否被2整除
	 */
	public static void test1(){
		int n = 4;
		if((n&(n-1)) == 0){
			System.out.println((n&(n-1))+"=0");
		}else {
			System.out.println("!=0");
		}
	}
	
	/**
	 * 使用位运算来转换两个变量的值
	 */
	public static void switchNum(){
		int a = 5;
		int b = 6;
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("a:"+a);
		System.out.println("b:"+b);
	}
	
}
