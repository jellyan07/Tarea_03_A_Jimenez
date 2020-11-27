package cr.ac.cenfotec.tarea3.dao;

import cr.ac.cenfotec.tarea3.bl.entidades.Cuenta;
import cr.ac.cenfotec.tarea3.bl.entidades.CuentaAhorro;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CuentaAhorroDAO extends CuentaDAO{

    @Override
    public boolean save(Cuenta nuevaCuenta) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(nuevaCuenta.toCSVLine());
        try {
            Files.write(Paths.get("c:\\dev\\listOfCuentasAhorro.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Cuenta> findAll() {
        ArrayList<Cuenta> result = new ArrayList<>();
        BufferedReader reader;

        try {

            File file = new File("c:\\dev\\listOfCuentasAhorro.csv");

            if(file.exists()) {
                reader = new BufferedReader(new FileReader(file));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    result.add(new CuentaAhorro(currentLine));
                    currentLine = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int numeroCuenta, Cuenta nuevaCuenta) {
        BufferedReader reader;
        ArrayList<String> listaCuentas = new ArrayList<>(1000);
        try {
            int indicePrestamo = -1;
            int cont = 0;

            reader = new BufferedReader(new FileReader("c:\\dev\\listOfCuentasAhorro.csv"));
            String currentLine = reader.readLine();
            while(currentLine != null) {
                String [] datos = currentLine.split(",");
                listaCuentas.add(currentLine);

                if(datos[1].equals(String.valueOf(numeroCuenta))) {
                    indicePrestamo = cont;
                }
                currentLine = reader.readLine();
                cont++;
            }

            if(indicePrestamo != -1) {
                listaCuentas.set(indicePrestamo,nuevaCuenta.toCSVLine());
            }
            Files.write(Paths.get("c:\\dev\\listOfCuentasAhorro.csv"),listaCuentas, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
