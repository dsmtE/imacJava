package fr.umlv.arthur;

public class Heroicity {
    private final int attaqueBonus;
    private final int defenseBonus;

    public Heroicity(final int aB, final int dB) {
        attaqueBonus = aB;
        defenseBonus = dB;
    }

    public Heroicity(final int aB) {
        this(aB, 0);
    }

    public int HeroicDamages(final int damages) {
        return damages * attaqueBonus;
    }

    public int HeroicProtection(final int protection) {
        return protection * defenseBonus;
    }

    public boolean isHeroic() {
        return attaqueBonus > 1 || defenseBonus > 1;
    }
}