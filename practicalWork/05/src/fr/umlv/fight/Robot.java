package fr.umlv.fight;

// ----- 01.01 -----
public class Robot {

    private String nom;
    private int lifes;

    public Robot(final String n) {
        nom = n;
        lifes = 10;
    }

    @Override
    public String toString() {
        return displayType() + nom;
    }

    // ----- 01.06 -----
    protected boolean rollDice() {
        return true;
    }

    // ----- 02.08 -----
    protected String displayType() {
        return "Robot ";
    }

    // ----- 01.02 -----
    // ----- 01.03 -----
    // ----- 02.04 -----
    void fire(Robot r) throws IllegalStateException {
        if (isDead()) { throw new IllegalStateException(this + "est mort et ne peut pas tirer");}
        if (r.isDead()) { throw new IllegalStateException("Tu ne peux pas tirer sur le " + r + "mort");}
        
        if( rollDice() ) {
            r.lifes = Math.max(r.lifes-2, 0);
            System.out.println(r + " à été touché par le " + this + " !");
        }else {
            System.out.println("Oups " + this + " à loupé sont tire");
        }
    }

    boolean isDead() {
        return lifes <= 0;
    }

    public static void main(String[] args) throws Exception {
        Robot bob = new Robot("bob");
        System.out.println(bob);

        // ----- 01.03 -----
        Robot Cherrier = new Robot("Cherrier");
        Robot Biri = new Robot("Biri");

        try {
            System.out.println(Arena.fight(Cherrier, Biri));
        }catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}