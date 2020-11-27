package entidades;

import java.time.LocalDate;

public class Texto extends Material{

    private String Titulo;
    private String Autor;
    private LocalDate Fecha_publicacion;
    private int Paginas;
    private String idioma;

    public Texto(String currentLine) {
        String[] datos = currentLine.split(",");
        this.signatura = datos[0];
        this.FechaCompra = LocalDate.parse(datos[1]);
        this.Restringido = Boolean.getBoolean(datos[2]);
        this.Tema = datos[3];
        this.Titulo = datos[4];
        this.Autor = datos[5];
        this.Fecha_publicacion = LocalDate.parse(datos[6]);
        this.Paginas = Integer.parseInt(datos[7]);
        this.idioma = datos[8];
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public LocalDate getFecha_publicacion() {
        return Fecha_publicacion;
    }

    public void setFecha_publicacion(LocalDate fecha_publicacion) {
        Fecha_publicacion = fecha_publicacion;
    }

    public int getPaginas() {
        return Paginas;
    }

    public void setPaginas(int paginas) {
        Paginas = paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Texto() {
    }

    public Texto(String signatura, LocalDate fechaCompra, boolean restringido, String tema, String titulo, String autor, LocalDate fecha_publicacion, int paginas, String idioma) {
        super(signatura, fechaCompra, restringido, tema);
        Titulo = titulo;
        Autor = autor;
        Fecha_publicacion = fecha_publicacion;
        Paginas = paginas;
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Texto = " +
                ", signatura='" + signatura + '\'' +
                ", FechaCompra=" + FechaCompra +
                ", Restringido=" + Restringido +
                ", Tema='" + Tema + '\'' +
                ", titulo='" + Titulo + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Fecha_publicacion=" + Fecha_publicacion +
                ", Paginas=" + Paginas +
                ", idioma='" + idioma + '\'' +
                '}';
    }

    @Override
    public String toCSVLine() {
        return this.signatura + "," + this.FechaCompra
                + "," + this.Restringido + "," + this.Tema + "," + this.Titulo + "," +
                this.Autor + "," + this.Fecha_publicacion + "," + this.Paginas + "," + this.idioma;
    }

}
