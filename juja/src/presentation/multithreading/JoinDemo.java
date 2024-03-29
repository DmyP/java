package presentation.multithreading;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread() {
            @Override
            public void run() {
                System.out.println("Pretend hard computing");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                System.out.println("Computing finished");
            }
        };
        th.setDaemon(true);
        th.start();
//        th.join();
        System.out.println("Computing thread started");
    }
}
