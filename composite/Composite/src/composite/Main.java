package composite;

public class Main {
    public static void main(String[] args) {
        Folder dossier1 = new Folder("Dossier1");
        Folder dossier2 = new Folder("Dossier2");

        File file1 = new File("File1");
        File file2 = new File ("file2");

        Raccourci r1 =new Raccourci("raccourci1");
        Raccourci r2 =new Raccourci("raccourci2");

        dossier1.addComposant(file1);
        dossier1.addComposant(r1);
        dossier1.addComposant(dossier2);
        dossier2.addComposant(file2);
        dossier2.addComposant(r2);


        dossier1.afficher();


    }
}
