package org.example;

import java.util.ArrayList;
import java.util.List;

public class ColourTable {
    private int paletteSize;
    private List<int[]> colourTable;

    public ColourTable(int paletteSize) {
        if (invalidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Palette size invalid.");
        }

        this.paletteSize = paletteSize;
        this.colourTable = new ArrayList<>();
    }


    public static boolean invalidPaletteSize(int size) {
        return size > 1 && size < 1025 && (size & (size - 1)) == 0;
    }

}
