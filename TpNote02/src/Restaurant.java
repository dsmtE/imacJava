import java.util.Objects;

public class Restaurant {
    static final int DEFAULT_STARS = 0;
    final String name;
    final int covers;
    final int stars;

    public Restaurant(final String n, final int c, final int s) throws IllegalArgumentException {

        if (c <= 0 || s < 0) {
            throw new IllegalArgumentException("Resto constructor: covers & stars can't be negative or null !");
        }
        name = Objects.requireNonNull(n);
        covers = c;
        stars = s;
    }

    public Restaurant(final String n, final int c) throws IllegalArgumentException {
        this(n, c, DEFAULT_STARS);
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder(name);
        for (int i = 0; i < stars; i++) {
            str.append("*");
        } // of use String::repeat method
        str.append(" (covers: ").append(covers).append(")");
        return str.toString();
    }

    @Override
    public boolean equals(final Object o) {

        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Restaurant)) {
            return false;
        }
        final Restaurant r = (Restaurant) o;

        return name.equals(r.name) && covers == r.covers && stars == r.stars;
    }

    // add few getters if needed
    final public String name() {
        return name;
    }

    final public int covers() {
        return covers;
    }

    final public int stars() {
        return stars;
    }

    public static void main(final String[] args) {
        final Restaurant r1 = new Restaurant("Le p'tit creux", 25);
        final Restaurant r2 = new Restaurant("Le p'tit creux", 25, 0);
        System.out.println(r2); // affiche "Le p'tit creux (25)"
        final Restaurant r3 = new Restaurant("Le Pré Catlan", 50, 3);
        System.out.println(r3);  // affiche "Le Pré Catlan*** (50)"
        System.out.println(r1.equals(r2)); // affiche "true"
        System.out.println(r1.equals(r3)); // affiche "false"
    }
}