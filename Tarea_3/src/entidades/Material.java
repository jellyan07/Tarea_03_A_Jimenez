package entidades;

import interfaces.SerializacionCSV;

import java.time.LocalDate;

public class Material implements SerializacionCSV {

    protected String signatura;
    protected LocalDate FechaCompra;
    protected boolean Restringido;
    protected String Tema;

    public Material(String currentLine) {
    }

    public String getSignatura() {
        return signatura;
    }

    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    public LocalDate getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        FechaCompra = fechaCompra;
    }

    public boolean isRestringido() {
        return Restringido;
    }

    public void setRestringido(boolean restringido) {
        Restringido = restringido;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String tema) {
        Tema = tema;
    }

    public Material() {
    }

    public Material(String signatura, LocalDate fechaCompra, boolean restringido, String tema) {
        this.signatura = signatura;
        FechaCompra = fechaCompra;
        Restringido = restringido;
        Tema = tema;
    }

    @Override
    public String toString() {
        return "signatura='" + signatura + '\'' +
                ", FechaCompra=" + FechaCompra +
                ", Restringido=" + Restringido +
                ", Tema='" + Tema + '\'' +
                '}';
    }

    @Override
    public String toCSVLine() {
        return this.signatura + "," + this.FechaCompra
                + "," + this.Restringido + "," + this.Tema;
    }


    public Object fromCSVLine(String Line) {
        //               "123    ,       2020-11-11       ,          false         ,    ciencias"
        return this.signatura + "," + this.FechaCompra + "," + this.Restringido + "," + this.Tema;
    }

}
