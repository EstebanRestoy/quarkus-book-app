package org.acme;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Path("/accueil")
public class Accueil {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance accueil(List<Livre> books);
    }

    @Inject
    Storage storage;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("booksList") String booksList) throws IOException {
        Bucket bucket = storage.get("book-app-db-esteban");
        System.out.println("Bucket: " + bucket);
        Blob blob = bucket.get("books.json");
//        Store the blob data in a JsonArray
        JsonArray booksArray = new JsonArray(Collections.singletonList(blob.getContent()));
//        Create a list of books
        List<Livre> books = new ArrayList<>();
//        Iterate over the JsonArray
        for (Object object : booksArray) {
//            Cast each element to a JsonObject
            JsonObject jsonObject = (JsonObject) object;
//            Create a book instance and add it to the list
            books.add(new Livre(jsonObject.getString("titre"), jsonObject.getString("auteur"), jsonObject.getString("editeur"), jsonObject.getString("image"), jsonObject.getString("date"), jsonObject.getString("prix")));
        }
        return Templates.accueil(books);
    }
}