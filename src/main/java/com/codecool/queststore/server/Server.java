package com.codecool.queststore.server;

import com.codecool.queststore.server.controllers.LevelController;
import com.codecool.queststore.server.controllers.RootController;
import com.codecool.queststore.server.controllers.MentorController;
import com.codecool.queststore.server.controllers.CodecoolClassController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

        httpServer.createContext("/", new RootController());
        httpServer.createContext("/mentors", new MentorController());
        httpServer.createContext("/classes", new CodecoolClassController());
        httpServer.createContext("/levels", new LevelController());

        httpServer.start();
    }
}
