package fr.umlv.calc;

public class Value implements Expression {

	private final int value;

	public Value(final int v) {
        value = v;
    }

    @Override
    public int eval() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return Integer.toString(value);
    }
}