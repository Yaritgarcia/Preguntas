package com.example.geoquiz;

public class Pregunta {

    private int textoId;
    private boolean respuesta;

    public Pregunta(int textoId, boolean respuesta) {
        this.textoId = textoId;
        this.respuesta = respuesta;
    }

    public int getTextoId() {
        return textoId;
    }

    public void setTextoId(int textoId) {
        this.textoId = textoId;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
}
