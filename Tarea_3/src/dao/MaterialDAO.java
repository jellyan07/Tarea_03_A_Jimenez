package dao;

import entidades.Material;

import java.util.List;

public abstract class MaterialDAO {

    public abstract boolean save(Material newMaterial);
    public abstract List<Material> findAll();

}
