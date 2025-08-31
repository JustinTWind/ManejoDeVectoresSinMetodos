package VectoresBubble;

import misUtilidades.*;
import java.util.*;

public class manejoDeVectores {

    public int [] crearVector() {
        System.out.print("Ingrese el tamaño del vector → ");

        int [] vector = new int []{1};

        return vector;
    }

    public static int [] llenarVector(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Ingrese el tamaño del vector → ");
        int n = ValidadorEntrada.leerEntero(scanner);
        int[] vector = new int[n];
        for (int i = 0; i < n; i++) {
            vector[i] = random.nextInt(100,200);
            System.out.println(vector[i]);
        }
        return vector;
    }

    public static int[] binarySearch (int[] vector, int value) throws ElementNotFoundException {
        int start = 0;
        int end = vector.length - 1; // Para que no se salga del bound
        int [] indexes = new int[vector.length]; // por si tódos los elementos en el array son iguales
        boolean keepOneZero = false;
        while (start <= end) {
            // Empezamos por la mitad
            int position = Math.round( (float) (start + end) / 2);

            if (vector[position] == value) {

                indexes[0] = position;
                int contador = 1;
                int indices = 1;

                // Por si la única posición que encuentra con el valor es la 0, para que conserve el cero
                if (position == 0) {
                    keepOneZero = true;
                }

                try {
                    while (vector[position - contador] == value) {
                        indexes[indices] = position - contador;
                        indices++;
                        contador++;
                        // para conservar los ceros en la clase de limpiar los ceros por crear el vector con él ".Length"
                        if (indexes[indices] == 0) {
                            keepOneZero = true;
                        }
                    }
                    // Por si el while se sale de los límites de su tamaño
                } catch (IndexOutOfBoundsException _) {
                }

                contador = 1;

                try {
                    while (vector[position + contador] == value) {
                        indexes[indices] = position + contador;
                        indices++;
                        contador++;
                    }
                    // Lo mismo que el catch de arriba
                } catch (IndexOutOfBoundsException _) {
                }


                return limpiarCerosVector(bubbleSorting(indexes), keepOneZero);

            } else if (vector[position] < value) {
                // si el valor del vector del índice donde estamos, es mayor al valor, se descarta el otro lado (Le ponemos el +1 porque si no es = al valor, pss se descarta lol)
                start = position + 1;
            }  else {
                // si el valor del vector del índice donde estamos, es menor al valor, se descarta el otro lado (Le ponemos el +1 porque si no es = al valor, pss se descarta lol)
                end = position - 1;
            }

        }
        throw new ElementNotFoundException( ColoresConsola.TEXTO_ROJO + " ✖ Valor " + value + " no encontrado en el array");
    }

    public static int[] limpiarCerosVector(int[] vector, boolean validadorCeros) {
        int contador = 0;
        for (int num : vector) {
            if (num != 0) contador++;
        }

        // Hice este chanchuyo para poder modificar por 1 el valor de contador, porque sino, se le olvida que existe un elemento en el índice 0
        if (validadorCeros) contador++;
        int index;
        int [] arrayLimpio = new int[contador];
        if (validadorCeros) {
            index = 1;
            arrayLimpio [0] = 0;
        } else {
            index = 0;
        }

        for (int num : vector) {
            if (num != 0) arrayLimpio[index++] = num;
        }

        return arrayLimpio;
    }

    // Excepción por si no encuentra la vaina
    public static class ElementNotFoundException extends Exception {
        public ElementNotFoundException(String message) {
            super(message);
        }
    }

    public static int[] bubbleSorting (int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] > vector[j+1]) {
                    int aux = vector[j];
                    vector[j] =  vector[j+1];
                    vector[j+1] = aux;
                }
            }
        }
        return vector;
    }
}


