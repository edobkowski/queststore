package com.codecool.queststore.server.controllers;

import com.codecool.queststore.entities.Level;
import com.codecool.queststore.mappers.LevelMapper;
import com.codecool.queststore.services.LevelManager;
import com.codecool.queststore.services.ServiceLayerException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
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

        if (requestMethod.equals("GET")) {
            try {
                List<Level> allLevels = levelManager.getAll();
                response = levelMapper.mapToJson(allLevels);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
            } catch (ServiceLayerException e) {
                response = e.getMessage();
                exchange.getResponseHeaders().set("Content-Type", "text/plain");
            }
        } else if (requestMethod.equals("POST")) {
            try {
                levelManager.create("Focus day monk", 666);
            } catch (ServiceLayerException e) {
                response = e.getMessage();
                exchange.getResponseHeaders().set("Content-Type", "text/plain");
            }
        }

        exchange.sendResponseHeaders(200, response.length());

        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(response.getBytes());
        responseBody.close();
    }
}
