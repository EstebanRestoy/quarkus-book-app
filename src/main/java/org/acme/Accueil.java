package org.acme;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Accueil {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance hello(String name);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {
        return Templates.hello("Test");
    }
}