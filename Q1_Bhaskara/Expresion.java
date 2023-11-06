package Q1_Bhaskara;

public class Expresion implements Runnable{
    double a;
    double b;
    double c;
    String simbol;


    public Expresion(double a, double b, double c, String simbol) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.simbol = simbol;
    }

    public double calculaDelta(){
        // d = b*b - 4*a*c

        return b*b - 4*a*c;
    }

    @Override
    public void run() {
        double raiz;
        double delta = calculaDelta();
        if(delta < 0){
            System.out.println("delta negativo");
            return;
        }
        if(simbol.equals("+")){
            raiz = (-b + Math.sqrt(delta))/(2*a);
        }else {
            raiz = (-b - Math.sqrt(delta))/(2*a);
        }

        System.out.println(raiz);
    }
}
