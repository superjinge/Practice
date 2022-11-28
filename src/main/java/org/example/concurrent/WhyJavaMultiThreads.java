package org.example.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * java类作用描述
 *
 * @author superjinge
 * @date 2022/11/21  21:39
 */
public class WhyJavaMultiThreads {
	public static void main(String[] args) throws InterruptedException {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
		}
		Thread.sleep(1000000);
	}
}
