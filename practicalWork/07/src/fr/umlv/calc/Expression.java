package fr.umlv.calc;

import java.util.Collection;
import java.util.Iterator;

// ----- 02.04 ----- //

// j'ai directement utilisé une interface car cela me semblai plus adéquat. 
// En effet une interface est destinée a donner un patron ou schema des classes qui vont en hériter
// ici une expression dois seulement pouvoir être évaluer et parser 
public interface Expression {

    // ----- 02.03 ----- //
    // méthode que l'on peut qualifier de "abstraite", elle n'est pas encore défini on devra la définir dans les classe filles qui héritent de cette interface
    // car le comportement va être different en fonction des opérateurs et valeurs ( allez voir les Classes Value, Add et Sub pour voir l'implementation)
    public int eval();

    // ----- 02.02 ----- //
    // On met la méthode parse dans notre interface pour que toute les Expressions qui en hérite puisse en disposer
    static public Expression parse(Iterator<String> iter) throws IllegalArgumentException {
    
        if ( !iter.hasNext() ) { throw new IllegalArgumentException(" l'expression est mal formée");}
        String read = iter.next();// on lit le prochain mot
    
        try { // on essaye de le convertir en nombre

          int value = Integer.parseInt(read); // si c'est un nombre
          return new Value(value); // on retourne un objet Value ( feuille de l'arbre )

        } catch (NumberFormatException | NullPointerException e) { // sinon c'est un opérateur ou autre

          switch (read) { 
            case "+" :
                return new Add(parse(iter), parse(iter)); // on propage la récursivité directement ici ( regarder la question 01.03 pour plus de clarté )
            case "-" :
                return new Sub(parse(iter), parse(iter));
            // Mult facultatif !! (uniquement pour montrer la facilité que cette structures orienté objet apporte)
            case "*" :
                return new Mult(parse(iter), parse(iter));
            default: // si c'est pas un opérateur connu erreur
              throw new IllegalArgumentException(" l'opérateur " + read + " n'est pas valide dans notre parseur");
          }

        }
    }

    // explication de cette méthode à la question 01.06
    static public Expression parse(Collection<String> collection) throws IllegalArgumentException {
        return parse(collection.iterator());
    }
}