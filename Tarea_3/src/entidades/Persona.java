package entidades;

import interfaces.SerializacionCSV;

import java.util.Objects;

public abstract class Persona implements SerializacionCSV {

    protected String ID;
    protected String nombre;
    protected String apellido;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Persona() {
    }

    public Persona(String ID, String nombre, String apellido) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public Persona(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.ID = datos[0];
        this.nombre = datos[1];
        this.apellido = datos[2];
    }


    public String toCSVLine() {
        return this.ID + "," + this.nombre
                + "," + this.apellido;
    }
/*
    public Object fromCSVLine(String Line) {
        //     "123       ,       Maria  ,              Gomez"
        return this.ID + "," + this.nombre + "," + this.apellido;
    } */
}
