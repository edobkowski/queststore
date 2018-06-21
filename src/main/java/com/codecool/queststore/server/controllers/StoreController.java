package com.codecool.queststore.server.controllers;

import com.codecool.queststore.entities.Artifact;
import com.codecool.queststore.mappers.ArtifactMapper;
import com.codecool.queststore.services.ArtifactManager;
import com.codecool.queststore.services.ServiceLayerException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class StoreController implements HttpHandler {

    private final ArtifactManager artifactManager;
    private final ArtifactMapper artifactMapper;

    public StoreController() {
        this.artifactManager = new ArtifactManager();
        this.artifactMapper = new ArtifactMapper();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response = "";
        String method = exchange.getRequestMethod();

        if(method.equalsIgnoreCase("GET")) {
            try {

                List<Artifact> artifacts = artifactManager.getAll();
                response = artifactMapper.mapToJson(artifacts);
                setResponseHeader(exchange, MimeType.JSON);
                exchange.sendResponseHeaders(200, response.length());

            } catch (ServiceLayerException e) {

                response = e.getMessage();
                setResponseHeader(exchange, MimeType.TEXT);
                exchange.sendResponseHeaders(500, response.length());
                e.printStackTrace();
            }
        }

        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(response.getBytes());
        responseBody.close();

    }

    private void setResponseHeader(HttpExchange exchange, MimeType type) {
        String mimeTypeCode = type.getTypeCode();

        exchange.getResponseHeaders().set("Content-Type", mimeTypeCode);
    }
}
