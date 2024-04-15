package com.labseq;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class LabSeqResourceTest {

    @Test
    void testEndpointGetLabSeq_0() {
        given()
                .when().get("labseq/0")
                .then()
                .statusCode(200)
                .body(is("0"));
    }

    @Test
    void testEndpointGetLabSeq_negativeException() {
        given()
                .when().get("labseq/-1")
                .then()
                .statusCode(400);
    }
}
