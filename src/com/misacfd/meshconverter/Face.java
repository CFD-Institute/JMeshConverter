package com.misacfd.meshconverter;

public class Face {
    private Point p1, p2, centroid;
    private int bcTyp;
    private long idFace;
    private double area;

    public Face(Point p1, Point p2, Point centroid, int bcTyp, long idFace, double area) {
        this.p1 = p1;
        this.p2 = p2;
        this.centroid = centroid;
        this.bcTyp = bcTyp;
        this.idFace = idFace;
        this.area = area;
    }

    public Face() {

    }

    public Point getP1() {
        return p1;
    }

    public Face setP1(Point p1) {
        this.p1 = p1;
        return this;
    }

    public Point getP2() {
        return p2;
    }

    public Face setP2(Point p2) {
        this.p2 = p2;
        return this;
    }

    public Point getCentroid() {
        return centroid;
    }

    public void setCentroid(Point centroid) {
        this.centroid = centroid;
    }

    public int getBcTyp() {
        return bcTyp;
    }

    public void setBcTyp(int bcTyp) {
        this.bcTyp = bcTyp;
    }

    public long getIdFace() {
        return idFace;
    }

    public void setIdFace(long idFace) {
        this.idFace = idFace;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
