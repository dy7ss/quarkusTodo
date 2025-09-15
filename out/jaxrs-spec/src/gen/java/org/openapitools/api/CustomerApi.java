package org.openapitools.api;

import org.openapitools.model.Customer;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


@Path("/customer")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public interface CustomerApi {

    @GET
    @Produces({ "application/json" })
    Customer customerGet();

    @POST
    @Consumes({ "application/json" })
    void customerPost(@Valid @NotNull Customer customer);
}
