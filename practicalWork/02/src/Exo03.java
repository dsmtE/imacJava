/**
 * @author enguerrand DE SMET
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Exo03 {
    public static void main(String[] args) {
        // ----- 01 -----
        // java.util.regex.Pattern permet de représenter une expression régulière
        // sa méthode compile permet de compiler cette expression régulière pour ensuite l'utiliser via 
        // l'objet java.util.regex.Matcher

        // ----- 02 -----
        System.out.println("Nombres : ");
		for (String s : args) {
            if (isNumber(s)) {
                System.out.println("\"" + s + "\"est un nombre");
            }
		}
        
    }

    // ----- 02 -----
	public static boolean isNumber(String str) {
		final Pattern pattern = Pattern.compile("(\\D)");
		Matcher matches = pattern.matcher(str);
		return !matches.find();
	}
    
}