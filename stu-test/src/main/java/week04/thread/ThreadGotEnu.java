package week04.thread;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/4/11 20:21
 */
public class ThreadGotEnu {
    public static void main(String[] args) {
        //1. 利用 Callable和线程池返回结果
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        Future<String> future = threadPool.submit(new CalThread());
        try {
            System.out.println("future.get() = " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
        //2. 利用 RecursiveTask和ForkJoinPool 返回结果 任务分割,多个线程可以互相帮助完成
        Integer[] sources = IntStream.range(1, 10001).boxed().toArray(Integer[]::new);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> task = forkJoinPool.submit(new RecursiveCus(sources, 0, sources.length));
        try {
            System.out.println("task.get() = " + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            forkJoinPool.shutdown();
        }

    }

    static class CalThread implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "hello world!" ;
        }
    }
    static class RecursiveCus extends RecursiveTask<Integer> {
        private static final Integer threshold = 50;
        private Integer[] sources;
        private Integer start;
        private Integer end;

        public RecursiveCus(Integer[] sources, Integer start, Integer end) {
            if (sources == null
                    || start < 0
                    || end < 0
                    || start > end
                    || end > sources.length) {
                throw new IllegalArgumentException();
            }
            this.sources = sources;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= threshold) {
                Integer sum = 0;
                for (int i = start; i < end; i++) {
                    sum += sources[i];
                }
                return sum;
            }else {
                int mid = (start + end) / 2;
                RecursiveCus left = new RecursiveCus(sources, start, mid);
                RecursiveCus right = new RecursiveCus(sources, mid, end);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }

}
