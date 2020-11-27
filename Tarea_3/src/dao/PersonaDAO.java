package dao;

import entidades.Material;
import entidades.Persona;

import java.util.List;

public abstract class PersonaDAO {
    public abstract boolean save(Persona newPersona);
    public abstract List<Persona> findAll();
}
