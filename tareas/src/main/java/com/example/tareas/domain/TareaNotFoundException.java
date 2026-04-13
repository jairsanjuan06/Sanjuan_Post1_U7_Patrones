package com.example.tareas.domain;

public class TareaNotFoundException extends RuntimeException {

    public TareaNotFoundException(String mensaje) {
        super(mensaje);
    }
}
