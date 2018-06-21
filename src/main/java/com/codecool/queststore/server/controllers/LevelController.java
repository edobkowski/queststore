package com.codecool.queststore.server.controllers;

import com.codecool.queststore.entities.Level;
import com.codecool.queststore.mappers.LevelMapper;
import com.codecool.queststore.services.LevelManager;
import com.codecool.queststore.services.ServiceLayerException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;
import java.util.List;
import java.util.Map;

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

        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");

        if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
            exchange.sendResponseHeaders(204, -1);
        }

        if (requestMethod.equals("GET")) {
            try {
                List<Level> levels = uriHasIdentifier ? levelManager.get(identifier) : levelManager.getAll();
                response = levelMapper.mapToJson(levels);

                setResponseHeader(exchange, MimeType.JSON);
                exchange.sendResponseHeaders(200, response.length());
            } catch (ServiceLayerException e) {
                response = e.getMessage();

                setResponseHeader(exchange, MimeType.TEXT);
                exchange.sendResponseHeaders(500, response.length());
            }
        } else if (requestMethod.equals("POST")) {
            try {
                InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String formData = br.readLine();

                Map<String, String> attributesAndValues = RequestParser.parseFormData(formData);

                System.out.println(attributesAndValues);

                levelManager.create(attributesAndValues.get("name"),
                        Integer.parseInt(attributesAndValues.get("threshold")));

                exchange.sendResponseHeaders(201, response.length());
            } catch (ServiceLayerException e) {
                response = e.getMessage();

                setResponseHeader(exchange, MimeType.TEXT);
                exchange.sendResponseHeaders(500, response.length());
            }
        } else if (requestMethod.equals("PUT")) {
            try {
                if (uriHasIdentifier) {
                    InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
                    BufferedReader br = new BufferedReader(isr);
                    String formData = br.readLine();

                    Map<String, String> attributesAndValues = RequestParser.parseFormData(formData);

                    System.out.println(attributesAndValues);

                    int id = Integer.parseInt(attributesAndValues.get("id"));
                    String name = attributesAndValues.get("name");
                    int threshold = Integer.parseInt(attributesAndValues.get("threshold"));

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

    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
