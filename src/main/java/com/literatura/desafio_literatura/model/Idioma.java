package com.literatura.desafio_literatura.model;

public enum Idioma {
    ESPAÑOL("es"),
    INGLÉS("en"),
    FRANCÉS("fr"),
    DESCONOCIDO("nd");

    private String idiomaDelLibro;

    Idioma(String idioma) {
        this.idiomaDelLibro = idioma;
    }

    public static Idioma stringToEnum(String idioma) {
        for(Idioma item : Idioma.values()) {
            if(item.name().equalsIgnoreCase(idioma)) {
                return item;
            }
        }
        return DESCONOCIDO;
    }

    public static void mostrarIdiomas() {
        for(Idioma idiomas: Idioma.values()) {
            System.out.println(idiomas.name() + " - " + idiomas.getIdioma());
        }
    }

    public String getIdioma() {
        return idiomaDelLibro;
    }
}
