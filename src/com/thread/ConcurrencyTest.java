package com.thread;

public class ConcurrencyTest {
	private static final long count = 1000l;
	
	public static void main(String[] args) throws InterruptedException{
		//测试并发执行与串行执行的速度
		concurrency();
		serial();
	}

	private static void serial() {
		long start = System.currentTimeMillis();
		int a = 0;
		for(long i = 0; i < count; i++){
			a += 5;
		}
		int b = 0; 
		for(long i = 0; i < count; i++){
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.out.print("serial : " + time + "ms, b = " + b + ", a = " + a + "\n");
	}

	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int a = 0;
				for(long i = 0; i < count; i++){
					a += 5;
				}
			}
		});
		thread.start();//线程就绪，等待执行
		int b = 0; 
		for(long i = 0; i < count; i++){
			b--;
		}
		long time = System.currentTimeMillis() - start;
		thread.join();//当前线程让thread线程先执行
		System.out.print("concurrency : " + time + "ms, b = " + b + "\n");
	}
}
