package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ColourTable {
    private int paletteSize;
    private List<int[]> colourTable;
    public ColourTable(int paletteSize) {
        if (!invalidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Invalid specified palette sized, must be a power of 2 and between 1 and 1025");
        }

        this.paletteSize = paletteSize;
        this.colourTable = new ArrayList<>();
    }

    public static boolean invalidPaletteSize(int size) {
        return size > 1 && size < 1025 && (size & (size - 1)) == 0;
    }


    public void add(int[] rgbValues) {
        if (colourTable.size() >= paletteSize) {
            throw new RuntimeException("Palette size exceeded");
        }
        if (!containsRGB(rgbValues)) {
            colourTable.add(rgbValues); // Add colour to palette
        }

    }


    public boolean containsRGB(int[] rgbValues) {
        for (int[] colour : colourTable) {
            if (Arrays.equals(colour, rgbValues)) {
                return true; // Colour in palette already
            }
        }
        return false; // Colour can be added to palette
    }


}
