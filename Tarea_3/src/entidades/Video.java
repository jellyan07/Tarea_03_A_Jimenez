package entidades;

import tipos.Formato_video;

import java.time.LocalDate;

public class Video extends Material {
    private Formato_video Formato;
    private String Duracion;
    private String Idioma;
    private String Director;

    public Video(String currentLine) {
        String[] datos = currentLine.split(",");
        this.signatura = datos[0];
        this.FechaCompra = LocalDate.parse(datos[1]);
        this.Restringido = Boolean.getBoolean(datos[2]);
        this.Tema = datos[3];
        this.Formato = Formato_video.valueOf(datos[4]);
        this.Duracion = datos[5];
        this.Idioma = datos[6];
        this.Director = datos[7];
    }

    public Formato_video getFormato() {
        return Formato;
    }

    public void setFormato(Formato_video formato) {
        Formato = formato;
    }

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

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public Video() {

    }

    public Video(String signatura, LocalDate fechaCompra, boolean restringido, String tema, Formato_video formato, String duracion, String idioma, String director) {
        super(signatura, fechaCompra, restringido, tema);
        Formato = formato;
        Duracion = duracion;
        Idioma = idioma;
        Director = director;
    }

    @Override
    public String toString() {
        return "Video{" +
                ", signatura='" + signatura + '\'' +
                ", FechaCompra=" + FechaCompra +
                ", Restringido=" + Restringido +
                ", Tema='" + Tema + '\'' +
                ", Formato=" + Formato +
                ", Duracion='" + Duracion + '\'' +
                ", Idioma='" + Idioma + '\'' +
                ", Director='" + Director + '\'' +
                '}';
    }

    @Override
    public String toCSVLine() {
        return this.signatura + "," + this.FechaCompra
                + "," + this.Restringido + "," + this.Tema + "," + this.Formato + "," +
                this.Duracion + "," + this.Idioma + "," + this.Director;
    }

}
