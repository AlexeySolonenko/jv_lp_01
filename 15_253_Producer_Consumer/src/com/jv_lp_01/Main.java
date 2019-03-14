package com.jv_lp_01;
/* does not work! need a static import ! */

import com.jv_lp_01.ThreadColor.*;

import static com.jv_lp_01.Main.EOF;
import static com.jv_lp_01.ThreadColor.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
//import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        //List<String> buffer = new ArrayList<String>();
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        /* to avoid using synchronization */
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

//        MyProducer producer = new MyProducer(buffer, ANSI_GREEN, bufferLock);
//        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_BLUE, bufferLock);
//        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_RED, bufferLock);
        MyProducer producer = new MyProducer(buffer, ANSI_GREEN );
        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_BLUE );
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_RED);

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        /* !!!! future is not promise - it will hang/lock the application!! */
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ANSI_CYAN + "I'm being printed for the Callable class");
                return "this is the callabler result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch(InterruptedException e){
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();

    }


}

class MyProducer implements Runnable {
    //private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
    //private ReentrantLock bufferLock;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color /*, ReentrantLock bufferLock*/) {
        this.buffer = buffer;
        this.color = color;
        //this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
                /* use reentrantLock instead of synchronized block */
                //synchronized (buffer) {
                //bufferLock.lock();
//                try {
//                   // buffer.add(num);
//                } finally {
//                    //bufferLock.unlock();
//                }

                //}

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");

        //synchronized (buffer) {
        //bufferLock.lock();
        try {
            buffer.put(EOF);
            //buffer.add(EOF);
        } catch(InterruptedException e){
            System.out.println("putting eof interrupted");
        }
//        } finally {
//            //bufferLock.unlock();
//        }
        //}

    }
}


class MyConsumer implements Runnable {
    //private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
    //private ReentrantLock bufferLock;

    public ArrayBlockingQueue<String> getBuffer() {
        return buffer;
    }

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color /*, ReentrantLock bufferLock*/) {
        this.buffer = buffer;
        this.color = color;
        //this.bufferLock = bufferLock;
    }

    public void run() {
        //int counter = 0;

        while (true) {
            //if (bufferLock.tryLock()) {
            //synchronized (buffer) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        //bufferLock.unlock();
                        continue;
                    }
                    //System.out.println(color + "The counter = " + counter);
                    //counter = 0;
                    /* don't remove to prevent endless loop */
                    //if (buffer.get(0).equalsIgnoreCase(EOF)) {
                    if (buffer.peek().equalsIgnoreCase(EOF)) {
                        System.out.println(color + "Exiting ");
                        //bufferLock.unlock();
                        break;
                    } else {
                        //System.out.println(color + "Removed " + buffer.remove(0));
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
//                } finally {
//                    bufferLock.unlock();
//                }
            } //else {
            //counter++;
            //}
        }
            //}
      //  }
    }

    public void setBuffer(ArrayBlockingQueue<String> buffer) {
        this.buffer = buffer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
