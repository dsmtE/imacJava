public class Exo02 {
    public static void main(String[] args) {
 
        // ----- 01 -----
        String s01 = "";

        for (String s : args) {
            s01 += s;
            s01 += " Stop. ";
        }
        System.out.println(s01);

        // ----- 02 -----

        // La classe java.lang.StringBuilder permet de concaténer des chaînes de caractères de manière optimisée. 
        // l'objet de type StringBuilder retourne un objet de même type pour pourvoir chainer les appels méthodes
        StringBuilder builder = new StringBuilder( "" );
        for (String s : args) {
            builder.append(s).append(" Stop. ");
        }
        System.out.println(builder);
    }
}