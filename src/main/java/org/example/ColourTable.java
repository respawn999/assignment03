package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class creates a colour palette of specified size which takes in RGB values stored as an
 * integer list inside an ArrayList
 * The classes functionality extends to the ability to add colours into the palette via the add method.
 * The class provides error handling which raises exceptions under these following conditions
 * <p></p>
 * 1. If the palette size specified is out of range (no less than 1 and no more than 1024) or not a power of 2
 * 2. If the inputted RGB values creating a colour are out of RGB range (0-255)
 * 3. If the colour that the developer wants to add to the palette is already in the palette
 *<p></p>
 * Using this class a colour palette can be created by creating an instance of the class and
 * specifying a valid size of the palette.
 */
public class ColourTable {

    private int paletteSize;

    // Array list colourTable
    private List<int[]> colourTable;

    /**
     * This is the constructor for the class ColourTable. When instantiated, it creates a
     * palette of given size paletteSize
     * <p></p>
     * @param paletteSize The size of palette specified by the user
     */
    public ColourTable(int paletteSize) {
        if (!validPaletteSize(paletteSize)) {
            // Error handling for if the palette size is out of range or not a power of 2
            throw new IllegalArgumentException("Invalid specified palette sized, must be a power of 2 and between 1 and 1025");
        }

        this.paletteSize = paletteSize;
        this.colourTable = new ArrayList<>();
    }

    /**
     * This method handles the valid range of the size of the palette given the requirements.
     * The return value is either true or false.
     * <p></p>
     * @param size Size of the palette
     * <p></p>
     * @return true if in range and valid or false if not in range and invalid.
     */
    public static boolean validPaletteSize(int size) {
        // True if size is between 1 and 1024 and is a power of 2, false in any other case
        return size > 1 && size < 1025 && (size & (size - 1)) == 0;
    }


    /**
     * Method for the developer to add colours to the palette. Includes exception handling
     * for invalid and duplicate RGB entries.
     * <p></p>
     * @param rgbValues An integer array of RGB values.
     * <p></p>
     */
    public void add(int[] rgbValues) {

        if (isDuplicate(rgbValues)) {
            // Error handling for if the colour already exists in the palette
            throw new RuntimeException("The colour is already in the palette");}

        // Iterating through the RGB integer array, checking if every value is within true RGB range
        for (int rgbValue : rgbValues) {
            if (rgbValue < 0 || rgbValue > 255) {
                // Error handling for if the colour is invalid
                throw new IllegalArgumentException("No such RGB value exists, numbers must be between 0 and 255");
            }
        }
        if (colourTable.size() >= paletteSize) {
            // Error handling for if no more colours can be added to the palette
            throw new RuntimeException("Palette size exceeded");
        }

        // Adding the colour to the palette
        colourTable.add(rgbValues);

    }

    /**
     * Method that checks whether the RGB input is already in the array
     * <p></p>
     * @param rgbValues An integer array of RGB values.
     * <p></p>
     * @return true if in the array, false if not present.
     */
    public boolean isDuplicate(int [] rgbValues) {
        // Iterating through values in colour table to find each colour
        for (int[] colour : colourTable) {
            // If the user input already exists within the array, value is set to true
            if (Arrays.equals(colour, rgbValues))
            return true;
        }
        // Otherwise, it is set to false
        return false;
    }

    }
