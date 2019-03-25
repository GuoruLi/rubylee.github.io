package com.thread;

public class ReorderExample {
	int a = 0;
	boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		final ReorderExample reorder = new ReorderExample();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				reorder.writer();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				reorder.reader();
			}
		});
		t1.start();
		t2.start();

	}

	public void writer() {
		a = 1; // 1
		flag = true; // 2
	}

	public void reader() {
		int i = a;
		if (flag) { // 3
			i = a * a; // 4
		}
		System.out.print(i);
	}
}
