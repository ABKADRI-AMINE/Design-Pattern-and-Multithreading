public class Manger extends Thread{
    public void manger() throws InterruptedException {
        for(int i=1;i<=10;i++){
            System.out.println("Manger" + i);
            Thread.sleep(0);
        }
    }

    @Override
    public void run() {
        try {
            this.manger();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
