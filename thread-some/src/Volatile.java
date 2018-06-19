/**
 * volatile visible
 */
public class Volatile {
    static volatile int i = 0;
    static Object object = new Object();
    public static class PuslT implements Runnable{
        @Override
        public void run() {
//            synchronized (object) {
                for (int k = 0; k < 10000; k++) {
                    i++;
                }
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threads [] = new Thread[10];
        for (int i = 0; i <10 ; i ++){
            threads[i] = new Thread(new PuslT());
            threads[i].start();
        }
        for(int i = 0; i< 10; i ++){
            threads[i].join();
        }
        System.out.println(i);
    }
}
