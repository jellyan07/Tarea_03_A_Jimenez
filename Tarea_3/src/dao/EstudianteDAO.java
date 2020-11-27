package dao;

import entidades.Estudiante;
import entidades.Material;
import entidades.Persona;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO extends PersonaDAO {
    @Override
    public boolean save(Persona newPersona) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(newPersona.toCSVLine());
        try {
            Files.write(Paths.get("c:\\dev\\listOfEstudiantes.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Persona> findAll() {
        ArrayList<Persona> result = new ArrayList<>();
        BufferedReader reader;
        try {
            File file = new File("c:\\dev\\listOfEstudiantes.csv");

            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    result.add(new Estudiante(currentLine));
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
}
