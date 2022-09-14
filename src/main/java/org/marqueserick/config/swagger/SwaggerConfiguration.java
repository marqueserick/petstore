package org.marqueserick.config.swagger;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name="Pet Controller", description="Tudo sobre seu Pet"),
                @Tag(name="Compra Controller", description="Informações sobre compras")
        },
        info = @Info(
                title="Pet Store",
                version = "1.0.0",
                contact = @Contact(
                        name = "Erick Marques",
                        url = "http://linkedin.com/in/marqueserick",
                        email = "erickmarques43@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class SwaggerConfiguration extends Application {
}
