package fr.umlv.fight;

// ----- 01.03 -----
public class Arena {


    static Robot fight(Robot a, Robot b) throws IllegalStateException {
        boolean turn = true; // si c'est vrai c'est au robot a de tirer sinon c'est b

        // permet de gérer le cas ou les deux robots sont déjà mort
        if (a.isDead() && b.isDead()) { throw new IllegalStateException("deux mort ne peuvent pas se battrent");}

        while( !b.isDead() && !a.isDead() ) {
            if(turn) {
                a.fire(b);
            }else {
                b.fire(a);
            }
            turn = !turn; // inverse le roles des robots c'est au suivant de tirer
        }

        return !turn ? a : b;
    }
}