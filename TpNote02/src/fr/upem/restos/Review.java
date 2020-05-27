package fr.upem.restos;

import java.util.Objects;

public class Review {
    private final String comment;
    private final int score;

    public Review(final String c, final int s) {
        if (s < 0 || s > 5) {
            throw new IllegalArgumentException("Review: score must be in [0, 5] !");
        }
        comment = Objects.requireNonNull(c);
        score = s;
    }

    // getters
    final public String comment() { return comment; }
    final public int score() { return score; }

    @Override
    public String toString() {
        return "<" + score + ">" + comment;
    }
    
}
