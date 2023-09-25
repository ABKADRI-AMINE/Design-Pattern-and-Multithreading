

public class test {
    public static void main(String[] args)  {
        Application app1 = new Application() ;
        app1.setUser( new Adaptateur("mohamed" , "Directeur")) ;
        app1.process();

        app1.setUser(new GrandeDistrubition("Ali"));
        app1.process();




    }

}