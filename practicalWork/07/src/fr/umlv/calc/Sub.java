package fr.umlv.calc;

final public class Sub extends Operateur {

    public Sub(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int eval() {
        return left().eval() - right().eval();
    }

    @Override
    public String getStringOperateur() {
        return " - ";
    }
    
}