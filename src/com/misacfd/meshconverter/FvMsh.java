package com.misacfd.meshconverter;

import java.util.ArrayList;
import java.util.List;

public class FvMsh {
    GmshReader mshReader;
    List<FvCell> cells;

    public FvMsh(GmshReader mshReader, List<FvCell> cells) {
        this.mshReader = mshReader;
        this.cells = cells;
    }

    public FvMsh(GmshReader mshReader) {
        this.mshReader = mshReader;
        this.cells = new ArrayList<>();
    }

    public GmshReader getMshReader() {
        return mshReader;
    }

    public void setMshReader(GmshReader mshReader) {
        this.mshReader = mshReader;
    }

    public List<FvCell> getCells() {
        return cells;
    }

    public void setCells(List<FvCell> cells) {
        this.cells = cells;
    }

    public void assignVertex() {

    }

    public void assignFaces() {

    }
    public void assignBoundaryCondition() {

    }

    public void detectNearestNeighbor() {

    }

    public void writeVtk() {

    }

    public void writeTecplot() {

    }
}
