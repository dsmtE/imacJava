package fr.umlv.calc;

final public class Add extends Operateur {

    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int eval() {
        return left().eval() + right().eval();
    }

    @Override
    public String getStringOperateur() {
        return " + ";
    }
    
}