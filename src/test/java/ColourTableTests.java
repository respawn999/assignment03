import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ColourTableTests {
   @Test
   public void validPaletteSize(){
      assertTrue(ColourTable.invalidPaletteSize(2));
   }
}
