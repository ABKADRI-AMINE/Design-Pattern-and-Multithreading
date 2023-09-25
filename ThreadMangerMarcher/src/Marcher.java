public class Marcher extends Thread{
    public void marcher() throws InterruptedException {
        for(int i= 1;i<=15;i++){
            System.out.println("pas" + i);
            Thread.sleep(0);
        }
    }

    @Override
    public void run() {
        try {
            this.marcher();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
