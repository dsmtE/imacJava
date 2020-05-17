package fr.umlv.arthur;

import java.util.Objects;

public abstract class Equipment {
    private final String name;

    public Equipment(final String n) throws IllegalArgumentException{
        if(n != null && n.trim().isEmpty()) { throw new IllegalArgumentException("le nom ne peux pas être vide ou contenir uniquement des espaces"); }
        name = Objects.requireNonNull(n, "le nom ne peux pas avoir la valeur null");
    }

    // getters
    public final String name() { return name; }

    @Override
    public String toString() {
        return name;
    }

    @Override
	public boolean equals(final Object o) {
        if (o == null) { return false; } 
        if (o == this) { return true; }
        if (!(o instanceof Equipment)) { return false; }
        final Equipment e = (Equipment) o;

        return name.equals(e.name);
    }
}