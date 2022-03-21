import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        List<Article> collection = new ArrayList<>();
        collection.add(new Article("2022-01", "article1", 22.12f, 880L));
        collection.add(new Article("2022-02", "article2", 210.2f, 87L));
        collection.add(new Article("2022-03", "article3", 22.212f, 250L));
        collection.add(new Article("2022-04", "article4", 254.2f, 30L));
        collection.add(new Article("2022-06", "article6", 2225.2f, 80L));
        collection.add(new Article("2022-05", "article5", 2.842f, 280L));
        int choix = 0;
        do {
            System.out.println("choisissez votre opération" +
                    "\n1)- recherche par reference" +
                    "\n2)-Ajouter un article au stock" +
                    "\n3)- Supprimer un article par référence." +
                    "\n4)- Modifier un article par référence" +
                    "\n 5)- Rechercher un article par nom" +
                    "\n 6) Rechercher un article par prix" +
                    "\n 7)-Afficher tous les articles" +
                    "\n 8)- Quitter");
            Scanner scanner = new Scanner(System.in);
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("saisir la reference:");
                    scanner.nextLine();
                    String ref = scanner.nextLine();
                    for (Article article : collection) {
                        if (ref.equals(article.getReference())) {
                            System.out.println("Votre article est :" + article);
                        }
                    }
                    break;
                case 2:

                    collection.add(createArticle(null));
                    System.out.println("added success");
                    break;

                case 3:
                    System.out.println("donner la reference a supprimer\n");
                    scanner.nextLine();
                    String reference = scanner.nextLine();
                    collection.removeIf(obj -> obj.getReference() == reference);
                    break;
                case 4:
                    System.out.println("donner la reference \n");
                    scanner.nextLine();
                    String refer= scanner.nextLine();
                    for (Article article : collection) {
                        if (refer.equals(article.getReference())) {
                            System.out.println("donner le nom\n");
                            article.setNom(scanner.nextLine());
                            System.out.println("donner le prix\n");
                            article.setPrix(scanner.nextFloat());
                            System.out.println("donner la quantite\n");
                            article.setStock(scanner.nextLong());
                        }
                    }

                    break;

                case 5:
                    System.out.println("donner la reference \n");
                    scanner.nextLine();
                    String nom= scanner.nextLine();
                    for (Article article : collection) {
                        if (nom.equals(article.getNom())) {
                            System.out.println("Votre article est :" + article);
                        }
                    }
                    break;
                case 6:
                    System.out.println("donner la prix \n");
                    float prix= scanner.nextFloat();
                    for (Article article : collection) {
                        if (prix == article.getPrix()) {
                            System.out.println("Votre article est :" + article);
                        }
                    }
                    break;

                case 7:
                    for (Article article : collection) {

                            System.out.println( article);

                    }
                    break;
                case 8:
                    break;
            }
        } while (choix != 8);
        System.out.println("Au revoir");
        System.exit(0);

    }
    public static Article createArticle(String reference){
        Scanner scanner = new Scanner(System.in);
        Article article = new Article();
        if(reference==null){
            System.out.println("donner la referencee\n");
            article.setReference(scanner.nextLine());
        }else{
            article.setReference(reference);
        }
        System.out.println("donner le nom\n");
        article.setNom(scanner.nextLine());
        System.out.println("donner le prix\n");
        article.setPrix(scanner.nextFloat());
        System.out.println("donner la quantite\n");
        article.setStock(scanner.nextLong());
        return article;
    }
}

