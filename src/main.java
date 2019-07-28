import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class main{
    public static int cnt = 0;
    public static final int count = 30;

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    if (cnt>count){
                        lock.unlock();
                        return;
                    }
                    if (count%3==0){
                        System.out.println("A");
                        cnt++;
                    }
                    lock.unlock();

                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    if (cnt>count){
                        lock.unlock();
                        return;
                    }
                    if (count%3==1){
                        System.out.println("B");
                        cnt++;
                    }
                    lock.unlock();

                }
            }
        });
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    if (cnt>count){
                        lock.unlock();
                        return;
                    }
                    if (count%3==2){
                        System.out.println("C");
                        cnt++;
                    }
                    lock.unlock();

                }
            }
        });
        A.start();
        B.start();
        C.start();
    }


}

