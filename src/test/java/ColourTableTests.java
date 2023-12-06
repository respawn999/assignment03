import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test class for ColourTable. Tests all the methods for validity.
 */
public class ColourTableTests {


   /**
    * This method checks for the correct behaviour of the 'invalidPaletteSize' method.
    * It checks if it will detect valid and invalid inputs and will change its boolean value
    * accordingly
    */
   @Test
   public void validPaletteSize() {
      assertTrue(ColourTable.validPaletteSize(2));
      assertTrue(ColourTable.validPaletteSize(4));
      assertTrue(ColourTable.validPaletteSize(8));
      assertTrue(ColourTable.validPaletteSize(16));
      assertFalse(ColourTable.validPaletteSize(3));
      assertFalse(ColourTable.validPaletteSize(5));
      assertFalse(ColourTable.validPaletteSize(643));
      assertFalse(ColourTable.validPaletteSize(3000));
   }

   /**
    * This test checks whether the inputs into the array "colourTable" are valid and
    * if an exception will be raised given the amount of inputs exceeds the array limit.
    */
   @Test
   public void paletteSizeLimit() {
      ColourTable colourTable = new ColourTable(4);
      colourTable.add(new int[]{0, 0, 0});
      colourTable.add(new int[]{43, 0, 76});
      colourTable.add(new int[]{33, 0, 11});
      colourTable.add(new int[]{23, 0, 4});

      RuntimeException exception = assertThrows(RuntimeException.class, () -> colourTable.add(new int[]{0, 0, 255}));
   }


   /**
    * This test checks whether the colour the developer inputted possesses the correct RGB values
    * which are specified by the RGB range of 0-255. An exception is raised if any of the RGB
    * values are out of range.
    */
   @Test
   public void rgbValidity() {
      ColourTable colourTable = new ColourTable(4);
      colourTable.add(new int[]{0, 0, 0});
      colourTable.add(new int[]{43, 0, 76});
      colourTable.add(new int[]{33, 0, 11});

      IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> colourTable.add(new int[]{0, 0, 256}));
      IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> colourTable.add(new int[]{-1, 0, 256}));
      IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> colourTable.add(new int[]{333, -4, 256}));
      IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class, () -> colourTable.add(new int[]{-255, 555, 32}));
      IllegalArgumentException exception5 = assertThrows(IllegalArgumentException.class, () -> colourTable.add(new int[]{0,33,-5}));

   }

   /**
    * This test checks if an input value in the add method is already inside the
    * colourTable array. An exception is raised if the colour is already found as an element
    * of the array
    */
   @Test
   public void ifDuplicate() {
      ColourTable colourTable = new ColourTable(16);
      colourTable.add(new int[]{0, 0, 0});
      colourTable.add(new int[]{43, 0, 76});
      colourTable.add(new int[]{255, 0, 255});
      colourTable.add(new int[]{0, 45, 0});
      colourTable.add(new int[]{22, 0, 0});
      colourTable.add(new int[]{0, 0, 56});
      colourTable.add(new int[]{255, 255, 255});

      RuntimeException exception = assertThrows(RuntimeException.class, () -> colourTable.add(new int[]{0,0,0}));
      RuntimeException exception2 = assertThrows(RuntimeException.class, () -> colourTable.add(new int[]{255, 0, 255}));
      RuntimeException exception3 = assertThrows(RuntimeException.class, () -> colourTable.add(new int[]{0, 45, 0}));
      RuntimeException exception4 = assertThrows(RuntimeException.class, () -> colourTable.add(new int[]{22, 0, 0}));
      RuntimeException exception5 = assertThrows(RuntimeException.class, () -> colourTable.add(new int[]{0, 0, 56}));
      RuntimeException exception6 = assertThrows(RuntimeException.class, () -> colourTable.add(new int[]{255, 255, 255}));

   }

}