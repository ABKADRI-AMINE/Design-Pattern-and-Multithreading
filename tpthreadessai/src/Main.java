

public class Main {
    public static void main(String[] args) {
        ClasseA A=new ClasseA();
        ClasseB B=new ClasseB();
        Thread thrd1=new Thread(B);

        A.start();
        thrd1.start();
    }
}
