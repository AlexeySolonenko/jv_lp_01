package com.jv_lp_01;

public class Monitor {
    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativResolution;

    public Monitor(String model, String manufacturer, int size, Resolution nativResolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativResolution = nativResolution;
    }

    public void drawPixelAt(int x, int y, String color){
        System.out.println("Drawing pixel at " + x + ", " + y +" in colour = " + color);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Resolution getNativResolution() {
        return nativResolution;
    }

    public void setNativResolution(Resolution nativResolution) {
        this.nativResolution = nativResolution;
    }
}
