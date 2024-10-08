package dk.lyngby.config;


import dk.lyngby.controller.ExceptionController;
import dk.lyngby.exception.ApiException;
import dk.lyngby.routes.Routes;
import dk.lyngby.util.ApiProps;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class AppConfig {

    private static final Routes routes = new Routes();
    private static final ExceptionController exceptionController = new ExceptionController();

    private static void configuration(JavalinConfig config) {
        // == server ==
        config.router.contextPath = ApiProps.API_CONTEXT;

        // == plugins ==
        config.bundledPlugins.enableRouteOverview("/routes");
        config.bundledPlugins.enableDevLogging();

        // == routes ==
        config.router.apiBuilder(routes.getApiRoutes());
    }

    private static void exceptionContext(Javalin app) {
        app.exception(ApiException.class, exceptionController::apiExceptionHandler);

    }

    // == start server ==
    public static void startServer() {
        Javalin app = io.javalin.Javalin.create(AppConfig::configuration);
        exceptionContext(app);
        app.start(ApiProps.PORT);
    }


}

