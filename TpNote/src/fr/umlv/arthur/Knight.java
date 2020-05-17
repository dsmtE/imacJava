package fr.umlv.arthur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// ----- 01 ----- //
public class Knight {
    // private Sword sword;
    // // ----- 03 ----- //
    // private Sword secondSword;
    private final String name;
    private Heroicity heroicity;
    private List<Equipment> equipmentslist;

    // public Knight(final String n, final Sword s) {
    //     this(n ,s, null);
    // }

    // public Knight(final String n, final Sword s, final Sword ss) {
    //     sword = Objects.requireNonNull(s);
    //     secondSword = ss;
    //     name = Objects.requireNonNull(n);
    // }
    
    public Knight(final String n, final Equipment ...equipments) throws IllegalArgumentException {
        name = Objects.requireNonNull(n);
        equipmentslist = new ArrayList<Equipment>(Arrays.asList(equipments)); 
        if(countSwords() <= 0 ) { throw new IllegalArgumentException("Ton chevalier dois posséder au moins un équipement d'attaque"); }
        heroicity = new Heroicity(1, 1);
    }

    private final int countSwords() {
        int sum = 0;
        for (Equipment e: equipmentslist) { 
            if ( e instanceof Sword) { sum ++; }
        }
        return sum;
    }

    // getters
    public final String name() { return name; }
    public boolean isHeroic() { return heroicity.isHeroic(); }

    //setters
    public final Knight setHeroicity(final Heroicity h) {
        heroicity = h;
        return this;
    }
    
    public final int damage() {
        int sum = 0;
        for (Equipment e: equipmentslist) { 
            if ( e instanceof Weapon ) {
                sum += ((Weapon)e).damage();
            }
        }
        return heroicity.HeroicDamages(sum);
    }

    public final int protection() {
        int sum = 0;
        for (Equipment e: equipmentslist) { 
            if ( e instanceof Protective) {
                sum += ((Protective)e).protection();
            }
        }
        return heroicity.HeroicProtection(sum);
    }
    
    // ----- 06 ----- //
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append(name()).append(" damage: ").append(damage()).append(" protection: ").append(protection()).append("\n");
        str.append("  [");
        for (final Equipment e : equipmentslist) {
            str.append(e).append(", ");
        }
        str.append("]");

        return str.toString();
    }

    // ----- 04 ----- //
    public boolean isBetterThan(final Knight other) {
        return damage() > other.damage();
    }

    public static boolean isBetterThan(final Knight a, final Knight b) {
        return a.isBetterThan(b);
    }
}