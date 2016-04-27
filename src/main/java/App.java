import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

import java.util.ArrayList;


public class App {

  public static void main (String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cds",request.session().attribute("cds"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cds", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<CdOrganizer> cds = request.session().attribute("cds");
      if (cds == null) {
        cds = new ArrayList<CdOrganizer>();
        request.session().attribute("cds", cds);
      }

      String title = request.queryParams("title");
      CdOrganizer newCd = new CdOrganizer(title);
      cds.add(newCd);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/edit", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/edit.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/edit/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      CdOrganizer myCd = CdOrganizer.find(Integer.parseInt(request.params(":id")));

      model.put("cd", myCd);
      model.put("template", "templates/edit.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/edit/:id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<CdOrganizer> cds = request.session().attribute("cds");

      String updateTitle = request.queryParams("title");
      String updateArtist = request.queryParams("artist");

      cds.get(Integer.parseInt(request.params(":id"))).updateCd(updateTitle, updateArtist);

      model.put("cds",request.session().attribute("cds"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<CdOrganizer> cds = request.session().attribute("cds");
      ArrayList<String> artists = CdOrganizer.allArtists();
      model.put("artists", artists);
      model.put("cds", request.session().attribute("cds"));
      model.put("template", "templates/artists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artistAlbums/:artistName", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String artistName = request.params(":artistName");

      ArrayList<CdOrganizer> cds = request.session().attribute("cds");

      model.put("artistName", artistName);
      model.put("cds", request.session().attribute("cds"));
      model.put("template", "templates/artistAlbums.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
