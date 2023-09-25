public class Main {
    public static void main(String[] args) {

        Client c1 = new Client();
        Client c2 = new Client();

        c1.setiStandard(new StandardImp1());
        c1.proccess(4,3);

        c1.setiStandard(new StandardImp2());
        c1.proccess(4,3);

        c1.setiStandard(new Adapter());
        c1.proccess(4,3);
    }
}