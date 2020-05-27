package fr.upem.restos;

import java.util.List;

public interface Establishment {
    
    static final int DEFAULT_STARS = 0;

    public String name();
    public int stars();

    // static public void printEstablishmentsWithGivenStarNumber(final List<Establishment> l, final int stars) {
    //     for (final Establishment e : l) {
    //         if(e.stars() == stars) {
    //             System.out.println(e);
    //         }
    //     }
    // }

    static public void printEstablishmentsWithGivenStarNumber(final List<Establishment> l, final int stars) {
        l.stream().filter(e -> e.stars() == stars).forEach(System.out::println);
        // or 
        // l.stream().filter(e -> e.stars() == stars).forEach(e -> System.out.println(e));
    }

}