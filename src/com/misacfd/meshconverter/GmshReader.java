package com.misacfd.meshconverter;

import java.util.List;

public class GmshReader {
    private long nbNode;
    private long nbElMsh;
    private long nbElm;
    private String fName;
    private List<Point> coordNodes;
    private List<NodeIdent> idNodes;
    private List<NodeIdentMsh> idNodesMsh;

    public long getNbNode() {
        return nbNode;
    }

    public void setNbNode(long nbNode) {
        this.nbNode = nbNode;
    }

    public long getNbElMsh() {
        return nbElMsh;
    }

    public void setNbElMsh(long nbElMsh) {
        this.nbElMsh = nbElMsh;
    }

    public long getNbElm() {
        return nbElm;
    }

    public void setNbElm(long nbElm) {
        this.nbElm = nbElm;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public List<Point> getCoordNodes() {
        return coordNodes;
    }

    public void setCoordNodes(List<Point> coordNodes) {
        this.coordNodes = coordNodes;
    }

    public List<NodeIdent> getIdNodes() {
        return idNodes;
    }

    public void setIdNodes(List<NodeIdent> idNodes) {
        this.idNodes = idNodes;
    }

    public List<NodeIdentMsh> getIdNodesMsh() {
        return idNodesMsh;
    }

    public void setIdNodesMsh(List<NodeIdentMsh> idNodesMsh) {
        this.idNodesMsh = idNodesMsh;
    }

    public void readMesh() {

    }

    public void constructIdNodes() {

    }
}
