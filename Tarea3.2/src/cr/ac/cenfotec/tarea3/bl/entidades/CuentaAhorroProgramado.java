/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

import java.time.LocalDate;

public class CuentaAhorroProgramado extends Cuenta {

    private Cuenta cuentaAsociada;
    private LocalDate fecha_creacion;

    public Cuenta getCuentaAsociada() {
        return cuentaAsociada;
    }

    public void setCuentaAsociada(Cuenta cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public CuentaAhorroProgramado() {
    }

    public CuentaAhorroProgramado(int id, int numeroCuenta, double saldo, Cuenta cuentaAsociada, LocalDate fecha_creacion) {
        super(id, numeroCuenta, saldo);
        this.cuentaAsociada = cuentaAsociada;
        this.fecha_creacion = fecha_creacion;
    }

    public CuentaAhorroProgramado(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.ID_cliente = Integer.parseInt(datos[0]);
        this.numeroCuenta = Integer.parseInt(datos[1]);
        this.saldo = Double.parseDouble(datos[2]);
        this.fecha_creacion = LocalDate.parse(datos[3]);
        this.cuentaAsociada = new CuentaCorriente(Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Double.parseDouble(datos[6]));
    }

    @Override
    public String toString() {
        return "CuentaAhorroProgramado{" + super.toString() + '}';
    }

    @Override
    public String toCSVLine() {
        return this.ID_cliente + "," + this.numeroCuenta + "," + this.saldo + "," + this.fecha_creacion + "," + this.cuentaAsociada.toCSVLine();
    }
}
