package Q2_RSA;


public class Main {
    public static void main(String[] args) {
        System.out.println("Criando chave!!\n");

        RSA cript = new RSA();
        long chave = cript.criptografa(10);
        System.out.println("Chave= "+chave);
    }
}
