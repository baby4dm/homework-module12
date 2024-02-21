package tasks;


public class ExecutorDemo {
    public static void main(String[] args) {
       Executor executor = new Executor();
       executor.setRange(35);
       Thread a = new Thread(() -> executor.fizz());
       Thread b = new Thread(() -> executor.buzz());
       Thread c = new Thread(() -> executor.fizzbuzz());
       Thread d = new Thread(() -> executor.number());
       a.start();
       b.start();
       c.start();
       d.start();
    }
}
