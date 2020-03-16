package fr.umlv.calc;

final public class Mult extends Operateur {

    public Mult(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int eval() {
        return left().eval() * right().eval();
    }

    @Override
    public String getStringOperateur() {
        return " * ";
    }
    
}