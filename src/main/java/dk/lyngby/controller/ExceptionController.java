package dk.lyngby.controller;


import dk.lyngby.exception.ApiException;
import dk.lyngby.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.javalin.http.Context;

public class ExceptionController {

    private final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    public void apiExceptionHandler(ApiException e, Context ctx) {
        log.error("{} {}", ctx.res().getStatus(), e.getMessage());
        ctx.status(e.getStatusCode());
        ctx.json(new Message(e.getStatusCode(),e.getMessage()));
    }

}
