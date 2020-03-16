package fr.umlv.calc.main;

import java.util.ArrayList;
import java.util.Scanner;

import fr.umlv.calc.Expression;
import fr.umlv.calc.Add;
import fr.umlv.calc.Value;

// ----- 01.04 ----- //
public class Main {
  public static void main(String[] args) {
    // OpOrValue expression = new OpOrValue(OpOrValue.OP_ADD,
    // new OpOrValue(2),
    // new OpOrValue(3)
    // );
    // System.out.println(expression.eval());

    // Scanner scanner = new Scanner("- + 3 2 4");
    // OpOrValue expr = OpOrValue.parse(scanner);
    // System.out.println(expr.eval());
    // System.out.println(expr);

    // ----- 02.01 ----- //
    Expression expression = new Add(new Value(2), new Value(3));
    System.out.println(expression.eval());

    Scanner scanner = new Scanner("- + 3 2 4");
    Expression expr = Expression.parse(scanner);
    System.out.println("le résultat de l' expression '" + expr + "' est : " + expr.eval());

    // exemple avec une collection ici un ArrayList
    ArrayList<String> list = new ArrayList<String>();
    list.add("-");
    list.add("+");
    list.add("3");
    list.add("2");
    list.add("4");
    Expression expr2 = Expression.parse(list);
    System.out.println("le résultat de l' expression '" + expr2 + "' est : " + expr2.eval());

    // exemple pour montrer la facilité d'ajout de la multiplication (classe Mult)
    // avec l'expression 2+3*4 qui s'écrit en NPI + 2 * 3 4
    Expression expr3 = Expression.parse(new Scanner("+ 2 * 3 4"));
    System.out.println("le résultat de l' expression '" + expr3 + "' est : " + expr3.eval());

  }

}