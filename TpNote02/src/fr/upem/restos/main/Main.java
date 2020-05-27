package fr.upem.restos.main;

import fr.upem.restos.Establishment;
import fr.upem.restos.Ranker;
import fr.upem.restos.Resto;

import java.util.ArrayList;
import java.util.List;

import fr.upem.restos.Bar;

public class Main {
    public static void main(String[] args) {
        Establishment r1 = new Resto("Le p'tit creux", 25);
        Establishment r2 = new Resto("Le p'tit creux", 25, 0);
        System.out.println(r2);  // display "Le p'tit creux (25)"
        Establishment r3 = new Resto("Le Pré Catlan", 50, 3);
        System.out.println(r3);  // display "Le Pré Catlan*** (50)"
        System.out.println(r1.equals(r2)); // display "true"
        System.out.println(r1.equals(r3)); // display "false"
        
        Establishment b1 = new Bar("La soif", false);
        Establishment b2 = new Bar("Jusqu'à l'aube", true, 2);
        System.out.println(b1); // display "La soif (not open after eight)"
        System.out.println(b2); // display "Jusqu'à l'aube** (open after eight)"
        
        System.out.println(r3.stars() - b2.stars()); // display "1"
        
        System.out.println("---------- ---------- ----------");

        // Create a list to store different establishments
        List<Establishment> list =  new ArrayList<Establishment>();
        list.add(r1);
        list.add(r3);
        list.add(b1);
        list.add(b2);
        System.out.println(list.contains(new Bar("La soif", false, 0))); // display "true"
        System.out.println(list.contains(new Bar("La soif", true, 0)));  // display "false"
        System.out.println(list.contains(new Resto("La soif", 10)));     // display "false"
        
        Establishment.printEstablishmentsWithGivenStarNumber(list, 2);
        // display "Jusqu'à l'aube** (open after eight)"
        Establishment.printEstablishmentsWithGivenStarNumber(list, 0);
        // display "Le p'tit creux (25)"
        //         "La soif (not open after eight)"

        System.out.println(list);
        list.sort( (Establishment e1, Establishment e2) -> e1.stars() - e2.stars() );
        System.out.println(list); // display the list sorted by decreasing star numbers

        System.out.println("---------- ---------- ----------");

        Ranker<Establishment> moEtGuillaut = new Ranker<>();

        moEtGuillaut.addEvaluation(r3, 5, "Amazing");
        moEtGuillaut.addEvaluation(r3, 1, "So popular");
        moEtGuillaut.addEvaluation(r3, 2);
        moEtGuillaut.addEvaluation(r3, 3, "Not so bad");
        
        moEtGuillaut.addEvaluation(b1, 4, "Nice and simple");
        moEtGuillaut.addEvaluation(b1, 0, "Crappy");
        
        moEtGuillaut.addEvaluation(b2, 1, "Expensive!");
        moEtGuillaut.addEvaluation(b2, 4, "Fashionable and funny");

        float average = moEtGuillaut.averageScoreFor(new Resto("Le Pré Catlan", 50, 3));
        System.out.println(average); // display something like 2.75

        moEtGuillaut.printCommentsForItemWithScoreBetterOrEqualsThan(3);
        // display something like:
        //      La soif (not open after eight) : [<4>Nice and simple]
        //		Jusqu'à l'aube** (open after eight) : [<4>Fashionable and funny]
        //		Le Pré Catlan*** (50) : [<5>Amazing, <3>Not so bad]
                
        moEtGuillaut.printCommentsForItemVerifying(e -> e.stars() >= 2);
        // display something like:
        // Jusqu'à l'aube** (open after eight) : [<1>Expensive!, <4>Fashionable and funny]
        // Le Pré Catlan*** (50) : [<5>Amazing, <1>So popular, <2>, <3>Not so bad]

    }
}