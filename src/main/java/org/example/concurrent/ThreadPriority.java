package org.example.concurrent;

/**
 * 线程优先级
 *
 * @author superjinge
 * @date 2022/11/28  14:06
 */
public class ThreadPriority {
	
	public static void main(String[] args) {
		
		MyThread thread1 = new MyThread("t1");
		MyThread thread2 = new MyThread("t2");
		thread1.setPriority(1);
		thread1.setDaemon(true);
		thread2.setPriority(10);
		thread1.start();
		thread2.start();
	}
	
}

class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		for (int i = 0; i < 5; i++) {
			System.out.println(thread.getName() + "_" + thread.getPriority() + "_" + i);
		}
	}
}
