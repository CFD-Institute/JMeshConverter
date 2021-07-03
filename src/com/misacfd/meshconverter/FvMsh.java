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
        List<Point> coordNodes = mshReader.getCoordNodes();

        for (int i = 0; i < mshReader.getNbElm(); i++) {

            FvCell aCell = new FvCell();
            List<Point> vertex = new ArrayList<>();

            aCell.setIdent(i);

            NodeIdent nodeIdent = mshReader.getIdNodes().get(i);
            long idNode = nodeIdent.getIdNode().get(5);

            loop1:
            for (long j = 0; j < mshReader.getNbNode(); j++) {
                if (idNode == coordNodes.get((int) j).getIdent()) {
                    double x = coordNodes.get((int) j).getX();
                    double y = coordNodes.get((int) j).getY();
                    double z = coordNodes.get((int) j).getZ();
                    Point vt1 = new Point.Builder()
                            .setIdent(idNode)
                            .setX(x)
                            .setY(y)
                            .setZ(z)
                            .build();
                    vertex.add(vt1);
                    break loop1;
                }
            }

            idNode = nodeIdent.getIdNode().get(6);

            loop2:
            for (long j = 0; j < mshReader.getNbNode(); j++) {
                if (idNode == coordNodes.get((int) j).getIdent()) {
                    double x = coordNodes.get((int) j).getX();
                    double y = coordNodes.get((int) j).getY();
                    double z = coordNodes.get((int) j).getZ();
                    Point vt2 = new Point.Builder()
                            .setIdent(idNode)
                            .setX(x)
                            .setY(y)
                            .setZ(z)
                            .build();
                    vertex.add(vt2);
                    break loop2;
                }
            }

            idNode = nodeIdent.getIdNode().get(7);

            loop3:
            for (long j = 0; j < mshReader.getNbNode(); j++) {
                if (idNode == coordNodes.get((int) j).getIdent()) {
                    double x = coordNodes.get((int) j).getX();
                    double y = coordNodes.get((int) j).getY();
                    double z = coordNodes.get((int) j).getZ();
                    Point vt3 = new Point.Builder()
                            .setIdent(idNode)
                            .setX(x)
                            .setY(y)
                            .setZ(z)
                            .build();
                    vertex.add(vt3);
                    break loop3;
                }
            }

            idNode = nodeIdent.getIdNode().get(8);

            loop4:
            for (long j = 0; j < mshReader.getNbNode(); j++) {
                if (idNode == coordNodes.get((int) j).getIdent()) {
                    double x = coordNodes.get((int) j).getX();
                    double y = coordNodes.get((int) j).getY();
                    double z = coordNodes.get((int) j).getZ();
                    Point vt4 = new Point.Builder()
                            .setIdent(idNode)
                            .setX(x)
                            .setY(y)
                            .setZ(z)
                            .build();
                    vertex.add(vt4);
                    break loop4;
                }
            }

            aCell.setVertex(vertex);
            this.cells.add(aCell);
        }
    }

    public void assignFaces() {
        for (long i = 0; i < mshReader.getNbElm(); i++) {
            List<Face> faces = new ArrayList<>();
            FvCell currentCell = this.cells.get((int) i);
            List<Point> vertex = currentCell.getVertex();
            Point p1 = vertex.get(0);
            Point p2 = vertex.get(1);
            Face face = new Face();

            face.setP1(p1).setP2(p2);
            faces.add(face);

            p1 = vertex.get(1); p2 = vertex.get(2);
            face.setP1(p1).setP2(p2);
            faces.add(face);

            p1 = vertex.get(2); p2 = vertex.get(3);
            face.setP1(p1).setP2(p2);
            faces.add(face);

            p1 = vertex.get(3); p2 = vertex.get(0);
            face.setP1(p1).setP2(p2);
            faces.add(face);

            this.cells.get((int) i).setFaces(faces);
        }
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
