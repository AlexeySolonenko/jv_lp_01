package com.jv_lp_01;

import java.util.*;

public class Theatre {

    private final String theatreName;
    public List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()){
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()){
                return 1;
            } else {
                return 0;
            }
        }
    };



    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;
                if((row < 'D') && (seatNum >= 4 && seatsPerRow <=9)){
                    price = 14.00;
                } else if((row > 'F') || (seatNum < 4 || seatNum > 9)){
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum),price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber,0.00);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);

        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
//        for(Seat seat: seats){
//            System.out.print(".");
//            if(seat.getSeatNumber().equals(seatNumber)){
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if(requestedSeat == null){
//            System.out.println("There is no seath " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();
    }

    // for testing

    public void getSeats() {
        for(Seat seat: seats){
            System.out.println(seat.getSeatNumber());
        }
    }

    public Collection<Seat> getSeatsCollection(){
        return seats;
    }

//    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
//        if (c==null)
//            return binarySearch((List<? extends Comparable<? super T>>) list, key);
//
//        if (list instanceof RandomAccess || list.size()<BINARYSEARCH_THRESHOLD)
//            return Collections.indexedBinarySearch(list, key, c);
//        else
//            return Collections.iteratorBinarySearch(list, key, c);
//    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private double price;


        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public boolean reserve(){
            if(!reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seath " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber(){
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }


    }
}
