package com.misacfd.meshconverter;

import java.util.List;

/**
 * @author Truong Dang.
 * Created on Aug, 2021.
 */
public class BaseMeshReader {
    protected long nbNode;
    protected long nbElm;
    protected String fName;
    protected List<Point> coordNodes;
    protected List<NodeIdent> idNodes;

    public long getNbNode() {
        return nbNode;
    }

    public void setNbNode(long nbNode) {
        this.nbNode = nbNode;
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

}
