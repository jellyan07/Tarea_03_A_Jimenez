package dao;

import entidades.Audio;
import entidades.Material;
import entidades.Otro;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class OtroDAO extends MaterialDAO {
    @Override
    public boolean save(Material newMaterial) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(newMaterial.toCSVLine());
        try {
            Files.write(Paths.get("c:\\dev\\listOfOtros.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Material> findAll() {
        ArrayList<Material> result = new ArrayList<>();
        BufferedReader reader;
        try {
            File file = new File("c:\\dev\\listOfOtros.csv");

            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    result.add(new Otro(currentLine));
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
