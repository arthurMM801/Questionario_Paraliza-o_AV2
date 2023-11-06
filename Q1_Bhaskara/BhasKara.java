package Q1_Bhaskara;

public class BhasKara extends Thread{

    double a;
    double b;
    double c;


    public BhasKara(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void calcula(){
        Expresion e1 = new Expresion(a, b, c, "+");
        Expresion e2 = new Expresion(a, b, c, "-");

        Thread r1 = new Thread(e1);
        Thread r2 = new Thread(e2);

        long start = System.currentTimeMillis();

        r1.start();
        r2.start();

        try {
            r1.join();
            r2.join();
        }catch (InterruptedException e){
            System.out.println("Erro " + e);
        }

        long finish = System.currentTimeMillis();
        System.out.println("Tempo = " + (finish - start));
    }


}
