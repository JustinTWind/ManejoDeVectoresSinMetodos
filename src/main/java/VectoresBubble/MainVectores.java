package VectoresBubble;

import  misUtilidades.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MainVectores {
    /*
        Ejercicio dos

        Hacer un programa que lea un vector de números enteros de tamaño N y luego realice las siguientes tareas
        Ordene el vector ascendentemente
        Muestre el vector
        Inserte un elemento en el vector ordenado
        elimine un elemento en el vector ordenado (Si el elemento N está repetido, los debe eliminar todos)
        implemente la búsqueda binaria
        Leer dos vectores de enteros de tamaño n y m respectivamente, ordenarlos por último crear otro vector con los elementos de los primeros vectores
     */

     static void main(String[] args){

         /* Rojo
         System.out.printf(STR."""

           ▀██    ██▀           ▄               ▀██                        ▀██                                 ▀██                                       ██                     ▄             \s
            ███  ███    ▄▄▄▄  ▄██▄    ▄▄▄     ▄▄ ██    ▄▄▄    ▄▄▄▄       ▄▄ ██    ▄▄▄▄       ▄▄▄   ▄▄▄ ▄▄    ▄▄ ██    ▄▄▄▄  ▄▄ ▄▄▄    ▄▄▄▄   ▄▄ ▄▄ ▄▄   ▄▄▄    ▄▄▄▄  ▄▄ ▄▄▄   ▄██▄    ▄▄▄     \s
            █▀█▄▄▀██  ▄█▄▄▄██  ██   ▄█  ▀█▄ ▄▀  ▀██  ▄█  ▀█▄ ██▄ ▀     ▄▀  ▀██  ▄█▄▄▄██    ▄█  ▀█▄  ██▀ ▀▀ ▄▀  ▀██  ▄█▄▄▄██  ██  ██  ▀▀ ▄██   ██ ██ ██   ██  ▄█▄▄▄██  ██  ██   ██   ▄█  ▀█▄   \s
            █ ▀█▀ ██  ██       ██   ██   ██ █▄   ██  ██   ██ ▄ ▀█▄▄    █▄   ██  ██         ██   ██  ██     █▄   ██  ██       ██  ██  ▄█▀ ██   ██ ██ ██   ██  ██       ██  ██   ██   ██   ██   \s
           ▄█▄ █ ▄██▄  ▀█▄▄▄▀  ▀█▄▀  ▀█▄▄█▀ ▀█▄▄▀██▄  ▀█▄▄█▀ █▀▄▄█▀    ▀█▄▄▀██▄  ▀█▄▄▄▀     ▀█▄▄█▀ ▄██▄    ▀█▄▄▀██▄  ▀█▄▄▄▀ ▄██▄ ██▄ ▀█▄▄▀█▀ ▄██ ██ ██▄ ▄██▄  ▀█▄▄▄▀ ▄██▄ ██▄  ▀█▄▀  ▀█▄▄█▀   \s


            \{ColoresConsola.TEXTO_CIAN} ⠀⠀⠀⠀
                                                                        ⠀   ⣾⣿⣿⣿⠷⣆⠀⠀⠀⠀⠀⠀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⢸⡿⠿⠿⠏⠀⣿⡇⠀⣠⣶⣿⣿⣿⣯⡙⠻⣦⡀⠀⣀⣤⣤⣄⡀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠈⢿⣄⣀⣀⣴⠟⠀⣰⣿⣿⣿⣿⣿⣿⣷⠀⠈⣿⣿⣿⣿⣿⣯⠛⢦⡀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠈⠉⠉⠁⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⢻⣿⣿⣿⣿⣿⠀⢸⣧⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡙⠿⢿⣿⠿⠟⠁⠀⠀⠀⠙⠛⠛⠛⠁⠀⢸⡏⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢷⣀⠀⠀⢀⣠⣴⣶⣶⣦⣄⠀⠀⠀⠀⢴⡟⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⣠⣶⣿⡿⠶⣦⣄⠀⠛⠷⣶⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⢻⣆⠀⠀
                                                                        ⠀ ⠀⢀⣾⣿⣿⣿⣿⣆⠈⠻⣧⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⢻⡆       \uD835\uDCD1\uD835\uDCFE\uD835\uDCFB\uD835\uDCEB\uD835\uDCFE\uD835\uDCF3\uD835\uDCF2\uD835\uDCFD\uD835\uDCEA\uD835\uDCFC
                                                                        ⠀ ⠀⢸⣿⣿⣿⣿⣿⠏⠀⠀⣿⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⢸⡇⠀
                                                                        ⠀ ⠀⠈⢿⡉⠛⠋⠁⠀⠀⣴⡟⠀⠸⣿⠻⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⣼⠇⠀
                                                                        ⠀ ⠀⠀⠈⠙⣶⣶⣶⣄⠉⠻⣦⠀⠀⠹⣧⡈⠉⠛⠛⠉⠀⠀⠀⠀⠀⠀⣼⠏⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⣿⣿⣿⡿⠀⠀⣽⠀⠀⠀⠘⠿⣦⣀⠀⠀⠀⠀⠀⢀⣴⠾⠋⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠻⣯⣄⣀⣠⣴⠟⠀⠀⠀⠀⠀⠈⠉⠛⠛⠒⠚⠛⠉⠁⠀⠀⠀⠀⠀
                                                                         ⠀ ⠀⠀⠀⠀⠀⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
            \{ColoresConsola.TEXTO_VERDE}       ⠀⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀               ⢠⠒⠉⠉⠉⢢⠤⠤⡀⢀⣀⣀⠀⡠⠖⠋⠉⠉⠒⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣄⠀⠀⠀⠀⠀⠀⢀⠎⠀⠀⠀⠙⠄⠀⠀⠀⠀⠀⠈⡇⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠤⠐⠠⠄⡀⠀⠀⠀⢀⠄⠈⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠈⡇⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⠀⠀⠀⠹⠔⠒⠢⠇⠀⠀⠀⠀⠀⠀⠠⠤⡖⠁⠘⡄⠀⠀⠀⠀⣠⣃⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⢀⡠⠤⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠃⠀⠀⠀⠀⠰⡄⠀⠀⠈⠁⠀⠙⣄⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⡔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠁⠀⠀⠀⠀⠀⠀⡜⠂⠲⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠉⠀⠉⢢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣞⠀⠀⠘⠒⠂⡀
                                                                        ⠀ ⠀⢀⡠⠐⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠁⠘⠂⠈⠆⠀⠀⠀⠀⠀⠀⠈⡆⠀⠀⠀⠀⡝
                                                                        ⠀ ⢠⠋⠀⠀⠀⡠⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢄⣀⣀⡠⡂⠀⠀⠀⠠⡄⠀⠀⢀⡀⠀⢀⡰⠃⠀⠀⠀⠺⣅
                                                                        ⠀ ⡇⠀⠀⠀⠀⠣⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⡄⠀⠰⣀⡠⣀⠀⢀⣠⠎⠉⣹⣀⠀⠀⠀⠀⠀⣸
                                                                        ⠀ ⡇⠀⠀⠀⠀⢰⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣤⢷⠒⠂⠐⡎⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠁⠀⠉⢢⠀⢰⠊⠁
                                                                        ⠀ ⠘⢤⡤⠀⠀⠀⠑⠂⠐⢆⠀⣄⣀⣀⠀⠀⡀⢀⡴⠀⠀⡧⣀⠜⠑⠂⢺⢳⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡜⠐⠃⠀⠀
                                                                        ⠀ ⠀⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⢎⠀⠡⠀⠀⠱⡀⣠⠀⠀⡏⠈⢱⢲⠂⠀⠀⠀⠀⠀⠀⠀⠀⠱⠀⠀⠀⠀        \uD835\uDCD0\uD835\uDCFB\uD835\uDCEB\uD835\uDCF8\uD835\uDCF5\uD835\uDCF2\uD835\uDCFD\uD835\uDCF8\uD835\uDCFC
                                                                        ⠀ ⠀⠱⣄⡀⣠⠃⠀⠀⠀⠀⠀⠀⠀⠉⢫⣁⢫⡳⢄⢣⠀⠀⠉⠀⠀⢰⠇⢀⠇⢾⡻⠖⢖⠁⠀⡀⡀⠀⢀⡼⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠸⡀⠀⠀⠀⠐⣄⣀⣀⡠⠎⠓⢯⡀⠀⢸⠀⠀⠀⠀⠀⣸⢁⠎⡴⡋⠀⠀⠀⡉⠉⠀⠈⡏⠁⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠉⠒⠒⠒⠋⠀⠀⠀⠀⠀⠀⠀⠹⡄⠀⠀⠀⠀⠀⠀⣿⢏⡾⠝⠓⠢⠤⠊⠈⠑⠒⠊⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⠀⠀⠀⡠⠄⣀⣿⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⢸⡜⣉⢿⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⠀⠀⠸⡱⡻⡸⢸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢤⡤⢄⡀⠀⢀⣀⣀⢇⠀⠀⠀⠉⠈⠀⡎⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠠⢤⡤⠀⢘⡆⠈⠋⣑⣽⣾⠌⠀⠀⠀⠀⠀⠀⠣⣸⣄⠀⢹⡅⠀⠔⠪⠿⢤⣤⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠐⠈⠉⠀⢀⣤⣖⣋⣁⣀⣋⣀⣀⠀⠒⠒⠄⠀⠀⠈⠈⠓⠦⢤⣀⠀⠀⠀⠀⠀⠑⠀⠀⠀⠀⠀⠀
                                                                        ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠒⠦⣄⣸⡟⠒⠒⠒⠒⠒⠚⠛⠀⠀⠀⠀
           \s""" + ColoresConsola.COLOR_RESET);

          */ // Rojo
         Menu menu = new Menu();
         boolean salir=false;
         ArrayList<int []> arrayDeArrays = new ArrayList<>();
         while (!salir){
             int opcion = menu.mostrarMenuPrincipal();
             switch (opcion){
                 case 1 -> arrayDeArrays.add(menu.mostrarMenuAñadirVector());
                 case 2 -> menu.organizarVectoresBubble(arrayDeArrays);
                 case 3 -> menu.mostrarArrays(arrayDeArrays);
                 case 4 -> menu.añadirElementoArrays(arrayDeArrays);
                 case 5 -> menu.eliminarElementoArrays(arrayDeArrays);
                 case 6 -> menu.encontrarIndiceNumeros(arrayDeArrays);
                 case 8 -> salir=true;
             }
         }

          arrayDeArrays.stream().map(Arrays::toString).forEach(System.out::println);

         menu.cerrar();


         // Pruebas de métodos

         /*
         int [] vector = new int []{1,1,1,2,3,4,5,6,7,8,9,10};
        try{
            int [] posicion = binarySearch(vector,1);
            System.out.println("Posiciones: " + Arrays.toString(posicion));
        } catch (ElementNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
          */

    }

}
