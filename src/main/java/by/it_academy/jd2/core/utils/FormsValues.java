package by.it_academy.jd2.core.utils;

import by.it_academy.jd2.core.Persona;
import by.it_academy.jd2.web.servlets.PersonaServlet;

public enum FormsValues {
    FIRST_NAME ("Dima"),
    LAST_NAME("Zma"),
    AGE("39");

    private String title;

    FormsValues(String title) {
        this.title = title;
    }
}

