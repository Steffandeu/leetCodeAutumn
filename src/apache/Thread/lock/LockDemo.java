package apache.Thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
//    static Lock lock = new ReentrantLock();

    static Lock lock = new ReentrantLock(true);//公平锁和非公平锁
    static class ThreadDemo implements Runnable{
        Integer id;

        public ThreadDemo(Integer id){
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <2 ; i++) {
                lock.lock();
                System.out.println("获得锁的线程: "+id);
                lock.unlock();
                
            }

        }

        public static void main(String[] args) {
            for (int i = 0; i < 5; i++) {
                new Thread(new ThreadDemo(i)).start();

            }
        }
    }
    
}
