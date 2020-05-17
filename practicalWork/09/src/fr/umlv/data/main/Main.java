package fr.umlv.data.main;

import fr.umlv.data.LinkedLink;

public class Main {
    public static void main(final String[] args) {

        final LinkedLink<Integer> ll = new LinkedLink<Integer>();
        ll.add(11).add(23);
        ll.add(32);
        ll.add(44);
        System.out.println("notre liste : " + ll);

        // ----- 02.03 ----- //
        final LinkedLink<String> fruits = new LinkedLink<String>();
        fruits.add("poire").add("banane").add("pomme").add("kiwi");
        System.out.println("notre liste de fruit contient : \n" + fruits);

        try {
            System.out.println("le nom de notre 2ème fruit contient " + fruits.get(1).length() + " lettres");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if ( fruits.contains("poire") ) {
            System.out.println("ma liste de fruit contient une poire");
        }
        
    }

}