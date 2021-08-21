package com.misacfd.meshconverter;

import java.io.*;
import java.util.List;

/**
 * @author Truong Dang.
 * Created on Aug, 2021.
 */
public class TecplotMeshExporter implements IMeshExporter {
    /**
     * Write converted mesh file in Tecplot 2009 compatible format
     */
    @Override
    public void writeUnstructuredQuadMesh(BaseMeshReader mshReader, List<FvCell> cells) throws IOException {
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
