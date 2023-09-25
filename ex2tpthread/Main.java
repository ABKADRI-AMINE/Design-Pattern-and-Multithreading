
public class Main {
    public static void main(String[] args) {
        Compte compte = new Compte(0);

        Thread[] threads = new Thread[40];

        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new ThreadVerser(compte, 10));
            threads[i + 20] = new Thread(new ThreadRetirer(compte, 10));
        }

        for (Thread t : threads) {
            t.start();
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Solde final : " + compte.consulter());
        /*
         1-Compiler et exécuter plusieurs fois le programme. Y a-t-il des cas où le résultat est différent? Expliquer.
	Oui, il est possible que le résultat soit différent à chaque exécution. Cela est dû au fait que 
	les threads s'exécutent en parallèle et que l'ordre d'exécution des instructions n'est pas déterministe.
	 Dans certains cas, les threads de dépôt peuvent finir leur travail avant les threads de retrait,
	  ce qui laisse un solde positif sur le compte. Dans d'autres cas, c'est l'inverse et le solde final est négatif.

		2-Si oui Modifier le programme pour que le solde du compte donnera toujours 0 à la fin
	Pour éviter ce problème, il est possible de synchroniser les méthodes de dépôt, de retrait et de consultation du solde
	 en utilisant le mot-clé "synchronized". Cela garantit que chaque méthode est exécutée de manière atomique, 
	 c'est-à-dire qu'elle est complètement exécutée avant qu'une autre méthode ne puisse accéder à la variable partagée.
         */
    }
}
