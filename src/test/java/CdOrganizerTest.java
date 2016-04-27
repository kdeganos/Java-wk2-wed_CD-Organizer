import org.junit.*;
import static org.junit.Assert.*;

public class CdOrganizerTest {

  @Test
  public void Task_instantiatesCorrectly_true() {
    CdOrganizer myCdOrganizer = new CdOrganizer("Disc 1");
    assertEquals(true, myCdOrganizer instanceof CdOrganizer);
  }

}
