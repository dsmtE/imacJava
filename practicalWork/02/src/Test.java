/**
 * @author enguerrand DE SMET
 */
public class Test {
    public static void main(String[] args) {
        var first = args[0];
        var second = args[1];
        var last = args[2];
        System.out.println(first + ' ' + second + ' ' + last);
    }
    // ----- 04 -----
    
    // '' à la place de "" permet d'utiliser un seul caractère

    // en utilisant javap on se rend compte aue java optimise lui même le code en
    //  créant un StringBuilder pour concaténer les chaînes de caractères
}