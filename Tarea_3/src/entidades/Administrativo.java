package entidades;

import java.util.Objects;

public class Administrativo extends Persona {

    private char tipo_nombramiento;
    private int horas;

    public char getTipo_nombramiento() {
        return tipo_nombramiento;
    }

    public void setTipo_nombramiento(char tipo_nombramiento) {
        this.tipo_nombramiento = tipo_nombramiento;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Administrativo() {
    }

    public Administrativo(String ID, String nombre, String apellido, char tipo_nombramiento, int horas) {
        super(ID, nombre, apellido);
        this.tipo_nombramiento = tipo_nombramiento;
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "tipo_nombramiento=" + tipo_nombramiento +
                ", horas=" + horas +
                ", ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrativo that = (Administrativo) o;
        return tipo_nombramiento == that.tipo_nombramiento &&
                horas == that.horas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipo_nombramiento, horas);
    }
}
