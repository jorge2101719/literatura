package com.literatura.desafio_literatura.model;

public enum Idiomas {
    desconocido("nd"),
    espanol("es"),
    ingles("en"),
    frances("fr"),
    italiano("it"),
    ignorado("nd");

    private String idiomasLibro;

    Idiomas (String idiomasLibro) {
        this.idiomasLibro = idiomasLibro;
    }

    public static Idiomas fromString(String text) {
        for(Idiomas idiomas : Idiomas.values()) {
            if(idiomas.idiomasLibro.equalsIgnoreCase(text)) {
                return idiomas;
            }
        }
        throw new IllegalArgumentException("\nNingún idioma encontrado: " + text);
    }
}
