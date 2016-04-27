import org.junit.*;
import static org.junit.Assert.*;

public class CdOrganizerTest {

  @After
    public void tearDown() {
      CdOrganizer.clear();
  }

  @Test
  public void CdOrganizer_instantiatesCorrectly_true() {
    CdOrganizer myCdOrganizer = new CdOrganizer("Disc 1");
    assertEquals(true, myCdOrganizer instanceof CdOrganizer);
  }

  @Test
  public void CdOrganizer_instantiatesWithTitle_String() {
    CdOrganizer myCdOrganizer = new CdOrganizer("Disc 1");
    assertEquals("Disc 1", myCdOrganizer.getTitle());
  }

  @Test
  public void all_returnsAllInstancesOfCdOrganizer_true() {
    CdOrganizer firstCd = new CdOrganizer("Disc 1");
    CdOrganizer secondCd = new CdOrganizer("Disc 2");
    assertTrue(CdOrganizer.all().contains(firstCd));
    assertTrue(CdOrganizer.all().contains(secondCd));
  }

  @Test
  public void clear_emptiesAllCdsFromArrayList_0() {
    CdOrganizer firstCd = new CdOrganizer("Disc 1");
    CdOrganizer secondCd = new CdOrganizer("Disc 2");
    CdOrganizer.clear();
    assertEquals(0, CdOrganizer.all().size());
  }

  @Test
  public void getId_cdOrgInstantiateWithAnID_0() {
    CdOrganizer myCdOrganizer = new CdOrganizer("Disc 1");
    assertEquals(0, myCdOrganizer.getId());
  }

  @Test
  public void find_returnsCdOrgWithSameId_secondCdOrg() {
    CdOrganizer firstCd = new CdOrganizer("Disc 1");
    CdOrganizer secondCd = new CdOrganizer("Disc 2");
    assertEquals(CdOrganizer.find(secondCd.getId()), secondCd);
  }

  @Test
  public void find_returnsNullWhenNoCdOrgFound_null() {
    assertTrue(CdOrganizer.find(999) == null);
  }
}
