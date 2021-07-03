package com.misacfd.meshconverter;

import java.util.ArrayList;
import java.util.List;

public class FvCell {
    private long ident;
    private List<Point> vertex;
    private List<Face> faces;
    private List<FvCell> neighbors;
    private double vol;

    public FvCell(long ident, List<Point> vertex, List<Face> faces, List<FvCell> neighbors, double vol) {
        this.ident = ident;
        this.vertex = vertex;
        this.faces = faces;
        this.neighbors = neighbors;
        this.vol = vol;
    }

    public FvCell() {
        ident = 0;
        vertex = new ArrayList<>();
        faces = new ArrayList<>();
        neighbors = new ArrayList<>();
        vol = 0.0;
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

    public List<FvCell> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<FvCell> neighbors) {
        this.neighbors = neighbors;
    }

    public void setNeighbor(FvCell neighbor) {
        neighbors.add(neighbor);
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }
}
