/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.gestor;

import cr.ac.cenfotec.tarea3.bl.entidades.*;
import cr.ac.cenfotec.tarea3.dao.ClienteDAO;
import cr.ac.cenfotec.tarea3.dao.CuentaAhorroDAO;
import cr.ac.cenfotec.tarea3.dao.CuentaAhorroProgramadoDAO;
import cr.ac.cenfotec.tarea3.dao.CuentaCorrienteDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Gestor {

    private ClienteDAO clienteDAO = new ClienteDAO();
    private CuentaCorrienteDAO cuentaCorrienteDAO = new CuentaCorrienteDAO();
    private CuentaAhorroDAO cuentaAhorroDAO = new CuentaAhorroDAO();
    private CuentaAhorroProgramadoDAO cuentaAhorroProgramadoDAO = new CuentaAhorroProgramadoDAO();
    
    //private ArrayList<Cliente> listaCliente = new ArrayList<>();

    /* public void crearCliente(String nombre, int identificacion, String direccion) {
        Cliente clientes = new Cliente(nombre,identificacion,direccion);
        
    } */

    public boolean crearCliente(String nombre, int identificacion, String direccion){
        Cliente nuevoCliente = new Cliente(nombre, identificacion, direccion);
        try{
            return this.clienteDAO.save(nuevoCliente);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Cliente> listClientes() {
        try{
            return this.clienteDAO.findAll();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Cliente>();
    }

    public List<Cuenta> encontrarCuentasPorID (int id) {
        List<Cuenta> cuentasDeCliente = new ArrayList<>();
        for(Cuenta cuenta: this.cuentaCorrienteDAO.findAll()) {
            if(cuenta.getID_cliente() == id) {
                cuentasDeCliente.add(cuenta);
            }
        }
        for(Cuenta cuenta: this.cuentaAhorroDAO.findAll()) {
            if(cuenta.getID_cliente() == id) {
                cuentasDeCliente.add(cuenta);
            }
        }
        for(Cuenta cuenta: this.cuentaAhorroProgramadoDAO.findAll()) {
            if(cuenta.getID_cliente() == id) {
                cuentasDeCliente.add(cuenta);
            }
        }

        return cuentasDeCliente;
    }

    public List<Cuenta> encontrarCuentaCorrientePorID (int id) {
        ArrayList<Cuenta> cuentasDeCliente = new ArrayList<>();
        for(Cuenta cuenta: this.cuentaCorrienteDAO.findAll()) {
            if(cuenta.getID_cliente() == id) {
                cuentasDeCliente.add(cuenta);
            }
        }

        return cuentasDeCliente;
    }

    public void crearCuenta(int id, int numero, double saldo, int tipo) {
        if(tipo == 1) {
            Cuenta nuevaCuenta = new CuentaCorriente(id, numero, saldo);
            cuentaCorrienteDAO.save(nuevaCuenta);
        }
        if (tipo ==2) {
            Cuenta nuevaCuenta = new CuentaAhorro(id, numero, saldo);
            cuentaAhorroDAO.save(nuevaCuenta);
        }
        // Cuenta de ahorro Programado va aparte porque necesita un parametro extra: La cuenta asociada
    }

    public void crearCuenta(int id, int numero, double saldo, Cuenta cuentaAsociada, LocalDate fecha_creacion) {
        Cuenta nuevaCuenta = new CuentaAhorroProgramado(id, numero, saldo, cuentaAsociada, fecha_creacion);
        cuentaAhorroProgramadoDAO.save(nuevaCuenta);
    }

    public void realizarDeposito(Cuenta cuentaDeposito, double monto) {
        if(cuentaDeposito instanceof CuentaCorriente) {
            CuentaCorriente nuevaCuenta = new CuentaCorriente(cuentaDeposito.getID_cliente(), cuentaDeposito.getNumeroCuenta(), cuentaDeposito.getSaldo() + monto);
            cuentaCorrienteDAO.delete(cuentaDeposito.getNumeroCuenta(), nuevaCuenta);
        }
        if(cuentaDeposito instanceof CuentaAhorro) {
            CuentaAhorro nuevaCuenta = new CuentaAhorro(cuentaDeposito.getID_cliente(), cuentaDeposito.getNumeroCuenta(), cuentaDeposito.getSaldo() + monto);
            cuentaAhorroDAO.delete(cuentaDeposito.getNumeroCuenta(), nuevaCuenta);
        }
        if(cuentaDeposito instanceof  CuentaAhorroProgramado) {
            CuentaAhorroProgramado nuevaCuenta = new CuentaAhorroProgramado(cuentaDeposito.getID_cliente(), cuentaDeposito.getNumeroCuenta(), cuentaDeposito.getSaldo() + monto,
                    ((CuentaAhorroProgramado) cuentaDeposito).getCuentaAsociada(), ((CuentaAhorroProgramado) cuentaDeposito).getFecha_creacion());
            cuentaAhorroProgramadoDAO.delete(cuentaDeposito.getNumeroCuenta(), nuevaCuenta);
        }
    }

    public Cuenta getCuentaByID(int id) {
        Cuenta cuentaEncontrada = null;
        for(Cuenta cuenta: this.cuentaCorrienteDAO.findAll()) {
            if(cuenta.getNumeroCuenta() == id) {
                cuentaEncontrada = cuenta;
            }
        }
        for(Cuenta cuenta: this.cuentaAhorroDAO.findAll()) {
            if(cuenta.getNumeroCuenta() == id) {
                cuentaEncontrada = cuenta;
            }
        }
        for(Cuenta cuenta: this.cuentaAhorroProgramadoDAO.findAll()) {
            if(cuenta.getNumeroCuenta() == id) {
                cuentaEncontrada = cuenta;
            }
        }

        return cuentaEncontrada;
    }

    public void realizarRetiro(Cuenta cuentaRetiro, double monto) {
        if(cuentaRetiro instanceof CuentaCorriente) {
            CuentaCorriente nuevaCuenta = new CuentaCorriente(cuentaRetiro.getID_cliente(), cuentaRetiro.getNumeroCuenta(), cuentaRetiro.getSaldo() - monto);
            cuentaCorrienteDAO.delete(cuentaRetiro.getNumeroCuenta(), nuevaCuenta);
        }
        if(cuentaRetiro instanceof CuentaAhorro) {
            CuentaAhorro nuevaCuenta = new CuentaAhorro(cuentaRetiro.getID_cliente(), cuentaRetiro.getNumeroCuenta(), cuentaRetiro.getSaldo() - monto);
            cuentaAhorroDAO.delete(cuentaRetiro.getNumeroCuenta(), nuevaCuenta);
        }
        if(cuentaRetiro instanceof  CuentaAhorroProgramado) {
            CuentaAhorroProgramado nuevaCuenta = new CuentaAhorroProgramado(cuentaRetiro.getID_cliente(), cuentaRetiro.getNumeroCuenta(), cuentaRetiro.getSaldo() - monto,
                    ((CuentaAhorroProgramado) cuentaRetiro).getCuentaAsociada(), ((CuentaAhorroProgramado) cuentaRetiro).getFecha_creacion());
            cuentaAhorroProgramadoDAO.delete(cuentaRetiro.getNumeroCuenta(), nuevaCuenta);
        }
    }
}
