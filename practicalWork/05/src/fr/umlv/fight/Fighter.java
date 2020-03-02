package fr.umlv.fight;
import java.util.Random; 

// ----- 02.01 -----

// un générateur aléatoire crée une suite de nombre qui semble aléatoire
// il utilise une graine de sort que l'on puisse reproduire à l'identique cette suite de nombre

// ----- 02.02 -----
public class Fighter extends Robot {

    private final Random randomGen;

    Fighter(final String nom) {
        this(nom, System.currentTimeMillis()); // initialise le seed via le temps par defaut
    }

    Fighter(final String nom, final long seed) {
        super(nom);
        randomGen = new Random(seed);
    }

    // @Override
    // public String toString() {
    //     return "Fighter " + nom;
    // }

    // ----- 02.05 -----
    // ici la méthode va propager l'erreur crée par la méthode fire, c'est donc dans celle ci que l'on gère les erreurs possible
    // cela évite les copié collé
    // @Override
    // void fire(Robot r) throws IllegalStateException {
    //     if( random.nextBoolean() ) {
    //         super.fire(r);
    //     }else {
    //         System.out.println("Oups " + this + " à loupé sont tire");
    //     }
    // }

    @Override 
    protected boolean rollDice() {
        return randomGen.nextBoolean();
    }

    @Override
    protected String displayType() {
        return "Fighter ";
    }
    

    public static void main(String[] args) {
        Robot wallE = new Robot("Wall-e");
        Fighter neo = new Fighter("Neo");

        // ----- 02.07 -----
        try {
            System.out.println(Arena.fight(wallE, neo));
        }catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }
        // ----- 02.09 -----

}