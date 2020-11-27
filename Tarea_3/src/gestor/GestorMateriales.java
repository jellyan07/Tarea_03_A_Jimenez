package gestor;

import dao.*;
import entidades.*;
import tipos.TipoMaterial;
import tipos.TipoPersona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorMateriales {

    private AudioDAO audioDao = new AudioDAO();
    private TextoDAO textoDAO = new TextoDAO();
    private VideoDAO videoDAO = new VideoDAO();
    private OtroDAO otroDAO = new OtroDAO();
    private EstudianteDAO estudianteDAO = new EstudianteDAO();
    private ProfesorDAO profesorDAO = new ProfesorDAO();


    public boolean guardar(Material nuevoMaterial){
        try{
            MaterialDAO objPersistente = determinarObjetoDAO(nuevoMaterial);
            return objPersistente.save(nuevoMaterial);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Material> listAll(TipoMaterial tipoMaterial) {
        try{
            MaterialDAO objPersistente = determinarObjetoDAO(tipoMaterial);
            return objPersistente.findAll();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Material>();
    }

    private MaterialDAO determinarObjetoDAO(Material nuevoMaterial) throws Exception {
        if (nuevoMaterial instanceof Audio) {
            return this.audioDao;
        }
        if (nuevoMaterial instanceof Video) {
            return this.videoDAO;
        }
        if (nuevoMaterial instanceof Texto) {
            return this.textoDAO;
        }
        if (nuevoMaterial instanceof Otro) {
            return this.otroDAO;
        }
        throw new Exception("Tipo de Material Desconocido");
    }

    private MaterialDAO determinarObjetoDAO(TipoMaterial tipo) throws Exception {
        if (TipoMaterial.AUDIO.equals(tipo)) {
            return this.audioDao;
        }
        if (TipoMaterial.VIDEO.equals(tipo)) {
            return this.videoDAO;
        }
        if (TipoMaterial.TEXTO.equals(tipo)) {
            return this.textoDAO;
        }
        if (TipoMaterial.OTRO.equals(tipo)) {
            return this.otroDAO;
        }
        throw new Exception("Tipo de Material Desconocido");
    }

    /* ----- Personas ----- */

    public boolean guardar(Persona nuevaPersona){
        try{
            PersonaDAO objPersistente = determinarPersonaDAO(nuevaPersona);
            return objPersistente.save(nuevaPersona);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Persona> listAll(TipoPersona tipo) {
        try{
            PersonaDAO objPersistente = determinarPersonaDAO(tipo);
            return objPersistente.findAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Persona>();
    }

    private PersonaDAO determinarPersonaDAO(Persona nuevaPersona) throws Exception {
        if (nuevaPersona instanceof Estudiante) {
            return this.estudianteDAO;
        }
        if (nuevaPersona instanceof Profesor) {
            return this.profesorDAO;
        }
        throw new Exception("Tipo de Persona Desconocido");
    }

    private PersonaDAO determinarPersonaDAO(TipoPersona tipo) throws Exception {
        if (TipoPersona.ESTUDIANTE.equals(tipo)) {
            return this.estudianteDAO;
        }
        if (TipoPersona.PROFESOR.equals(tipo)) {
            return this.profesorDAO;
        }
        throw new Exception("Tipo de Material Desconocido");
    }

    public Optional<Persona> encontrarPersonaPorID (String id, TipoPersona tipo) {
            for(Persona persona: listAll(tipo)) {
                if(persona.getID().equals(id)) {
                    return Optional.of(persona);
                }
            }

        return Optional.empty();
    }

    public Optional<Material> encontrarMaterialPorID (String id, TipoMaterial tipo) {
        for(Material material: listAll(tipo)) {
            if(material.getSignatura().equals(id)) {
                return Optional.of(material);
            }
        }

        return Optional.empty();
    }



}
