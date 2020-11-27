package entidades;

import tipos.Formato;

import java.time.LocalDate;

public class Audio extends Material{

    private Formato Formato;
    private String Duracion;
    private String Idioma;

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        Duracion = duracion;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String idioma) {
        Idioma = idioma;
    }

    public tipos.Formato getFormato() {
        return Formato;
    }

    public void setFormato(Formato formato) {
        Formato = formato;
    }

    public Audio() {
    }

    public Audio(String signatura, LocalDate fechaCompra, boolean restringido, String tema, Formato formato, String duracion, String idioma) {
        super(signatura, fechaCompra, restringido, tema);
        Formato = formato;
        Duracion = duracion;
        Idioma = idioma;
    }

    public Audio(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.signatura = datos[0];
        this.FechaCompra = LocalDate.parse(datos[1]);
        this.Restringido = Boolean.getBoolean(datos[2]);
        this.Tema = datos[3];
        this.Formato = Formato.valueOf(datos[4]);
        this.Duracion = datos[5];
        this.Idioma = datos[6];
    }

    @Override
    public String toString() {
        return "Audio{" +
                ", signatura='" + signatura + '\'' +
                ", FechaCompra=" + FechaCompra +
                ", Restringido=" + Restringido +
                ", Tema='" + Tema + '\'' +
                ", Formato=" + Formato +
                ", Duracion='" + Duracion + '\'' +
                ", Idioma='" + Idioma + '\'' +
                '}';
    }

    @Override
    public String toCSVLine() {
        return this.signatura + "," + this.FechaCompra
                + "," + this.Restringido + "," + this.Tema + "," + this.Formato + "," +
                this.Duracion + "," + this.Idioma;
    }

}
