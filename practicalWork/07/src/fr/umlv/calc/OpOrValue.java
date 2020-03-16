package fr.umlv.calc;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class OpOrValue {
  public static final int OP_NONE = 0;
  public static final int OP_ADD = 1;
  public static final int OP_SUB = 2;
  
  private final int operator;
  private final int value;
  private final OpOrValue left;
  private final OpOrValue right;
  
  // ----- 01.01 ----- //
  // car il est destinée à être appelé uniquement pas la classe elle même, cela permet de maîtriser le choix des valeurs 
  // de la classe pour pouvoir gerer à la fois une valeur et un opérateur
  private OpOrValue(int operator, int value, OpOrValue left, OpOrValue right) {
    this.operator = operator;
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public OpOrValue(int value) {
    this(OP_NONE, value, null, null);
  }

  // ----- 01.02 ----- //
  // il faut verifier que la valeur operator soit bien une valeur utilisable par la suite et donc un opérateur valide (dans le switch)
  public OpOrValue(int operator, OpOrValue left, OpOrValue right) throws IllegalArgumentException {
    this(operator, 0, Objects.requireNonNull(left), Objects.requireNonNull(right));
    if (operator != OP_ADD && operator != OP_SUB) {
      throw new IllegalArgumentException(" l'opérateur " + operator + " pas valide" );
    }
  }

  // ----- 01.03 ----- //
  // static public OpOrValue parse(Scanner s) throws IllegalArgumentException {
    
  //   if ( !s.hasNext() ) {
  //     throw new IllegalArgumentException(" l'expression est mal formée");
  //   }
  //   String read = s.next();// on lit le prochain mot

  //   try { // on essaye de le convertir en nombre
  //     int value = Integer.parseInt(read); // si c'est un nombre
  //     return new OpOrValue(value); // on retourne sa valeur avec notre objet ( feuille de l'arbre )
  //   } catch (NumberFormatException | NullPointerException e) { // sinon c'est un opérateur ou autre

  //     OpOrValue left = parse(s); // on propage la récursivité pour la gauche (jusqu'à obtenir une feuille de l'arbre càd un nombre)
  //     OpOrValue right = parse(s); // puis a droite pour le reste
  //     int operator;
  //     switch (read) {
  //       case "+":
  //         operator = OP_ADD;
  //         break;
  //       case "-": 
  //         operator = OP_SUB;
  //         break;
  //       default: // si c'est pas un opérateur connu erreur
  //         throw new IllegalArgumentException(" l'opérateur " + read + " n'est pas valide dans notre parseur");
  //     }
  //     return new OpOrValue(operator, left, right);
  //   }
  // }

  // ----- 01.06 ----- //
  // l'idée est d'utiliser a la place d'un stream l'interface Iterator<String> en effet la class Stream hérite de cette interface et il est possible d'obtenir 
  // un iterator depuis n'importe quel collection comme une Liste avec la méthode Iterator()
  // on va pouvoir alors utiliser directement un iterator sans se préoccuper de ce qu'il est réellement ( un Stream ou une Liste)
  // c'est exactement le copié collée de ce que j'ai fait juste avant mais avec un Iterator à la place du Scanner
  static public OpOrValue parse(Iterator<String> iter) throws IllegalArgumentException {
    
    if ( !iter.hasNext() ) {
      throw new IllegalArgumentException(" l'expression est mal formée");
    }
    String read = iter.next();// on lit le prochain mot

    try { // on essaye de le convertir en nombre
      int value = Integer.parseInt(read); // si c'est un nombre
      return new OpOrValue(value); // on retourne sa valeur avec notre objet ( feuille de l'arbre )
    } catch (NumberFormatException | NullPointerException e) { // sinon c'est un opérateur ou autre

      OpOrValue left = parse(iter); // on propage la récursivité pour la gauche (jusqu'à obtenir une feuille de l'arbre càd un nombre)
      OpOrValue right = parse(iter); // puis a droite pour le reste
      int operator;
      switch (read) {
        case "+":
          operator = OP_ADD;
          break;
        case "-": 
          operator = OP_SUB;
          break;
        default: // si c'est pas un opérateur connu erreur
          throw new IllegalArgumentException(" l'opérateur " + read + " n'est pas valide dans notre parseur");
      }
      return new OpOrValue(operator, left, right);
    }
  }
  
  // ----- 01.06 ----- //
  // cette méthode permet ici de faire la passerelle si l'objet reçu est une collection en prennent son itérateur et utilisant la méthode précédemment définie
  static public OpOrValue parse(Collection<String> collection) throws IllegalArgumentException {
    return parse(collection.iterator());
  }

  // ----- 01.05 ----- //
  // permet de récupérer l'operator sous forme d'une chaîne de caractère pour le toString
  public String getOperator() {
    switch(operator) {
      case OP_ADD:
        return " + ";
      case OP_SUB:
        return " - ";
      default: // si c'est pas un opérateur connu erreur
        return " null ";
    }
  }

  public int eval() {
    switch(operator) {
    case OP_ADD:
      return left.eval() + right.eval();
    case OP_SUB:
      return left.eval() - right.eval();
    default: // case OP_NONE:
      return value;
    }
  }
  
  @Override
  public String toString() {
    if (operator == OP_NONE) {
      return Integer.toString(value);
    } else {

      return left + getOperator() + right;
    }
  }

}