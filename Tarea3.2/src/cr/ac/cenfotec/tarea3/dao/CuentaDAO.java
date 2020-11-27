package cr.ac.cenfotec.tarea3.dao;

import cr.ac.cenfotec.tarea3.bl.entidades.Cuenta;

import java.util.List;

public abstract class CuentaDAO {

    public abstract boolean save(Cuenta nuevaCuenta);
    public abstract List<Cuenta> findAll();
}
