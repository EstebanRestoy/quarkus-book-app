package org.acme;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Path("/accueil")
public class Accueil {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance accueil(List<Livre> books);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("booksList") String booksList) throws IOException {

        String booksJsonPath = "src/main/resources/books.json";
        // Read file content into string with - Files.readString(Path path) and convert it to a JsonArray
        JsonArray booksArray = new JsonArray(Files.readString(Paths.get(booksJsonPath)));
        // Create a list of books
        List<Livre> books = new ArrayList<>();
        // Iterate over the JsonArray
        for (Object object : booksArray) {
            // Cast each element to a JsonObject
            JsonObject jsonObject = (JsonObject) object;
            // Create a book instance and add it to the list
            books.add(new Livre(jsonObject.getString("titre"), jsonObject.getString("auteur"), jsonObject.getString("editeur"), jsonObject.getString("image"), jsonObject.getString("date"), jsonObject.getString("prix")));
        }
        // Return the template with the list of books
        return Templates.accueil(books);
    }
}