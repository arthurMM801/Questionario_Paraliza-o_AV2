package Q6_Verifica_n_primo;

public class tarefa extends Thread{
    private final long start_value;
    private final long finish_value;
    private long total = 0;


    public tarefa(long start_value, long finish_value) {
        this.start_value = start_value;
        this.finish_value = finish_value;
    }

    public long getTotal(){
        return total;
    }

    @Override
    public void run(){
        for(long i = start_value; i < finish_value; i++){
            total += ((total + i + total%i - total/i) / i) * (total%i+1);
        }
        System.out.println("End " + System.currentTimeMillis());
    }

}
