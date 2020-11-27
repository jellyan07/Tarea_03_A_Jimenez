package entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Profesor extends Persona{

    private String tipo_contrato;
    private LocalDate fecha_contratacion;

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public LocalDate getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(LocalDate fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public Profesor() {
    }

    public Profesor(String ID, String nombre, String apellido, LocalDate fecha_contratacion, String tipo_contrato) {
        super(ID, nombre, apellido);
        this.fecha_contratacion = fecha_contratacion;
        this.tipo_contrato = tipo_contrato;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                ", ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_contratacion=" + fecha_contratacion +
                "tipo_contrato='" + tipo_contrato + '\'' +
                '}';
    }

    public Profesor(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.ID = datos[0];
        this.nombre = datos[1];
        this.apellido = datos[2];
        this.fecha_contratacion = LocalDate.parse(datos[3]);
        this.tipo_contrato = datos[4];
    }


    public String toCSVLine() {

        return super.toCSVLine() + "," + this.fecha_contratacion  + "," + this.tipo_contrato;
    }
/*
    public Object fromCSVLine(String Line) {
        //     "123       ,       Maria  ,              Gomez"
        return super.fromCSVLine(Line) + "," + this.fecha_contratacion + "," + this.tipo_contrato;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(tipo_contrato, profesor.tipo_contrato) &&
                Objects.equals(fecha_contratacion, profesor.fecha_contratacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo_contrato, fecha_contratacion);
    }
}
