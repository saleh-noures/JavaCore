package Multithreading;

/*
Threads From the same Runnable class(target) share same Runnable instance variable.
*/

public class MT7_SharingObjects {

    public static void main(String[] args) {
        B b = new B();
        C c = new C();

        Thread thread1 = new Thread(b, "thread1");
        Thread thread2 = new Thread(b, "thread2");
        Thread thread3 = new Thread(c, "thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class A {
    private int counter = 0;

    public void count() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

class B implements Runnable {
    A a;
    public void run() {
        a = new A();
        a.count();
        a.count();
        a.count();
        System.out.println("Counter From " + Thread.currentThread().getName() + ":" + a.getCounter());
    }
}

class C implements Runnable {
    A a ;
    public void run() {
    a= new A();
        System.out.println("Counter From " + Thread.currentThread().getName() + ":" + a.getCounter());
    }
}