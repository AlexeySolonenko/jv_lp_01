package com.jv_lp_01;

public class Room {
    Furniture theFurniture;
    Floor theFloor;
    Door theDoor;
    private String view;

    public Room(Furniture theFurniture, Floor theFloor, Door theDoor, String view) {
        this.theFurniture = theFurniture;
        this.theFloor = theFloor;
        this.theDoor = theDoor;
        this.view = view;
    }


    public int findLowestFireResistance(){
        int ret = theDoor.getFireSafety().getFlameResistance();
        if(theFurniture.getFireSafety().getFlameResistance() < ret){
            ret = theDoor.getFireSafety().getFlameResistance();
        }
        if(theFloor.getFireSafety().getFlameResistance() < ret){
            ret = theFloor.getFireSafety().getFlameResistance();
        }

        return ret;
    }
    public int findLowestFlashPoint(){
        int ret = theDoor.getFireSafety().getFlashPoint();
        if(theFurniture.getFireSafety().getFlashPoint() < ret){
            ret = theDoor.getFireSafety().getFlashPoint();
        }
        if(theFloor.getFireSafety().getFlashPoint() < ret){
            ret = theFloor.getFireSafety().getFlashPoint();
        }

        return ret;

    }

    private Furniture getTheFurniture() {

        return theFurniture;
    }

    private void setTheFurniture(Furniture theFurniture) {
        this.theFurniture = theFurniture;
    }

    private Floor getTheFloor() {
        return theFloor;
    }

    private void setTheFloor(Floor theFloor) {
        this.theFloor = theFloor;
    }

    private Door getTheDoor() {
        return theDoor;
    }

    private void setTheDoor(Door theDoor) {
        this.theDoor = theDoor;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
