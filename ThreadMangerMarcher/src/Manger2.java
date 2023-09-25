public class Manger2 implements Runnable{
    public void manger2() throws InterruptedException {
        for(int i=1;i<=10;i++){
            System.out.println("Manger" + i);
            Thread.sleep(0);
        }
    }

    @Override
    public void run() {
        try {
            this.manger2();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
