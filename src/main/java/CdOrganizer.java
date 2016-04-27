import java.util.ArrayList;

public class CdOrganizer {
  private String mTitle;
  private String mArtist;
  private static ArrayList<CdOrganizer> instances = new ArrayList<CdOrganizer>();

  public CdOrganizer(String title) {
    mTitle = title;
    instances.add(this);
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList<CdOrganizer> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }
}
