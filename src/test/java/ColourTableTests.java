import org.example.ColourTable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ColourTableTests {
   @Test
   public void validPaletteSize() {
      assertTrue(ColourTable.invalidPaletteSize(2));
      assertTrue(ColourTable.invalidPaletteSize(4));
      assertTrue(ColourTable.invalidPaletteSize(8));
      assertTrue(ColourTable.invalidPaletteSize(16));
      assertFalse(ColourTable.invalidPaletteSize(3));
      assertFalse(ColourTable.invalidPaletteSize(5));
      assertFalse(ColourTable.invalidPaletteSize(643));
      assertFalse(ColourTable.invalidPaletteSize(3000));
   }

   @Test
   public void paletteSizeLimit() {
      ColourTable colourTable = new ColourTable(4);
      colourTable.add(new int[]{0, 0, 0});
      colourTable.add(new int[]{43, 0, 76});
      colourTable.add(new int[]{33, 0, 11});
      colourTable.add(new int[]{23, 0, 4});

      RuntimeException exception = assertThrows(RuntimeException.class, () -> colourTable.add(new int[]{0, 0, 255}));
   }


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

}