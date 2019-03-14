package com.jv_lp_01;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        try{
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try{
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i  = 0; i < 10; i++){
                            String currentTime = "The time is : " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();
                            while(buffer.hasRemaining()){
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(400);
                        }

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try{
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                        for(int i = 0; i < 10; i++){
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread : " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(400);
                        }
                    } catch (Exception e ){
                        e.printStackTrace();;
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

//    public static void main(String[] args) {
//        try (FileOutputStream binFile = new FileOutputStream("data.dat");
//             FileChannel binChannel = binFile.getChannel();) {
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//
//
//
//
//            byte[] outputBytes = "Hellow world!".getBytes();
//            buffer.put(outputBytes);
//            long int1Pos = outputBytes.length;
//
//            byte[] outputBytes2 = "Nit to meet you".getBytes();
//
//            buffer.putInt(245);
//            long int2Pos = int1Pos + Integer.BYTES;
//            buffer.putInt(-87765);
//            buffer.put(outputBytes2);
//            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
//            buffer.putInt(1000);
//            buffer.flip();
//            binChannel.write(buffer);
//
//
//
//            /* reading in one shot */
//            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
//            FileChannel channel = ra.getChannel();
//
//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(int3Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            System.out.println("Int 3 + " + readBuffer.getInt());
//            readBuffer.flip();
//            channel.position(int2Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            System.out.println("int 2 = " + readBuffer.getInt());
//            readBuffer.flip();
//            channel.position(int1Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int1 = " + readBuffer.getInt());
//
//            RandomAccessFile copyFiel = new RandomAccessFile("datacopy.dat","rw");
//            FileChannel copyChannnel = copyFiel.getChannel();
//            /* the position is relative, not absolute */
//            channel.position(0);
//            //long numTransferred = copyChannnel.transferFrom(channel,0,channel.size());
//            long numTransferred = channel.transferTo(0,channel.size(),copyChannnel);
//            System.out.println("Num transferred = " + numTransferred);
//
//
//
//            channel.close();
//            ra.close();
//            copyChannnel.close();
//
//
////
////            /*not sequential write  */
////            byte[] outputString = "Hello, World!".getBytes();
////            long str1Pos = 0;
////            long newInt1Pos = outputString.length;
////            long newInt2Pos = newInt1Pos + Integer.BYTES;
////            byte[] outputString2 = "Nice to meet you".getBytes();
////            long str2Pos = newInt2Pos + Integer.BYTES;
////            long newInt3Pos = str2Pos + outputString2.length;
////
////            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
////            intBuffer.putInt(+245);
////            intBuffer.flip();
////            binChannel.position(newInt1Pos);
////            binChannel.write(intBuffer);
////
////            intBuffer.flip();
////            intBuffer.putInt(-87765);
////            intBuffer.flip();
////            binChannel.position(newInt2Pos);
////            binChannel.write(intBuffer);
////
////            intBuffer.flip();
////            intBuffer.putInt(-+1000);
////            intBuffer.flip();
////            binChannel.position(newInt3Pos);
////            binChannel.write(intBuffer);
////
////            binChannel.position(str1Pos);
////            binChannel.write(ByteBuffer.wrap(outputString));
////            binChannel.position(str2Pos);
////            binChannel.write(ByteBuffer.wrap(outputString2));
////
////
//
//
//            /* CHAPTER */
//
//
//
//
////            ByteBuffer readBuffer = ByteBuffer.allocate(100);
////            channel.read(readBuffer);
////            readBuffer.flip();
////            byte[] inputString = new byte[outputBytes.length];
////            readBuffer.get(inputString);
////            System.out.println("inputString = " + new String(inputString));
////            System.out.println("int1 = " + readBuffer.getInt());
////            System.out.println("int2 = " + readBuffer.getInt());
////            byte[] inputString2 = new byte[outputBytes2.length];
////            readBuffer.get(inputString2);
////            System.out.println("inputString2 = " + new String(inputString2));
////            System.out.println("int3 = " + readBuffer.getInt());
//
//
//
//
//
//
////            /* wrap is a kind of binding */
////            //ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
////            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
////            buffer.put(outputBytes);
////            buffer.flip();
////            int numBytes = binChannel.write(buffer);
////
////            System.out.println("numBytes written was: " + numBytes);
////            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
////            intBuffer.putInt(245);
////            intBuffer.flip();
////            numBytes = binChannel.write(intBuffer);
////            System.out.println("numBytes written was: " + numBytes);
////
////
////            intBuffer.flip();
////            intBuffer.putInt(-98765);
////            intBuffer.flip();
////            //intBuffer.flip();
////            numBytes = binChannel.write(intBuffer);
////            System.out.println("numBytes written was: " + numBytes);
////
////            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
////            FileChannel channel = ra.getChannel();
////            outputBytes[0] = 'a';
////            outputBytes[1] = 'b';
////            buffer.flip();
////            long numBytesREad = channel.read(buffer);
////            if (buffer.hasArray()) {
////                System.out.println("byte buffer = " + new String(buffer.array()));
////                //System.out.println("byte buffer = " + new String(outputBytes));
////            }
////            /* relative read */
//////            intBuffer.flip();
//////            int numBytesRead = channel.read(intBuffer);
//////            intBuffer.flip();
//////            System.out.println(intBuffer.getInt());
//////            intBuffer.flip();
//////            numBytesRead = channel.read(intBuffer);
//////            intBuffer.flip();
//////            System.out.println(intBuffer.getInt());
//////            intBuffer.flip();
//////            channel.close();
//////            ra.close();
////
////            /* to avoid flip = use absolute call */
////            intBuffer.flip();
////            int numBytesRead = channel.read(intBuffer);
////            System.out.println(intBuffer.getInt(0));
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            System.out.println(intBuffer.getInt(0));
////            /* reads same twice */
////            //System.out.println(intBuffer.getInt());
////            intBuffer.flip();
////            channel.close();
////            ra.close();
//
//
//            System.out.println("outputBytes = " + new String(outputBytes));
////            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
////            byte[] b =new byte[outputBytes.length];
////            ra.read(b);
////            StringBuilder sb = new StringBuilder();
////            System.out.println(new String(b));
////            long int1 = ra.readInt();
////            long int2 = ra.readInt();
////            System.out.println(int1);
////            System.out.println(int2);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
