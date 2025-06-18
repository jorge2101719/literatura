package com.literatura.desafio_literatura.model;

public enum Idiomas {
    desconocido("nd"),
    español("es"),
    inglés("en"),
    francés("fr"),
    italiano("it");

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
