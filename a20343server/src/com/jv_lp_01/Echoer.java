package com.jv_lp_01;

import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //super.run();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while(true){
                String echoString = input.readLine();
                System.out.println("Received client input: " + echoString);
                if(echoString.equalsIgnoreCase("exit")){
                    break;
                }

                try{
                    Thread.sleep(15000);
                } catch (InterruptedException e){
                    System.out.println("Thread interrupted");

                }
                output.println(echoString);
            }


        } catch (IOException e) {
            System.out.println("IO Exception in Echoer Run " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                // do nothing
            }
        }

    }
}
