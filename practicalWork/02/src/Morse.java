
/**
 * @author enguerrand DE SMET
 */
public class Morse {
    public static void main(String[] args) {
 
        // ----- 01 -----
        String s01 = "";

        for (String s : args) {
            s01 += s;
            s01 += " Stop. ";
        }
        System.out.println(s01);

        // ----- 02 -----

        // La classe java.lang.StringBuilder permet de concaténer des chaînes de caractères de manière optimisée (objet mutable)
        // la méthode append de l'objet de type StringBuilder retourne un objet de même type pour pourvoir chaîner les appels méthodes
        StringBuilder builder = new StringBuilder( "" );
        for (String s : args) {
            builder.append(s).append(" Stop. ");
        }
        System.out.println(builder);

        // ----- 05 -----

        // il est préférable d'utiliser StringBuilder lorsque l'on souhaite concaténer
        // plusieurs fois une chaîne de caractères, comme précédemment dans une boucle par exemple.

        // En effet, bien que java créer un StringBuilder implicitement lors de l'utilisation 
        // de l'opérateur +, il ne sais pas analyser les boucles et va donc créer autant de StringBuilder 
        // que de concaténation dans la boucle ce qui est regrettable car on pourrait en utiliser un seul
        // comme dans l'exemple précédant

        // de même si l'on  écrit : "builder.append( a + b )", le compilateur va ici créer un deuxième StringBuilder 
        // pour concaténer la sous chaîne appellé dans la méthode append
        //  il faut écrire plutôt : "builder.append(a).append(b)" pour éviter la création d'un autre objet 

    }
}