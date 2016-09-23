package com.nxy.test;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by snailnan on 2016/9/18.
 */
public class CallableAndFutureTest {

	public class MyCabble implements Callable<Boolean> {

		@Override
		public Boolean call() throws Exception {
			Thread.sleep(1);
			System.out.println(System.currentTimeMillis());
			return false;
		}
	}

	@Test
	public void test() throws ExecutionException, InterruptedException {
		ExecutorService threadpool = Executors.newWorkStealingPool(3);
		MyCabble c1 = new MyCabble();
		Future<Boolean> r = threadpool.submit(new MyCabble());
		int i=0;
		while (!r.isDone()){
			System.out.println(i++);
		}
		System.out.println(r.get());
    }
}
