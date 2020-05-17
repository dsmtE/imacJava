package fr.umlv.arthur.main;

import fr.umlv.arthur.Sword;
import fr.umlv.arthur.Bow;
import fr.umlv.arthur.Knight;
import fr.umlv.arthur.Shield;
import fr.umlv.arthur.Heroicity;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n  ----- 01 -----");
        // ----- 01 ----- //
        Sword excalibur = new Sword("excalibur", 10);
        Knight arthur = new Knight("arthur", excalibur);

        System.out.println( "excalibur.name() : " + excalibur.name() );
        System.out.println( "excalibur.damage() : " + excalibur.damage() );
        System.out.println( "excalibur : " + excalibur );

        System.out.println( "arthur.name() : " + arthur.name() );
        System.out.println( "arthur.damage() : " + arthur.damage() );
        System.out.println( arthur );

        System.out.println("\n  ----- 03 -----");
        // ----- 03 ----- //
        Sword secace = new Sword("secace", 7);
        Sword seure = new Sword("seure", 4);
        Knight lancelot = new Knight("lancelot", secace, seure);
        
        System.out.println( "lancelot.name() : " + lancelot.name() );
        System.out.println( "lancelot.damage() : " + lancelot.damage() );
        System.out.println( lancelot );

        System.out.println("\n  ----- 05 -----");
        // ----- 05 ----- //
        Shield hydra = new Shield("hydra", 4);
        Sword clarent = new Sword("clarent", 7);
        Knight mordred = new Knight("mordred", hydra, clarent);

        System.out.println( "mordred.name() : " + mordred.name() );
        System.out.println( "mordred.damage() : " + mordred.damage() );
        System.out.println( "mordred.protection() : " + mordred.protection() );
        System.out.println( mordred );

        System.out.println("\n  ----- 07 -----");
        // ----- 07 ----- //
        Sword astra = new Sword( "astra", 20 );
        Bow bow1 = new Bow( "bow1", 10, 7 );
        Bow bow2 = new Bow( "bow2", 10, 7 );
        Shield shield = new Shield( "shield", 12 );
        Knight shiva = new Knight( "shiva", astra, bow1, bow2, shield );
        System.out.println( shiva );

        System.out.println("\n  ----- 08 -----");
        // ----- 08 ----- //
        System.out.println( arthur.isHeroic() );
        arthur.setHeroicity( new Heroicity(2) );
        System.out.println( arthur.isHeroic() );
        System.out.println( arthur.damage() );
        System.out.println( arthur.protection() );
        System.out.println( arthur );

        System.out.println("\n  ----- 09 -----");
        // ----- 09 ----- //
        mordred.setHeroicity(new Heroicity(2, 3) );
        System.out.println( mordred.isHeroic() );
        System.out.println( mordred.damage() );
        System.out.println( mordred.protection() );
        System.out.println( mordred  );
    }
}