package com.misacfd.meshconverter;

import sun.security.x509.OtherName;

import java.io.*;
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

    public void writeVtk() throws IOException {
        StringBuilder fName = new StringBuilder(mshReader.getfName()).append(".vtk");
        File fOut = new File(fName.toString());
        FileOutputStream fos = new FileOutputStream(fOut);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        List<Point> coordNodes  = mshReader.getCoordNodes();
        List<NodeIdent> idNodes = mshReader.getIdNodes();
        long nbNodes = mshReader.getNbNode();
        long nbElm = mshReader.getNbElm();

        bw.write("# vtk DataFile Version 2.0"); bw.newLine();
        bw.write("VTK Format for unstructured grid"); bw.newLine();
        bw.write("ASCII"); bw.newLine();
        bw.write("DATASET POLYDATA"); bw.newLine();
        bw.write(String.format("POINTS %s float", nbNodes)); bw.newLine();

        for (Point currentNode : coordNodes) {
            bw.write(String.format("%s %s %s", currentNode.getX(), currentNode.getY(), 0.0));
            bw.newLine();
        }

        bw.write(String.format("POLYGONS %s %s", nbElm, 5 * nbElm)); bw.newLine();

        for (NodeIdent idNode : idNodes) {
            bw.write(String.format("%s %s %s %s %s", 4, idNode.getIdNode().get(5) - 1, idNode.getIdNode().get(6) - 1, idNode.getIdNode().get(7) - 1, idNode.getIdNode().get(8) - 1));
            bw.newLine();
        }

        bw.write(String.format("CELL_DATA %s", nbElm)); bw.newLine();
        bw.write("SCALARS CELL_IDENT integer 1"); bw.newLine();
        bw.write("LOOKUP_TABLE default"); bw.newLine();

        for (FvCell cell : cells) {
            bw.write(String.format("%s", cell.getIdent()));
            bw.newLine();
        }

        bw.write("SCALARS NEIGHBOR1 integer 1"); bw.newLine();
        bw.write("LOOKUP_TABLE default"); bw.newLine();

        for (FvCell cell : cells) {
            FvCell neighborCell = cell.getNeighbors().get(0);

            if (neighborCell != null) {
                bw.write(String.format("%s", neighborCell.getIdent()));
                bw.newLine();
            } else {
                bw.write(String.format("%s", -1));
                bw.newLine();
            }
        }

        bw.write("SCALARS NEIGHBOR2 integer 1"); bw.newLine();
        bw.write("LOOKUP_TABLE default"); bw.newLine();

        for (FvCell cell : cells) {
            FvCell neighborCell = cell.getNeighbors().get(1);

            if (neighborCell != null) {
                bw.write(String.format("%s", neighborCell.getIdent()));
                bw.newLine();
            } else {
                bw.write(String.format("%s", -1));
                bw.newLine();
            }
        }

        bw.write("SCALARS NEIGHBOR3 integer 1"); bw.newLine();
        bw.write("LOOKUP_TABLE default"); bw.newLine();

        for (FvCell cell : cells) {
            if (cell.getNeighbors().size() < 3) {
                bw.write(String.format("%s", -1));
                bw.newLine();
                break;
            }

            FvCell neighborCell = cell.getNeighbors().get(2);

            if (neighborCell != null) {
                bw.write(String.format("%s", neighborCell.getIdent()));
                bw.newLine();
            } else {
                bw.write(String.format("%s", -1));
                bw.newLine();
            }
        }

        bw.write("SCALARS NEIGHBOR4 integer 1"); bw.newLine();
        bw.write("LOOKUP_TABLE default"); bw.newLine();

        for (FvCell cell : cells) {
            if (cell.getNeighbors().size() < 4) {
                bw.write(String.format("%s", -1));
                bw.newLine();
                break;
            }

            FvCell neighborCell = cell.getNeighbors().get(3);

            if (neighborCell != null) {
                bw.write(String.format("%s", neighborCell.getIdent()));
                bw.newLine();
            } else {
                bw.write(String.format("%s", -1));
                bw.newLine();
            }
        }

        bw.close();
    }

    /**
     * Write converted mesh file in Tecplot 2009 compatible format
     */
    public void writeTecplot() throws IOException {
        StringBuilder fName = new StringBuilder(mshReader.getfName()).append(".dat");
        File fOut = new File(fName.toString());
        FileOutputStream fos = new FileOutputStream(fOut);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        List<Point> coordNodes  = mshReader.getCoordNodes();
        List<NodeIdent> idNodes = mshReader.getIdNodes();
        long nbNodes = mshReader.getNbNode();
        long nbElm = mshReader.getNbElm();

        bw.write("VARIABLES=X,Y,CELL_IDENT,NEIGHBOR1,NEIGHBOR2,NEIGHBOR3,NEIGHBOR4"); bw.newLine();
        bw.write("VARIABLES=X,Y"); bw.newLine();
        bw.write("ZONE T=\"UNSTRUCTURED-COUNTOUR\""); bw.newLine();
        bw.write("ZONETYPE=FEPOLYGON"); bw.newLine();
        bw.write(String.format("NODES=%s", nbNodes)); bw.newLine();
        bw.write(String.format("ELEMENTS=%s", nbElm)); bw.newLine();
        bw.write(String.format("FACES=%s", nbElm * 4)); bw.newLine();
        bw.write("NumConnectedBoundaryFaces=0"); bw.newLine();
        bw.write("TotalNumBoundaryConnections=0"); bw.newLine();

        for (Point node : coordNodes) {
            bw.write(String.format("%s", node.getX()));
            bw.newLine();
        }

        for (Point node : coordNodes) {
            bw.write(String.format("%s", node.getY()));
            bw.newLine();
        }

        /*
         * Node indexes
         */
        for (NodeIdent idNode : idNodes) {
            bw.write(String.format("%s %s", idNode.getIdNode().get(5), idNode.getIdNode().get(6))); bw.newLine();
            bw.write(String.format("%s %s", idNode.getIdNode().get(6), idNode.getIdNode().get(7))); bw.newLine();
            bw.write(String.format("%s %s", idNode.getIdNode().get(7), idNode.getIdNode().get(8))); bw.newLine();
            bw.write(String.format("%s %s", idNode.getIdNode().get(8), idNode.getIdNode().get(5))); bw.newLine();
        }

        for (long i = 0; i < nbElm; i++) {
            bw.write(String.format("%s %s %s %s", i + 1, i + 1, i + 1, i + 1));
            bw.newLine();
        }

        for (long i = 0; i < nbElm; i++) {
            bw.write(String.format("%s %s %s %s", 0, 0, 0, 0));
            bw.newLine();
        }

        bw.close();
    }
}
