class A {
    int x = 1;
  
    public int getX() {
      return x;
    }
    
    static void printX(A a) {
      System.out.println("in A.printX");
      System.out.println("x " + a.x);
      System.out.println("getX() " + a.getX());
    }
    
    int m(A a) { return 1; }
  }
  
  class B extends A {
    int x = 2;
  
    public int getX() {
      return x;
    }
    
    static void printX(B b) {
      System.out.println("in B.printX");
      System.out.println("x " + b.x);
      System.out.println("getX() " + b.getX());
    }
    
    int m(B b) { return 2; }
  }
  
  public class Overridings {
    public static void main(String[] args) {
      A.printX(new A());
      // ----- 01.01 ----- //
      // ici cela va afficher le resultat de la méthode de la classe A 
      // avec l'initialisation classique de la classe A sans suprises c'est à dire : 
      // -> in A.printX
      // -> x 1
      // -> getX() 1
      B.printX(new B());
      // ----- 01.02 ----- //
      // ici cela va afficher le resultat de la méthode de la classe B
      // avec l'initialisation classique de la classe B qui surcharge la printX pour la clase B
      // -> in B.printX
      // -> x 2
      // -> getX() 2
       A.printX(new B());
      // ----- 01.03 ----- //
      // ici cela va afficher le resultat de la méthode de la classe A
      // en utilisant un objet de la classe B via la methode de la classe A l'objet est vu comme un objet de la classe A
      // la variable x  etant local à la classe sa valeurs ici sera 1
      // cependant la methode getX() est redefini par la classe B, c'est donc bien celle de la classe B par polymorphisme qui sera appelé
      // getX() donne donc 2 ici, la variable local x de la classe B
      // -> in A.printX
      // -> x 1
      // -> getX() 2
      A a = new B();
      System.out.println(a.m(a));
      // ----- 01.04 ----- //
      // ici l'objet est de l'instance de la classe B mais vu du point de vu de la classe A
      // la methode recoit donc un argument de classe A, c'est donc la methode m définie dans la classe A qui sera utilisee
      // -> 1
    }
  }
    