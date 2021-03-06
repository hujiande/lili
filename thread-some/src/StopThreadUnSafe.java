public class StopThreadUnSafe {

    public  static User user = new User();
    public static class User{
        private int id;
        private String name;
        public User(){
            id = 0;  name = "0";
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString(){
            return "User{" +"id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    public static class ChangeObjectThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis()/1000);
                    user.setId(v);
                    //Oh , do sth .else
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (user){
                    if(user.getId() != Integer.parseInt(user.getName())){
                        System.out.println(user);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        new ReadObjectThread().start();
        while (true){
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            t.stop();
        }
    }
}
