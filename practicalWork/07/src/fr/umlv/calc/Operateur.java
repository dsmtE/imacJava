package fr.umlv.calc;

import java.util.Objects;
// ----- 02.05 ----- //

// jai choisi ici de créer deux méthodes left et right en visibilité protected pour que seulement les opérateurs qui vont hériter de cette classe puissent y accéder
// la méthode getStringOperateur est abstraite, sont comportement sera precisé de lq creation dun opérateur spécifique car cela dépends de opérateur créer
// la méthode est ici elle aussi abstraite car elle contiens une méthode abstraite, cela na pas de sens de définir un opérateur à lui tout seul, 
// il faut préciser sont comportement ( via les classe Add ou Sun par exemple) pour que cela ai un sens de l'utiliser mais c'est utiles de passer par cette classe intermédiaire pour
//  définir les comportements communs à tous nos opérateurs
public abstract class Operateur implements Expression {

	private final Expression left;
	private final Expression right;
	
	public Operateur(Expression l, Expression r) {
		left = Objects.requireNonNull(l);
		right = Objects.requireNonNull(r);
	}
    
    // getter pour l'expression de gauchee
	protected Expression left() {
		return left;
	}

    // getter pour l'expression de droite
	protected Expression right() {
		return right;
	}
    
    // méthode pas encore défini (on la qualifie donc d'abstraite, elle n'a pas de comportement toute seule ) qui permettra d'obtenir une chaîne de caractère représentant l'opérateur actuel
    // Ici le mot cle abstract permet de faire un peu comme la méthode eval dans l'interface Expression mais permet de le faire dans une classe
    // c'est à dire définir une méthode mais pas préciser son fonctionnement, 
	public abstract String getStringOperateur();
	

	// permet d'afficher l'expression
	@Override
    public String toString() {
        return left + getStringOperateur() + right;
    }
}