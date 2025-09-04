package VectoresBubble;

import misUtilidades.ColoresConsola;
import misUtilidades.ValidadorEntrada;

import java.util.ArrayList;
import java.util.Arrays;
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
⠀        5. Eliminar elementos en vector
⠀        6. Encontrar índice de número en vector
⠀        7. Unir dos vectores
         8. Salir del programa
         
⠀        Seleccione una opción →\t""");
        String entrada = sc.nextLine().trim();
        while (!entrada.matches("[1-9]")) {
            System.out.print( ColoresConsola.TEXTO_ROJO + "Entrada inválida. Ingrese un dígito del 1 al 9: " + ColoresConsola.COLOR_RESET );
            entrada = sc.nextLine().trim();
        }
        return Integer.parseInt(entrada);
    }

    public int[] mostrarMenuAñadirVector() {
        System.out.println(ColoresConsola.TEXTO_AMARILLO);

                System.out.print(STR."""

⠀=======================================================================================================================================================================
⠀           \{ColoresConsola.TEXTO_ROJO}1.1 CREAR TAMAÑO VECTOR\{ColoresConsola.TEXTO_AMARILLO}
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
            System.out.print(ColoresConsola.TEXTO_CIAN + " ◊ Ingresa el tamaño del vector →\t" );
            size = ValidadorEntrada.leerEntero(sc);
            sc.nextLine();
        } else {
            size = rand.nextInt(1,50);
        }
            System.out.println(ColoresConsola.TEXTO_AMARILLO);
            System.out.print(STR."""

⠀=======================================================================================================================================================================
⠀           \{ColoresConsola.TEXTO_ROJO}1.2 RELLENAR VECTOR\{ColoresConsola.TEXTO_AMARILLO}
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
            return manejoDeVectores.crearVectorManualmente(size,sc);
        }else  {
            return manejoDeVectores.crearVectorAleatoriamente(size,rand);
        }
    }

    public ArrayList<int []> organizarVectoresBubble (ArrayList<int []> arrays) {
        try {
            if (arrays.isEmpty()) {
                throw new ListaVaciaException("La lista de arrays está vacía, no se puede ordenar.");
            }

            arrays.replaceAll(manejoDeVectores::bubbleSorting);

            // Se puede hacer también de la siguiente manera:

            /*
             for (int i = 0; i < arrays.size(); i++) {
                int[] ordenado = bubbleSorting(arrays.get(i));
                arrays.set(i,ordenado);
            }
             */

            System.out.println(ColoresConsola.TEXTO_VERDE + "\n SE HAN ORGANIZADO TODOS LOS VECTORES CON ÉXITO! ✅ " + ColoresConsola.TEXTO_AMARILLO);

        } catch (ListaVaciaException e) {
                System.out.println( ColoresConsola.TEXTO_ROJO + "\n⚠️ Se produjo un error: "+ ColoresConsola.TEXTO_AMARILLO + e.getMessage());
        }

        return arrays;
    };

    public void mostrarArrays(ArrayList<int []> arrays) {

        try {
            if (arrays.isEmpty()) {
                throw new ListaVaciaException("La lista de arrays está vacía, no se puede imprimir.");
            }
            int contador = 1;
            System.out.print(STR."""

                    =======================================================================================================================================================================
                    ⠀           \{ColoresConsola.TEXTO_ROJO}ARRAYS IMPRESOS\{ColoresConsola.TEXTO_AMARILLO}
                    =======================================================================================================================================================================

                    """);
            for (int[] arr : arrays) {
                System.out.print(ColoresConsola.TEXTO_AZUL + "Array #" + contador + ": " + ColoresConsola.TEXTO_AMARILLO);
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println("\n");
                contador++;
            }
        } catch (ListaVaciaException e) {
            System.out.println( ColoresConsola.TEXTO_ROJO + "\n⚠️ Se produjo un error: "+ ColoresConsola.TEXTO_AMARILLO + e.getMessage());
        }

    }

    public ArrayList<int []> añadirElementoArrays (ArrayList<int []> arrays) {
        try {
            if (arrays.isEmpty()) {
                throw new ListaVaciaException("La lista de arrays está vacía, no se puede añadir un elemento.");
            }

            mostrarArrays(arrays);
            System.out.print(" Selecciona el número del array que deseas añadir un elemento (EJEMPLO: 1 , 2) → ");

            int elemento = ValidadorEntrada.leerEntero(sc);
            sc.nextLine();

            if (elemento > (arrays.size())) {
                System.out.println(ColoresConsola.TEXTO_ROJO + " ⚠️ El elemento ingresado no existe en la lista " + ColoresConsola.TEXTO_AMARILLO);
                return arrays;
            }

            arrays.set(elemento - 1, manejoDeVectores.añadirElementoArray(arrays.get(elemento - 1), sc));

            System.out.println(ColoresConsola.TEXTO_VERDE + "\n SE HAN AÑADIDO TODOS LOS ELEMENTOS EN EL VECTOR CON ÉXITO! ✅ " + ColoresConsola.TEXTO_AMARILLO);
            sc.nextLine();

        } catch (ListaVaciaException e) {
            System.out.println( ColoresConsola.TEXTO_ROJO + "\n⚠️ Se produjo un error: "+ ColoresConsola.TEXTO_AMARILLO + e.getMessage());
        }

        return arrays;
    };

    public ArrayList<int []> eliminarElementoArrays (ArrayList<int []> arrays) {
        try {
            if (arrays.isEmpty()) {
                throw new ListaVaciaException("La lista de arrays está vacía, no se puede eliminar un elemento.");
            }

            mostrarArrays(arrays);
            System.out.print(" Selecciona el número del array que deseas eliminar un elemento (EJEMPLO: 1 , 2) → ");

            int elemento = ValidadorEntrada.leerEntero(sc);
            sc.nextLine();

            if (elemento > (arrays.size())) {
                System.out.println(ColoresConsola.TEXTO_ROJO + " ⚠️ El elemento ingresado no existe en la lista " + ColoresConsola.TEXTO_AMARILLO);
                return arrays;
            }

            arrays.set(elemento - 1, manejoDeVectores.eliminarElementoArray(arrays.get(elemento - 1), sc));

            System.out.println(ColoresConsola.TEXTO_VERDE + "\n SE HAN ELIMINADO TODOS LOS ELEMENTOS EN EL VECTOR CON ÉXITO! ✅ " + ColoresConsola.TEXTO_AMARILLO);
            sc.nextLine();

        } catch (ListaVaciaException e) {
            System.out.println( ColoresConsola.TEXTO_ROJO + "\n⚠️ Se produjo un error: "+ ColoresConsola.TEXTO_AMARILLO + e.getMessage());
        }

        return arrays;
    };

    public void encontrarIndiceNumeros (ArrayList<int []> arrays) {
        try {
            if (arrays.isEmpty()) {
                throw new ListaVaciaException("La lista de arrays está vacía, no se puede buscar el índice de algún elemento.");
            }

            mostrarArrays(arrays);
            System.out.print(" Selecciona el número del array que deseas buscar el índice de un elemento (EJEMPLO: 1 , 2) → ");

            int elemento = ValidadorEntrada.leerEntero(sc);
            sc.nextLine();

            if (elemento > (arrays.size())) {
                System.out.println(ColoresConsola.TEXTO_ROJO + " ⚠️ El elemento ingresado no existe en la lista " + ColoresConsola.TEXTO_AMARILLO);
                return;
            }

            System.out.println(" Ingresa el número del cual deseas conocer el índice en el vector seleccionado → ");
            int value = ValidadorEntrada.leerEntero(sc);
            sc.nextLine();

            int[] indices = manejoDeVectores.binarySearch(arrays.get(elemento - 1), value);

            System.out.println(ColoresConsola.TEXTO_VERDE + "\n Indices en los que se encuentra el elemento ingresado → " );
                    Arrays.stream(indices).forEach(n -> System.out.printf("%4d", n));
            System.out.println(ColoresConsola.TEXTO_AMARILLO);
            sc.nextLine();

        } catch (ListaVaciaException e) {
            System.out.println( ColoresConsola.TEXTO_ROJO + "\n⚠️ Se produjo un error: "+ ColoresConsola.TEXTO_AMARILLO + e.getMessage());
        } catch (manejoDeVectores.ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
    };



    public static class ListaVaciaException extends RuntimeException {
        public ListaVaciaException(String mensaje) {
            super(mensaje);
        }
    }

    public void cerrar() {
        sc.close();
    }

}
