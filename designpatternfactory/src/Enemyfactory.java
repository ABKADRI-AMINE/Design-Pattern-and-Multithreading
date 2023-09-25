public class Enemyfactory {
    public static final int BIRD=1;
    public static final int TURTLE=2;
    public static Enemy createEnemy(int id){
        switch(id){
            case BIRD:
                return new Bird();
            case TURTLE:
                return new Turtle();
            default:return null;
        }
    }
}
