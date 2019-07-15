package com.shenzk.base.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import com.shenzk.util.ConcurrentUtils;

public class TestAtomic {
	
	public static void main(String[] args) {
		testAtomic();
	}
	
	public static void testAtomic(){
		AtomicInteger sum = new AtomicInteger();
		ExecutorService executors = Executors.newFixedThreadPool(4);
		IntStream.range(0, 1000)
			.forEach(i -> executors.submit(sum::incrementAndGet));
		ConcurrentUtils.stop(executors);
		System.out.println(sum);
	}

}
