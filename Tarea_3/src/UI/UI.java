package UI;

import java.io.PrintStream;
import java.util.Scanner;

public class UI {

    private static PrintStream output = new PrintStream(System.out);
    private static Scanner input = new Scanner(System.in);

    public static void mostrarMenu () {
        output.println("*******  Escoja una opción  ******");

        output.println("1. Registrar Usuario");
        output.println("2. Registrar Material");
        output.println("3. Listar Materiales");
        output.println("4. Listar Usuarios");
        output.println("5. Salir");
    }

    public static void mostrarMenuUsuario () {
        output.println("1. Estudiante");
        output.println("2. Profesor");
        output.println("3. Salir");
    }

    public  static void mostrarMenuMateral() {
        output.println("1. Texto");
        output.println("2. Audio");
        output.println("3. Video");
        output.println("4. Otro");
        output.println("5. Salir");
    }

    public void imprimir (String msj) {
        output.println(msj);
    }

    public String leerTexto () {
        String texto = input.next();
        return texto;
    }

    public int leerOpcion() {
        int opcion = Integer.parseInt(input.next());
        return opcion;
    }
}
