package com.misacfd.meshconverter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author Truong Dang.
 * Created on Aug, 2021.
 */
public interface IMeshExporter {
    void writeUnstructuredQuadMesh(BaseMeshReader baseMeshReader, List<FvCell> cells) throws IOException;
}
