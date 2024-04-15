package labseq.controller;

import labseq.exception.NegativeException;
import labseq.service.LabSeqService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/labseq")
public class LabSeqResource {

    @Inject
    LabSeqService labSeqService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{n}")
    @Operation(
            operationId = "getLabSeq",
            summary = "Get Lab Sequence",
            description = "Sequence’s (single) value to return"
    )
    @APIResponse(
            responseCode = "200",
            description = "Value of sequence’s returned"
    )
    @APIResponse(
            responseCode = "400",
            description = "Value of n cannot be negative",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = NegativeException.class))
    )
    public Response getLabSeq(@PathParam("n") int n) {
        return Response.ok(labSeqService.calculateLabSequence(n)).build();
    }
}
