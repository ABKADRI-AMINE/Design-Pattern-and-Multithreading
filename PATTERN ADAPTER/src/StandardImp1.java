public class StandardImp1 implements IStandard {


    @Override
    public void Operation(int i, int j) {
        int res = i + j;
        System.out.println("Implementation 1 : " + res);
    }
}
