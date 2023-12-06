import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ColourTableTests {
   @Test
   public void validPaletteSize(){
      assertTrue(ColourTable.invalidPaletteSize(2));
      assertTrue(ColourTable.invalidPaletteSize(4));
      assertTrue(ColourTable.invalidPaletteSize(8));
      assertTrue(ColourTable.invalidPaletteSize(16));
      assertFalse(ColourTable.invalidPaletteSize(3));
      assertFalse(ColourTable.invalidPaletteSize(5));
      assertFalse(ColourTable.invalidPaletteSize(643));
      assertFalse(ColourTable.invalidPaletteSize(3000));
   }
}
