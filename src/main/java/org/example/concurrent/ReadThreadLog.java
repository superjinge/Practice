package org.example.concurrent;

import lombok.SneakyThrows;

/**
 * java类作用描述
 *
 * @author superjinge
 * @date 2022/11/28  21:26
 */
public class ReadThreadLog {
	public static void main(String[] args) {
		new Thread(new TimeWaiting(), "TimeWaiting").start();
		new Thread(new Waiting(), "Waiting").start();
		new Thread(new Block(), "Block01").start();
		new Thread(new Block(), "Block02").start();
	}
}

class Waiting implements Runnable {
	
	@Override
	public void run() {
		while (true) {
			synchronized (Waiting.class) {
				try {
					Waiting.class.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}

class TimeWaiting implements Runnable {
	@SneakyThrows
	@Override
	public void run() {
		while (true) {
			Thread.sleep(5000000);
		}
	}
}

class Block implements Runnable {
	
	@SneakyThrows
	@Override
	public void run() {
		synchronized (Block.class) {
			while (true) {
				Thread.sleep(50000000);
			}
		}
	}
}
