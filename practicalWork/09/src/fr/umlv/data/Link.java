package fr.umlv.data;

import java.util.Objects;

// ----- 01.01 ----- //
// je laisse la visibilité de package sur cette classe pour qu'elle ne soit accessible que dans son package
// elle sera destinée à être utilisé par une autre classe 'LinkedLink' qui va manipuler les maillons mais on ne veux pas quelle soit accessible sinon

public class Link<T> {
    // les attributs ne son pas nécessairement private ici car notre classe en visibilité de package ne sera pas manipuler directement par l'utilisateur

    // ----- 03.01 ----- //
    // ----- 02.02 ----- //
    // la généricité va permettre de pouvoir manipuler un type d'objet quelconque au lieu d'un type spécifique et ainsi 
    // pourvoir réutiliser notre classe au lieu de la réécrire pour tous les types 
    final T value; 
    final Link<T> next;
    public Link (final T v) {
        this(v, null);
    }

    public Link(final T v, final Link<T> n) { 
        value = Objects.requireNonNull(v);
        next = n;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
    public static void main(String[] args) {
        Link<Integer> l1 = new Link<Integer>(13);
        Link<Integer> l2 = new Link<Integer>(144);
        System.out.println("le premier maillon vaut :" + l1);
        System.out.println("le deuxième maillon vaut :" + l2);
    }
}