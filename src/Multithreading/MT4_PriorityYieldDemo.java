package Multithreading;/*
Priorities
1-Priorities can be specified from 1 to 10. 10 being the highest, 1 being the lowest priority and 5 being the default priority
2-Remember that the thread with the highest priority will be given preference in execution. But there is no guarantee that it will be in running state the moment it starts.
3-The currently executing thread might have the higher priority when compared to the threads in the pool who are waiting for their chance.
4-Remember that the priorities should be set before the threads start method is invoked.

Yield
1-Yield tells the currently executing thread to give a chance to the threads that have equal priority in the Thread Pool.
2-There is no guarantee that Yield will make the currently executing thread go to runnable state immediately.
3-Remember an important point that yield method does not make the thread to go to Wait or Blocked state. It can only make a thread from Running State to Runnable State.
*/

import java.lang.Thread.State;

//This class prints the Stats and also the threads priorities while executing the yield method
public class MT4_PriorityYieldDemo {
    public static void main(String[] args) {

        YeildRunnable yr = new YeildRunnable();

        ThreadGroup allThreads = new ThreadGroup("All Threads");

        Thread t1 = new Thread(allThreads, yr, "t1");  //ThreadGroup, Target, Name
        Thread t2 = new Thread(allThreads, yr, "t2");
        Thread t3 = new Thread(allThreads, yr, "t3");
        Thread t4 = new Thread(allThreads, yr, "t4");
        Thread t5 = new Thread(allThreads, yr, "t5");
        Thread t6 = new Thread(allThreads, yr, "t6");
        Thread t7 = new Thread(allThreads, yr, "t7");
        Thread t8 = new Thread(allThreads, yr, "t8");
        Thread t9 = new Thread(allThreads, yr, "t9");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t4.setPriority(Thread.NORM_PRIORITY);
        t5.setPriority(Thread.NORM_PRIORITY);
        t6.setPriority(Thread.NORM_PRIORITY);

        t7.setPriority(Thread.MIN_PRIORITY);
        t8.setPriority(Thread.MIN_PRIORITY);
        t9.setPriority(Thread.MIN_PRIORITY);

        // starting all the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();

        //Getting the status of each thread using the Main thread
        {
            State t1State = t1.getState();
            State t2State = t2.getState();
            State t3State = t3.getState();
            State t4State = t4.getState();
            State t5State = t5.getState();
            State t6State = t6.getState();
            State t7State = t7.getState();
            State t8State = t8.getState();
            State t9State = t9.getState();

            System.out.println(System.nanoTime() + " t1 Status:" + t1State);
            System.out.println(System.nanoTime() + " t2 Status:" + t2State);
            System.out.println(System.nanoTime() + " t3 Status:" + t3State);
            System.out.println(System.nanoTime() + " t4 Status:" + t4State);
            System.out.println(System.nanoTime() + " t5 Status:" + t5State);
            System.out.println(System.nanoTime() + " t6 Status:" + t6State);
            System.out.println(System.nanoTime() + " t7 Status:" + t7State);
            System.out.println(System.nanoTime() + " t8 Status:" + t8State);
            System.out.println(System.nanoTime() + " t9 Status:" + t9State);

        } while (allThreads.activeCount()>0);

    }

}

class YeildRunnable implements Runnable {

    @Override
    public void run() {

        System.out.println("Current Thread:" + Thread.currentThread().getName() + " Priority " + Thread.currentThread().getPriority() + " -Start");

        if (Thread.currentThread().getName().equals("t1")) {
            System.out.println("******* Yield block for t1 entered*******");
            Thread.yield();
        }


        System.out.println("Current Thread:" + Thread.currentThread().getName() + " Priority " + Thread.currentThread().getPriority() + " -Finish");

    }

}