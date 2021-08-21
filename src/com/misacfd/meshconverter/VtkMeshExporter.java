package com.misacfd.meshconverter;

import java.io.*;
import java.util.List;

/**
 * @author Truong Dang.
 * Created on Aug, 2021.
 */
public class VtkMeshExporter implements IMeshExporter {
    @Override
    public void writeUnstructuredQuadMesh(BaseMeshReader mshReader, List<FvCell> cells) throws IOException {
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
}
