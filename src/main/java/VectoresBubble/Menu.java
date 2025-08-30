package VectoresBubble;

import misUtilidades.ColoresConsola;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {

    public Menu() {
        sc = new Scanner(System.in);
    }

    private final Scanner sc;

    public int mostrarMenuPrincipal() {
        System.out.println(ColoresConsola.TEXTO_AMARILLO);
        System.out.print(STR."""

⠀=======================================================================================================================================================================
⠀                  MENÚ PRINCIPAL
⠀=======================================================================================================================================================================
⠀        1. Crear vector
⠀        2. Ordenar vector de manera ascendente
⠀        3. Mostrar vector
⠀        4. Insertar elemento en vector
⠀        5. Eliminar elemento en vector
⠀        6. Eliminar números repetidos
⠀        7. Encontrar índice de número en vector
⠀        8. Unir dos vectores
         9. Salir del programa
⠀=======================================================================================================================================================================
⠀        Seleccione una opción →\t""");
        String entrada = sc.nextLine().trim();
        System.out.println("=======================================================================================================================================================================");
        while (!entrada.matches("[1-9]")) {
            System.out.print("Entrada inválida. Ingrese un dígito del 1 al 9: ");
            entrada = sc.nextLine().trim();
        }
        return Integer.parseInt(entrada);
    }

    public void cerrar() {
        sc.close();
    }

}
