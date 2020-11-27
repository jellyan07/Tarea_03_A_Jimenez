/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

public class CuentaAhorro extends Cuenta {

    final double interes = 0.5;

    public double getInteres() {
        return interes;
    }

    public CuentaAhorro() {
    }

    public CuentaAhorro(int id, int numeroCuenta, double saldo) {
        super(id, numeroCuenta, saldo);
    }

    public CuentaAhorro(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.ID_cliente = Integer.parseInt(datos[0]);
        this.numeroCuenta = Integer.parseInt(datos[1]);
        this.saldo = Integer.parseInt(datos[2]);
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" + super.toString() + '}';
    }

    @Override
    public String toCSVLine() {
        return this.ID_cliente + "," + this.numeroCuenta + "," + this.saldo + "," + interes;
    }
}
