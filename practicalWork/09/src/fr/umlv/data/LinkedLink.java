package fr.umlv.data;

import java.util.Objects;

// ----- 01.02 ----- //
public class LinkedLink<T> {
    private Link<T> start;
    private int size;

    public LinkedLink() {
        start = null;
        size = 0;
    }

    public LinkedLink(final T value) {
        start = new Link<T>(Objects.requireNonNull(value));
        // plutôt que de parcourir tout les éléments pour obtenir la taille, il est plus intelligent de stocker et changer la taille à chaque ajout avec size++
        size = 1;
    }

    // ----- 01.02.01 ----- //
    public LinkedLink<T> add(T value) {
        if(start == null) {
            start = new Link<T>(Objects.requireNonNull(value));
        }else {
            start = new Link<T>(Objects.requireNonNull(value), start);
        }
        size++;
        return this;
    }

    // ----- 01.02.02 ----- //
    @Override
    public String toString() {
        if (start == null) { return "[empty]"; }

        Link<T> temp = start;
        StringBuilder builder = new StringBuilder("[").append(temp.toString());
        while(temp.next != null) {
            builder.append(" - ").append(temp.next.toString());
            temp = temp.next;
        }
        return builder.append("]").toString();
    }

    // ----- 02.01 ----- //
    public T get(int id) throws IllegalAccessException, IllegalArgumentException {
        // si la liste est vide je retourne une exception
        if (size <= 0) { throw new IllegalAccessException("empty LinkedLink"); }
        // si l'index est invalide de même
        if( id < 0 || id >= size) { throw new IllegalArgumentException("invalid index (must be in [0, " + (size-1) + "])"); }

        int count = 0;
        Link<T> temp = start;
        while( count < id && count < size) {
            count++;
            temp = temp.next;
        }
        return temp.value;
    }

    // ----- 03.04 ----- //
    // contains utilise la fonction equals(Object o) cependant si notre type générique ne redéfini pas cette méthode alors cela ne va pas fonctionner 
    // la signature de equals ne marchera pas avec le type générique T
    public boolean contains(final Object o) {
        if (o == null) { return false; } // si je suis une reférence null
        Boolean result = o.equals(start.value);

        for (Link<T> l = start; l != null; l = l.next) {
            if (o.equals(l.value)) {
                result = true;
                break;
            }
        }
        
        return result;
    }



}