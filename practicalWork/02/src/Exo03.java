
/**
 * @author enguerrand DE SMET
 */

import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.regex.Matcher;

// references : https://regex101.com/

public class Exo03 {
    public static void main(final String[] args) {
        // ----- 01 -----
        // java.util.regex.Pattern permet de représenter une expression régulière
        // sa méthode compile permet de compiler cette expression régulière pour ensuite
        // l'utiliser via
        // l'objet java.util.regex.Matcher

        // ----- 02 -----
        System.out.println("01 - Nombres : ");
        for (final String s : args) {
            if (isNumber(s)) {
                System.out.println("\"" + s + "\" is a number");
            }
        }

        // ----- 03 -----
        System.out.println("\n02 - Number at the end :");
        final Pattern pattern = Pattern.compile("^\\D*(\\d+)$");
        Matcher matches;
        for (final String s : args) {
            matches = pattern.matcher(s);
            while (matches.find()) {
                System.out.println("\"" + s + "\" contains the number " + matches.group(1));
            }
        }

        // ----- 04 -----
		System.out.println("\n04 - Is an IPv4 :");
		for (String s : args) {
            try {
                final int[] ip = parseIpv4(s);
                if( ip != null) { // if not empty
                    System.out.println("ipv4 found : " + Arrays.toString(ip));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
			
		}
    }

    // ----- 02 -----
    public static boolean isNumber(final String str) {
        final Pattern pattern = Pattern.compile("(\\D)");
        final Matcher matches = pattern.matcher(str);
        return !matches.find();
    }

    public static boolean numberAtThisEnd(final String str) {
        final Pattern pattern = Pattern.compile("^\\D*(\\d+)$");
        final Matcher matches = pattern.matcher(str);
        return matches.find();
    }

    // ----- 04 -----
    public static int[] parseIpv4(final String str) throws Exception {
        final Pattern pattern = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        final Matcher matches = pattern.matcher(str);

        int[] ip = null;
        if (matches.find()) {
            //create array & capture the first group
            ip = new int[4];
            ip[0] = Integer.parseInt(matches.group(1));

            int i = 1;
            while (matches.find()) {
                ip[i] = Integer.parseInt(matches.group(i+1)); // starting at index 1 (i+1) because index refers to the whole group
                i++;
            }
        }
        
        return ip;
	}
    
}