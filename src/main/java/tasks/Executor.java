package tasks;

public class Executor {
    private int currentNumber = 1;
    private int maxNumber;
    private final Object lock = new Object();

    public void setRange(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void number() {
        synchronized (lock) {
            while (currentNumber <= maxNumber) {
                if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                    System.out.print(currentNumber++);
                    if (currentNumber != maxNumber + 1){
                        System.out.print(", ");
                    }
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void fizz() {
        synchronized (lock) {
            while (currentNumber <= maxNumber) {
                if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                    System.out.print("fizz");
                    if (currentNumber != maxNumber){
                        System.out.print(", ");
                    }
                    currentNumber++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void buzz() {
        synchronized (lock) {
            while (currentNumber <= maxNumber) {
                if (currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                    System.out.print("buzz");
                    if (currentNumber != maxNumber){
                        System.out.print(", ");
                    }
                    currentNumber++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void fizzbuzz() {
        synchronized (lock) {
            while (currentNumber <= maxNumber) {
                if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                    System.out.print("fizzbuzz");
                    if (currentNumber != maxNumber){
                        System.out.print(", ");
                    }
                    currentNumber++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
