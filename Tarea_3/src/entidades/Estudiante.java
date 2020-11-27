package entidades;

import java.util.Objects;

public class Estudiante extends Persona {

    private String carrera;
    private int creditos;


    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Estudiante() {
    }

    public Estudiante(String ID, String nombre, String apellido, String carrera, int creditos) {
        super(ID, nombre, apellido);
        this.carrera = carrera;
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                ", ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", carrera='" + carrera + '\'' +
                ", creditos=" + creditos +
                '}';
    }

    public Estudiante(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.ID = datos[0];
        this.nombre = datos[1];
        this.apellido = datos[2];
        this.carrera = datos[3];
        this.creditos = Integer.parseInt(datos[4]);
    }


    public String toCSVLine() {

        return super.toCSVLine() + "," + this.carrera + "," + this.creditos;
    }
/*
    public Object fromCSVLine(String Line) {
        //     "123       ,       Maria  ,              Gomez"
        return super.fromCSVLine(Line) + "," + this.carrera + "," + this.creditos;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estudiante that = (Estudiante) o;
        return creditos == that.creditos &&
                Objects.equals(carrera, that.carrera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carrera, creditos);
    }
}
