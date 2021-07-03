package com.misacfd.meshconverter;

import java.util.List;

public class FvCell {
    long ident;
    List<Point> vertex;
    List<Face> faces;
    List<FvCell> neighbors;
    double vol;

    public FvCell(long ident, List<Point> vertex, List<Face> faces, List<FvCell> neighbors, double vol) {
        this.ident = ident;
        this.vertex = vertex;
        this.faces = faces;
        this.neighbors = neighbors;
        this.vol = vol;
    }

    public FvCell() {

    }

    public long getIdent() {
        return ident;
    }

    public void setIdent(long ident) {
        this.ident = ident;
    }

    public List<Point> getVertex() {
        return vertex;
    }

    public void setVertex(List<Point> vertex) {
        this.vertex = vertex;
    }

    public List<Face> getFaces() {
        return faces;
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }

    public List<FvCell> getNeighbor() {
        return neighbors;
    }

    public void setNeighbor(List<FvCell> neighbors) {
        this.neighbors = neighbors;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }
}
