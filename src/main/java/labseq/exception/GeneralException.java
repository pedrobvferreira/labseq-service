package labseq.exception;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GeneralException implements ExceptionMapper<Exception> {
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(Exception e) {
        if(e instanceof NegativeException){
            return Response.status(Response.Status.BAD_REQUEST).entity("Value of n cannot be negative").build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal Error!").build();
    }
}
