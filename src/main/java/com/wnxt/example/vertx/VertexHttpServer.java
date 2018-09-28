package com.wnxt.example.vertx;

import io.vertx.core.Vertx;

/*
 * Simple http server.
 */
public class VertexHttpServer {

    public static void main(String[] args) {
        startSimpleServer("localhost", 9999);
    }
    public static void startSimpleServer(String host, int port) {
        Vertx.vertx().createHttpServer()
                .requestHandler(request -> {
                    //request.path()
                    request.response()
                            .setStatusCode(200)
                            .setStatusMessage("Hi from Vertx").end();
                })
                .listen(port, host);
    }
}
