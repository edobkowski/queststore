package com.codecool.queststore.server.controllers;

import com.codecool.queststore.entities.Level;
import com.codecool.queststore.mappers.LevelMapper;
import com.codecool.queststore.services.LevelManager;
import com.codecool.queststore.services.ServiceLayerException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;

public class LevelController implements HttpHandler {
    private final LevelManager levelManager;
    private final LevelMapper levelMapper;

    public LevelController() {
        this.levelManager = new LevelManager();
        this.levelMapper = new LevelMapper();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "";
        String requestMethod = exchange.getRequestMethod();

        URI uri = exchange.getRequestURI();
        boolean uriHasIdentifier = URIparser.hasIdentifier(uri);
        int identifier = uriHasIdentifier ? URIparser.parseIdentifierToInt(uri) : -1;

        if (requestMethod.equals("GET")) {
            try {
                List<Level> levels = uriHasIdentifier ? levelManager.get(identifier) : levelManager.getAll();
                response = levelMapper.mapToJson(levels);

                System.out.println("Levels size: " + levels.size());
                System.out.println(response);

                setResponseHeader(exchange, MimeType.JSON);
                exchange.sendResponseHeaders(200, response.length());
            } catch (ServiceLayerException e) {
                response = e.getMessage();

                setResponseHeader(exchange, MimeType.TEXT);
                exchange.sendResponseHeaders(500, response.length());
            }
        } else if (requestMethod.equals("POST")) {
            try {
                levelManager.create("Focus day monk", 666);

                exchange.sendResponseHeaders(201, response.length());
            } catch (ServiceLayerException e) {
                response = e.getMessage();

                setResponseHeader(exchange, MimeType.TEXT);
                exchange.sendResponseHeaders(500, response.length());
            }
        } else if (requestMethod.equals("PUT")) {
            try {
                if (uriHasIdentifier) {
                    int id = 5;
                    String name = "Focus Day Noob";
                    int threshold = 999;

                    levelManager.edit(id, name, threshold);

                    exchange.sendResponseHeaders(201, response.length());
                } else {
                    throw new ServiceLayerException("Request invalid: no identifier");
                }
            } catch (ServiceLayerException e) {
                response = e.getMessage();

                setResponseHeader(exchange, MimeType.TEXT);
                exchange.sendResponseHeaders(500, response.length());
            }
        } else if (requestMethod.equals("DELETE")) {
            try {
                if (uriHasIdentifier) {
                    levelManager.remove(identifier);

                    exchange.sendResponseHeaders(204, response.length());
                } else {
                    throw new ServiceLayerException("Request invalid: no identifier");
                }
            } catch (ServiceLayerException e) {
                response = e.getMessage();

                setResponseHeader(exchange, MimeType.TEXT);
                exchange.sendResponseHeaders(500, response.length());
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
