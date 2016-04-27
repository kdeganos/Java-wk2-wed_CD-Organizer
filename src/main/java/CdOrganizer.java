import java.util.ArrayList;

public class CdOrganizer {
  private String mTitle;
  private String mArtist;
  private static ArrayList<CdOrganizer> instances = new ArrayList<CdOrganizer>();
  private int mId;
  private static ArrayList<String> artists = new ArrayList<String>();

  public CdOrganizer(String title) {
    mTitle = title;
    mId = instances.size();
    instances.add(this);
  }

  public String getTitle() {
    return mTitle;
  }

  public String getArtist() {
    return mArtist;
  }

  public static ArrayList<CdOrganizer> all() {
    return instances;
  }

  public static ArrayList<String> allArtists() {
    return artists;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static CdOrganizer find(int id) {
    try {
      return instances.get(id);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public void updateCd(String title, String artist) {
    mArtist = artist;
    mTitle = title;
    if (!artists.contains(artist)) {
      artists.add(artist);
    }
  }
}
