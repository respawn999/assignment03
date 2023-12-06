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

        if (isDuplicate(rgbValues)) {

            throw new RuntimeException("The colour is already in the palette");
        }

        for (int rgbValue : rgbValues) {
            if (rgbValue < 0 || rgbValue > 255) {
                throw new IllegalArgumentException("No such RGB value exists, numbers must be between 0 and 255");
            }
        }
        if (colourTable.size() >= paletteSize) {
            throw new RuntimeException("Palette size exceeded");
        }

        colourTable.add(rgbValues);

    }

    public boolean isDuplicate(int [] rgbValues) {
        for (int[] colour : colourTable) {
            if (Arrays.equals(colour, rgbValues))
            return true;
        }
        return false;
    }

    }
