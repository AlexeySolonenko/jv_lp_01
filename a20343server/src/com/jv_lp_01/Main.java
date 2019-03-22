package com.jv_lp_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
//            Socket socket = serverSocket.accept();
//            System.out.println("Client Connected");
//            BufferedReader input = new BufferedReader(
//                    new InputStreamReader(socket.getInputStream()));
//            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);


            while(true){

                new Echoer(serverSocket.accept()).start();
//
//                Socket socket = serverSocket.accept();
//                System.out.println("Client Connected");
//                BufferedReader input = new BufferedReader(
//                        new InputStreamReader(socket.getInputStream()));
//                PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
//
//
//                String echoString = input.readLine();
//                try{
//                    Thread.sleep(15000);
//                } catch (InterruptedException e){
//                    System.out.println("Thread interrupted");
//                }
//                if(echoString.equalsIgnoreCase("Exit")){
//                    break;
//                }
//                output.println("Echo from server: " + echoString);
            }

        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
