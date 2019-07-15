package com.shenzk.base.java8;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentMap {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put("foo", "bar");
		map.put("han", "solo");
		map.put("r2", "d2");
		map.put("c3", "p0");
//		testForeach(map);
//		testSearch(map);
//		testSearchValues(map);
		testReduce(map);
	}

	
	public static void testForeach(ConcurrentHashMap<String, String> map){
		map.forEach((k, v) -> System.out.printf("%s = %s \n",k, v));
	}

	// search：当匹配到了一个返回结果就不会往下搜索了
	// 返回结果
	// main
	// ForkJoinPool.commonPool-worker-4
	// main
	// foo
	public static void testSearch(ConcurrentHashMap<String, String> map){
		String result = map.search(1, (key, value) -> {
			System.out.println(Thread.currentThread().getName());
			if("bar".equals(value)){
				return key;
			}
			return null;
		});

		System.out.println(result);
	}

	// searchValues:只搜索映射中的值
	// 返回结果
	// main
	// main
	// ForkJoinPool.commonPool-worker-1
	// bar
	public static void testSearchValues(ConcurrentHashMap<String, String> map){
		String result = map.searchValues(1, value -> {
			System.out.println(Thread.currentThread().getName());
			if("bar".equals(value)){
				return value;
			}
			return null;
		});
		System.out.println(result);
	}

	// 在java8流中就使用过的reduce
	// 两个 BiFunction
	// 第一个将map中的键值对变为单一值
	// 第二个将所有值合并为一个
	public static void testReduce(ConcurrentHashMap<String, String> map){
		String result = map.reduce(1,
				(k, v) -> {
					return k+"-"+v;
				},
				(s1, s2) -> {
					return s1+" , "+s2;
				});
		System.out.println(result);
	}
}
