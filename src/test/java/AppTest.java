import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("CD Organizer");
  }

  @Test
  public void cdIsDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#title").with("Disc 1");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Disc 1");
  }

  @Test
  public void cdEdit() {
    goTo("http://localhost:4567/");
    fill("#title").with("Disc 1");
    submit(".btn");
    click("a", withText("Go Back"));
    click("a", withText("Disc 1"));
    assertThat(pageSource()).contains("Disc 1");
  }

  // @Test
  // public void ArtistAlbums() {
  //   goTo("http://localhost:4567/");
  //   fill("#title").with("Disc 1");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   fill("#title").with("Disc 2");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   fill("#title").with("Disc 3");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   click("a", withText("Disc 1"));
  //   fill("#artist").with("This");
  //   submit(".btn");
  //   click("a", withText("Disc 2"));
  //   fill("#artist").with("This");
  //   submit(".btn");
  //   click("a", withText("Disc 3"));
  //   fill("#artist").with("That");
  //   submit(".btn");
  //   click("a", withText("See list of artists"));
  //   click("a", withText("This"));
  //   assertThat(pageSource()).contains("Disc 1");
  //
  // }


}
