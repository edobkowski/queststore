package com.codecool.queststore.server.controllers;

import java.net.URI;

public class URIparser {
    public static boolean hasIdentifier(URI uri) {
        String[] splitted = splitURI(uri);

        return splitted.length > 1;
    }

    public static String parseIdentifier(URI uri) {
        return splitURI(uri)[1];
    }

    public static int parseIdentifierToInt(URI uri) {
        return Integer.parseInt(parseIdentifier(uri));
    }

    private static String[] splitURI(URI uri) {
        return uri.toString().substring(1).split("/");
    }
}
