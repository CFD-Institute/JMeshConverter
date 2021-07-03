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
        for (FvCell currentCell : cells) {
            List<Face> faces = new ArrayList<>();
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

            currentCell.setFaces(faces);
        }
    }

    public void assignBoundaryCondition() {

    }

    public void detectNearestNeighbor() {

        for (FvCell currentCell : cells) {
            long idNode1 = currentCell.getVertex().get(0).getIdent();
            long idNode2 = currentCell.getVertex().get(1).getIdent();

            for (FvCell anotherCell : cells) {
                if (anotherCell == currentCell) {
                    // do nothing
                } else {
                    int count = 0;

                    if (idNode1 == anotherCell.getVertex().get(0).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(0).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(1).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(1).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(2).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(2).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(3).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(3).getIdent()) count++;

                    if (count == 2) {
                        currentCell.setNeighbor(anotherCell);
                    }
                }

            }
        }

        for (FvCell currentCell : cells) {
            long idNode1 = currentCell.getVertex().get(1).getIdent();
            long idNode2 = currentCell.getVertex().get(2).getIdent();

            for (FvCell anotherCell : cells) {
                if (anotherCell == currentCell) {
                    // do nothing
                } else {
                    int count = 0;

                    if (idNode1 == anotherCell.getVertex().get(0).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(0).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(1).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(1).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(2).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(2).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(3).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(3).getIdent()) count++;

                    if (count == 2) {
                        currentCell.setNeighbor(anotherCell);
                    }
                }

            }
        }

        for (FvCell currentCell : cells) {
            long idNode1 = currentCell.getVertex().get(2).getIdent();
            long idNode2 = currentCell.getVertex().get(3).getIdent();

            for (FvCell anotherCell : cells) {
                if (anotherCell == currentCell) {
                    // do nothing
                } else {
                    int count = 0;

                    if (idNode1 == anotherCell.getVertex().get(0).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(0).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(1).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(1).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(2).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(2).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(3).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(3).getIdent()) count++;

                    if (count == 2) {
                        currentCell.setNeighbor(anotherCell);
                    }
                }

            }
        }

        for (FvCell currentCell : cells) {
            long idNode1 = currentCell.getVertex().get(3).getIdent();
            long idNode2 = currentCell.getVertex().get(0).getIdent();

            for (FvCell anotherCell : cells) {
                if (anotherCell == currentCell) {
                    // do nothing
                } else {
                    int count = 0;

                    if (idNode1 == anotherCell.getVertex().get(0).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(0).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(1).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(1).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(2).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(2).getIdent()) count++;

                    if (idNode1 == anotherCell.getVertex().get(3).getIdent()) count++;
                    if (idNode2 == anotherCell.getVertex().get(3).getIdent()) count++;

                    if (count == 2) {
                        currentCell.setNeighbor(anotherCell);
                    }
                }

            }
        }
    }

    public void writeVtk() {

    }

    public void writeTecplot() {

    }
}
