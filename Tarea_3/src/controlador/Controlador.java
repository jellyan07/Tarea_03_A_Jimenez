package controlador;

import UI.UI;
import entidades.*;
import gestor.GestorMateriales;
import tipos.Formato;
import tipos.Formato_video;
import tipos.TipoMaterial;
import tipos.TipoPersona;

import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controlador {

    private UI ui = new UI();
    private GestorMateriales gestor = new GestorMateriales();

    public void ejecutarPrograma() {
        int opcion = 0;
        do{
            ui.mostrarMenu();
            opcion = ui.leerOpcion();
            procesarOpcion(opcion);
        } while(opcion != 5);
    }

    private void procesarOpcion (int opcion) {
        switch (opcion) {

            case 1:
                registrarUsuario();
                break; 
            case 2:
                registrarMaterial();
                break;
            case 3:
                ListarMaterial();
                break;
            case 4:
                ListarUsuarios();
                break;
            case 5:
                ui.imprimir("¡Adiós!");
                break; 
            default:
                ui.imprimir("Opción inválida");
        }
    }

    private void ListarUsuarios() {
        ui.mostrarMenuUsuario();
        int opcion = ui.leerOpcion();
        List<Persona> personas = new ArrayList<>();
        switch (opcion) {
            case 1:
                personas = gestor.listAll(TipoPersona.ESTUDIANTE);
                break;
            case 2:
                personas = gestor.listAll(TipoPersona.PROFESOR);
                break;
            default:
                ui.imprimir("Esta opción es inválida");
                break;
        }

        int contMaterial = 0;
        for (Persona persona : personas) {

                ui.imprimir(contMaterial++ + ". " + persona.toString());
        }
    }

    private void ListarMaterial() {
        ui.mostrarMenuMateral();
        int opcion = ui.leerOpcion();
        TipoMaterial tipo;
        List<Material> materiales = new ArrayList<>();
        switch (opcion) {
            case 1:
                materiales = gestor.listAll(tipo = TipoMaterial.TEXTO);
                break;
            case 2:
                materiales = gestor.listAll(tipo = TipoMaterial.AUDIO);
                break;
            case 3:
                materiales = gestor.listAll(tipo = TipoMaterial.VIDEO);
                break;
            case 4:
                materiales = gestor.listAll(tipo = TipoMaterial.OTRO);
                break;
            default:
                ui.imprimir("Esta opción es inválida");
                break;
        }

        int contMaterial = 0;
        for (Material material : materiales) {

            ui.imprimir(contMaterial++ + ". " + material.toString());
        }
    }

    private void registrarMaterial() {
        ui.mostrarMenuMateral();
        int opcion = ui.leerOpcion();
        switch (opcion) {
            case 1:
                registrarTexto();
                break;
            case 2:
                registrarAudio();
                break;
            case 3:
                registrarVideo();
                break;
            case 4:
                registrarOtros();
                break;
            default:
                ui.imprimir("Esta opción es inválida");
                break;
        }
    }

    public LocalDate fecha() {
        ui.imprimir("Escriba la fecha dd/MM/yyyy");
        String fecha = ui.leerTexto();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaDato = LocalDate.parse(fecha, fmt);
        return fechaDato;
    }

    private void registrarOtros() {
        ui.imprimir("Signatura:");
        String ID = ui.leerTexto();
        ui.imprimir("Fecha de compra:");
        LocalDate fechaCompra = fecha();
        TipoMaterial tipoMaterial = TipoMaterial.TEXTO;
        Optional<Material> material = gestor.encontrarMaterialPorID(ID, tipoMaterial);
        boolean Restringido = false;
        String tema = "";
        if (material.isPresent()) {
            ui.imprimir("Audio ya existe");
        } else {
            ui.imprimir("Restringido:");
            ui.imprimir("1. Sí");
            ui.imprimir("2. No");
            int restringidoTxt = ui.leerOpcion();

            switch (restringidoTxt) {
                case 1:
                    Restringido = true;
                    break;
                case 2:
                    Restringido = false;
                    break;
                default:
                    ui.imprimir("Opción inválida");
                    break;
            }
            ui.imprimir("Tema:");
            tema = ui.leerTexto();

            ui.imprimir("Formato:");
            ui.imprimir("1. VHS");
            ui.imprimir("2. VCD");
            ui.imprimir("3. DVD");
            int formatoTxt = ui.leerOpcion();
            Formato_video Format = null;

            switch (restringidoTxt) {
                case 1:
                    Format = Formato_video.VHS;
                    break;
                case 2:
                    Format = Formato_video.VCD;
                    break;
                case 3:
                    Format = Formato_video.DVD;
                    break;
                default:
                    ui.imprimir("Opción inválida");
                    break;
            }
            ui.imprimir("Duración:");
            String descripcion = ui.leerTexto();

            Material newMaterial = new Otro(ID, fechaCompra, Restringido, tema, descripcion);
            gestor.guardar(newMaterial);

        }
    }

    private void registrarVideo() {
        ui.imprimir("Signatura:");
        String ID = ui.leerTexto();
        ui.imprimir("Fecha de compra:");
        LocalDate fechaCompra = fecha();
        TipoMaterial tipoMaterial = TipoMaterial.TEXTO;
        Optional<Material> material = gestor.encontrarMaterialPorID(ID, tipoMaterial);
        boolean Restringido = false;
        String tema = "";
        if (material.isPresent()) {
            ui.imprimir("Audio ya existe");
        } else {
            ui.imprimir("Restringido:");
            ui.imprimir("1. Sí");
            ui.imprimir("2. No");
            int restringidoTxt = ui.leerOpcion();

            switch (restringidoTxt) {
                case 1:
                    Restringido = true;
                    break;
                case 2:
                    Restringido = false;
                    break;
                default:
                    ui.imprimir("Opción inválida");
                    break;
            }
            ui.imprimir("Tema:");
            tema = ui.leerTexto();

            ui.imprimir("Formato:");
            ui.imprimir("1. VHS");
            ui.imprimir("2. VCD");
            ui.imprimir("3. DVD");
            int formatoTxt = ui.leerOpcion();
            Formato_video Format = null;

            switch (restringidoTxt) {
                case 1:
                    Format = Formato_video.VHS;
                    break;
                case 2:
                    Format = Formato_video.VCD;
                    break;
                case 3:
                    Format = Formato_video.DVD;
                    break;
                default:
                    ui.imprimir("Opción inválida");
                    break;
            }
            ui.imprimir("Duración:");
            String duracion = ui.leerTexto();
            ui.imprimir("Idioma:");
            String idioma = ui.leerTexto();
            ui.imprimir("Director:");
            String director = ui.leerTexto();

            Material newMaterial = new Video(ID, fechaCompra, Restringido, tema, Format, duracion, idioma, director);
            gestor.guardar(newMaterial);

        }


    }

    private void registrarTexto() {
        ui.imprimir("Signatura:");
        String ID = ui.leerTexto();
        ui.imprimir("Fecha de compra:");
        LocalDate fechaCompra = fecha();
        TipoMaterial tipoMaterial = TipoMaterial.TEXTO;
        Optional<Material> material = gestor.encontrarMaterialPorID(ID, tipoMaterial);
        boolean Restringido = false;
        String tema = "";
        if (material.isPresent()) {
            ui.imprimir("Audio ya existe");
        } else {
            ui.imprimir("Restringido:");
            ui.imprimir("1. Sí");
            ui.imprimir("2. No");
            int restringidoTxt = ui.leerOpcion();

            switch (restringidoTxt) {
                case 1:
                    Restringido = true;
                    break;
                case 2:
                    Restringido = false;
                    break;
                default:
                    ui.imprimir("Opción inválida");
                    break;
            }
            ui.imprimir("Tema:");
            tema = ui.leerTexto();
            ui.imprimir("Título:");
            String Titulo = ui.leerTexto();
            ui.imprimir("Autor:");
            String Autor = ui.leerTexto();
            ui.imprimir("Fecha de publicación:");
            LocalDate Fecha_publicacion = fecha();
            ui.imprimir("Páginas:");
            int Paginas = ui.leerOpcion();
            ui.imprimir("Idioma:");
            String idioma = ui.leerTexto();

            Material newMaterial = new Texto(ID, fechaCompra, Restringido, tema, Titulo, Autor, Fecha_publicacion, Paginas, idioma);
            gestor.guardar(newMaterial);
        }

    }

    private void registrarAudio() {
        ui.imprimir("Signatura:");
        String ID = ui.leerTexto();
        ui.imprimir("Fecha de compra:");
        LocalDate fechaCompra = fecha();
        TipoMaterial tipoMaterial = TipoMaterial.AUDIO;
        Optional<Material> material = gestor.encontrarMaterialPorID(ID, tipoMaterial);
        boolean Restringido = false;
        if(material.isPresent()) {
            ui.imprimir("Audio ya existe");
        } else {
            ui.imprimir("Restringido:");
            ui.imprimir("1. Sí");
            ui.imprimir("2. No");
            int restringidoTxt = ui.leerOpcion();

            switch (restringidoTxt) {
                case 1:
                    Restringido = true;
                break;
                case 2:
                    Restringido = false;
                    break;
                default:
                    ui.imprimir("Opción inválida");
                    break;
            }
            ui.imprimir("Tema:");
            String tema = ui.leerTexto();

            ui.imprimir("Formato:");
            ui.imprimir("1. Cassete");
            ui.imprimir("2. CD");
            ui.imprimir("3. DVD");
            int formatoTxt = ui.leerOpcion();
            Formato Format = null;

            switch (restringidoTxt) {
                case 1:
                    Format = tipos.Formato.CASETE;
                    break;
                case 2:
                    Format = tipos.Formato.CD;
                    break;
                case 3:
                    Format = tipos.Formato.DVD;
                    break;
                default:
                    ui.imprimir("Opción inválida");
                    break;
            }
            ui.imprimir("Duración:");
            String duracion = ui.leerTexto();
            ui.imprimir("Idioma:");
            String idioma = ui.leerTexto();

            Material newMaterial = new Audio(ID, fechaCompra, Restringido, tema, Format, duracion, idioma);
            gestor.guardar(newMaterial);
        }
    }

    private void registrarUsuario() {
        ui.mostrarMenuUsuario();
        int opcion = ui.leerOpcion();
        switch (opcion) {
            case 1:
                registrarEstudiante();
                break;
            case 2:
                registrarProfesor(); 
                break;
            case 3:
                break;
            default:
                ui.imprimir("Esta opción es inválida");
                break;
        }
    }

    private void registrarProfesor() {
        ui.imprimir("ID:");
        String ID = ui.leerTexto();
        TipoPersona tipoPersona = TipoPersona.PROFESOR;
        Optional<Persona> profesor = gestor.encontrarPersonaPorID(ID, tipoPersona);
        if(profesor.isPresent()) {
            ui.imprimir("Estudiante ya existe");
        } else {
            ui.imprimir("Nombre:");
            String nombre = ui.leerTexto();
            ui.imprimir("Apellido:");
            String apellido = ui.leerTexto();
            ui.imprimir("Fecha de Contratación:");
            LocalDate fecha_contratacion = fecha();
            ui.imprimir("Tipo de Contrato:");
            String tipo_contrato = ui.leerTexto();

            Persona newPersona = new Profesor(ID, nombre, apellido, fecha_contratacion, tipo_contrato);
            gestor.guardar(newPersona);
        }
    }

    private void registrarEstudiante() {
        ui.imprimir("ID:");
        String ID = ui.leerTexto();
        TipoPersona tipoPersona = TipoPersona.ESTUDIANTE;
        Optional<Persona> estudiante = gestor.encontrarPersonaPorID(ID, tipoPersona);
        if(estudiante.isPresent()) {
            ui.imprimir("Estudiante ya existe");
        } else {
            ui.imprimir("Nombre:");
            String nombre = ui.leerTexto();
            ui.imprimir("Apellido:");
            String apellido = ui.leerTexto();
            ui.imprimir("Carrera:");
            String carrera = ui.leerTexto();
            ui.imprimir("Créditos:");
            int creditos = ui.leerOpcion();

            Persona newPersona = new Estudiante(ID, nombre, apellido, carrera, creditos);
            gestor.guardar(newPersona);
        }

    }



}
