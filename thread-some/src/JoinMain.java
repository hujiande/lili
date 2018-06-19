public class JoinMain {

    public volatile static int i = 0;

    public static class AddThread extends Thread{
        @Override
        public void run() {
            for (int i = 0 ; i <= 10000; i ++){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread t1 = new AddThread();
        t1.start();
        t1.join();
//        Thread.yield();
        System.out.println("i=" + i);
    }
}
