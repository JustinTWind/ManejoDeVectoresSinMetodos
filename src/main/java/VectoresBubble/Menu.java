package VectoresBubble;

import misUtilidades.ColoresConsola;
import misUtilidades.ValidadorEntrada;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    public Menu() {
        sc = new Scanner(System.in);
        rand = new Random();
    }

    private final Scanner sc;
    private final Random rand;

    public int mostrarMenuPrincipal() {
        System.out.println(ColoresConsola.TEXTO_AMARILLO);
        System.out.print(STR."""

⠀=======================================================================================================================================================================
⠀           \{ColoresConsola.TEXTO_ROJO}MENÚ PRINCIPAL\{ColoresConsola.TEXTO_AMARILLO}
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
         
⠀        Seleccione una opción →\t""");
        String entrada = sc.nextLine().trim();
        while (!entrada.matches("[1-9]")) {
            System.out.print( ColoresConsola.TEXTO_ROJO + "Entrada inválida. Ingrese un dígito del 1 al 9: " + ColoresConsola.COLOR_RESET );
            entrada = sc.nextLine().trim();
        }
        return Integer.parseInt(entrada);
    }

    public void mostrarMenuSecundario(int opcion) {
        System.out.println(ColoresConsola.TEXTO_AMARILLO);
        switch (opcion){
            case 1:
                System.out.print(STR."""

⠀=======================================================================================================================================================================
⠀           \{ColoresConsola.TEXTO_ROJO}1.1 CREAR VECTOR\{ColoresConsola.TEXTO_AMARILLO}
⠀=======================================================================================================================================================================
⠀        1. Ingresar tamaño del vector
⠀        2. Generar tamaño del vector aleatoriamente

⠀        Seleccione una opción →\t""");

            String entrada = sc.nextLine().trim();
            while (!entrada.matches("[1-2]")) {
                System.out.print(ColoresConsola.TEXTO_ROJO + " ✖ Entrada inválida. Ingrese un dígito del 1 al 2: " + ColoresConsola.TEXTO_AMARILLO);
                entrada = sc.nextLine().trim();
            }

            int size;
            if (Integer.parseInt(entrada) == 1) {
                System.out.print(ColoresConsola.TEXTO_CIAN + " ◊ Ingresa el tamaño del vector → " );
                size = ValidadorEntrada.leerEntero(sc);
                sc.nextLine();
            } else {
                size = rand.nextInt(1,50);
            }
                System.out.println(ColoresConsola.TEXTO_AMARILLO);
                System.out.print(STR."""

⠀=======================================================================================================================================================================
⠀           \{ColoresConsola.TEXTO_ROJO}1.2 CREAR VECTOR\{ColoresConsola.TEXTO_AMARILLO}
⠀=======================================================================================================================================================================
⠀        1. Llenar vector Manualmente
⠀        2. Llenar vector aleatoriamente

⠀        Seleccione una opción →\t""");

                entrada = sc.nextLine().trim();
                while (!entrada.matches("[1-2]")) {
                    System.out.print(ColoresConsola.TEXTO_ROJO + " ✖ Entrada inválida. Ingrese un dígito del 1 al 2: " + ColoresConsola.TEXTO_AMARILLO);
                    entrada = sc.nextLine().trim();
                }

                if (Integer.parseInt(entrada) == 1) {
                    int [] vector = new int[size];
                    for (int index : vector) {
                        System.out.print("Ingrese el dígito #" + ColoresConsola.TEXTO_CIAN + index + ColoresConsola.TEXTO_AMARILLO +  " → " );
                        vector[index] = ValidadorEntrada.leerEntero(sc);
                    }
                }else  {
                    int [] vector = new int[size];
                    for (int index : vector) {
                        vector[index] = rand.nextInt(1,50);
                    }
                }
        }
    }

    public void cerrar() {
        sc.close();
    }

}
