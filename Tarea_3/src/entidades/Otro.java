package entidades;

import java.time.LocalDate;

public class Otro extends Material {
    private String Descripcion;

    public Otro(String currentLine) {
        String[] datos = currentLine.split(",");
        this.signatura = datos[0];
        this.FechaCompra = LocalDate.parse(datos[1]);
        this.Restringido = Boolean.getBoolean(datos[2]);
        this.Tema = datos[3];
        this.Descripcion = datos[4];
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Otro() {
    }

    public Otro(String signatura, LocalDate fechaCompra, boolean restringido, String tema, String descripcion) {
        super(signatura, fechaCompra, restringido, tema);
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Otro{" +
                ", signatura='" + signatura + '\'' +
                ", FechaCompra=" + FechaCompra +
                ", Restringido=" + Restringido +
                ", Tema='" + Tema + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }

    @Override
    public String toCSVLine() {
        return this.signatura + "," + this.FechaCompra
                + "," + this.Restringido + "," + this.Tema + "," + this.Descripcion;
    }

}
