import java.util.Scanner;

public class Calculette {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("entre un premier entier : ");
        int v1 = scanner.nextInt();
        // ici nextInt n'est pas une fonction mais une méthode de l'objet scanner, elle permet d'attendre que 
        // l'utilisateur entre une valeur entiere et la récuperer sous forme de variable
        System.out.println("entre un deuxieme entier : ");
        int v2 = scanner.nextInt();
        System.out.printf("la somme des deux entiers %d et %d fait : %d \n", v1, v2, v1 + v2);
        System.out.printf("la différence des deux entiers %d et %d fait : %d \n", v1, v2, v1 - v2);
        System.out.printf("le produit des deux entiers %d et %d fait : %d \n", v1, v2, v1 * v2);
        System.out.printf("le quotient des deux entiers %d et %d fait : %d \n", v1, v2, v1 / v2);
        System.out.printf("le reste de la division euclidienne des deux entiers %d et %d fait : %d \n", v1, v2, v1 % v2);
    }
    
}