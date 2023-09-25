public class Marcher2 implements Runnable{
    public void marcher2() throws InterruptedException {
        for(int i= 1;i<=15;i++){
            System.out.println("pas" + i);
            Thread.sleep(0);
        }
    }

    @Override
    public void run() {
        try {
            this.marcher2();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
