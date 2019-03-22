package com.jv_lp_01;

public class Point {

    private int x;
    private int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        Point a = new Point(0, 0);
        Point b = this;

        return Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) +
                (b.getY() - a.getY()) * (b.getY() - a.getY()));
    }

    public double distance(int x, int y) {
        Point a = new Point(x, y);
        Point b = this;

        return Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) +
                (b.getY() - a.getY()) * (b.getY() - a.getY()));
    }


    public double distance(Point a) {
        Point b = this;

        return Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) +
                (b.getY() - a.getY()) * (b.getY() - a.getY()));
    }




}
