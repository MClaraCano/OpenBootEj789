package com.ejercicios789;

import org.w3c.dom.ls.LSOutput;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class EjerciciosSieteOchoNueve {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println("-------------------------");

        //Función que genera cadena de texto al revés
        reverse("Hola Mundo");


        System.out.println("");
        System.out.println("");

        //1. Crea un array unidimensional de Strings y recórrelo, mostrando sus valores.
        String[] cadenatexto = {"Esto", "es un", "Array", "Unidireccionar", "de String"};

        for (int i = 0; i< cadenatexto.length; i++){
            System.out.println(i + ": " + cadenatexto[i]);
        }

        System.out.println("");

        //2. Crea un array bidimensional de enteros y recórrelo,
        // mostrando la posición y el valor de cada elemento en ambas dimensiones.
        int[][] cadenaInt = new int[3][3];

        cadenaInt[0][0] = 56;
        cadenaInt[0][1] = 86;
        cadenaInt[0][2] = 5;
        cadenaInt[1][0] = 7;
        cadenaInt[1][1] = 33;
        cadenaInt[1][2] = 98;
        cadenaInt[2][0] = 9;
        cadenaInt[2][1] = 14;
        cadenaInt[2][2] = 25;

        for (int i = 0; i< cadenaInt.length; i++){
            for (int j = 0; j< cadenaInt.length; j++){
                System.out.println( "pos: " + i + " - " + j + " | valor: " + cadenaInt[i][j]);
            }
        }

        System.out.println("");

        //3. Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
        // Elimina el 2o y 3er elemento y muestra el resultado final.
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(89);
        vector.add(8);
        vector.add(9);
        vector.add(58);
        vector.add(3);

        vector.remove(2);
        vector.remove(3);

        System.out.println("vector: " + vector + " capacidad: " + vector.capacity());

        //4. Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.
        // Ocuparía demasiado espacio en la memoria, ya que cada vez que se alcanza la capacidad, la misma se duplica

        System.out.println("");

        //5. Arraylist de String, con 4 elementos. Copiar en LinkedList.
        //Recorrer ambos mostrando el valor de cada elemento
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Clara");
        arrayList.add("Franco");
        arrayList.add("Belén");
        arrayList.add("Miguel");


        //copia de arraylist en linkedlist
        LinkedList<String> linkedList = new LinkedList<>(arrayList);

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        System.out.println();

        System.out.println("Valores ArrayList:");
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        System.out.println("Valores LinkedList:");
        for (int i = 0; i < linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }

        System.out.println();

        //6. ArrayList de int; rellenarlo con bucle (1 a 10)
        //Hacer otro bucle que elimine los num pares
        //Recorrer de nuevo y mostrar ArrayList final

        ArrayList<Integer> arrayListInt = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++){
            arrayListInt.add(i);
        }

        System.out.println("arrayListInt: " + arrayListInt);

        for (int i = 0; i < arrayListInt.size(); i++){
            if (arrayListInt.get(i) % 2 == 0) {
                arrayListInt.remove(i);
                //continue;
            }
        }

        for (int i = 0; i < arrayListInt.size(); i++){
            System.out.println("arrayListInt recorrido sin pares: " + arrayListInt.get(i));
        }

        System.out.println();

        //7. Crea una función DividePorCero.
        // Esta, debe generar una excepción ("throws") a su llamante
        // del tipo ArithmeticException que será capturada por su llamante (desde "main", por ejemplo).
        // Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
        // Finalmente, mostraremos en cualquier caso: "Demo de código".


        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresá dos números enteros");
        int num1 = teclado.nextInt();
        int num2 = teclado.nextInt();

        try {
            dividePorCero(num1, num2);
        } catch (Exception e) {
            System.out.println("Esto no puede hacerse: " + e.getClass());
        } finally {
            System.out.println("Demo de código");
        }

        System.out.println();

        //8. Utilizando InputStream y PrintStream,
        // crea una función que reciba dos parámetros: "fileIn" y "fileOut".
        // La tarea de la función será realizar la copia del fichero
        // dado en el parámetro "fileIn" al fichero dado en "fileOut".

        //el FileInputStream pide que se use try catch. Si no, da error
        try {
            InputStream fichero = new FileInputStream("C:/Users/Cla y Fran/Documents/ejemploFichero.txt");
            // para leer el contenido de fichero...
            // FileInputStream devuelve secuencia de bytes; debe guardarse en Array de bytes
            try {
//                //le indico que lo lea:
//                //readAllBytes() lee todo. A veces no es conveniente
//                byte[] datos = fichero.readAllBytes();
//                //para mostrarlo:
//                for (byte dato : datos){
//                    //convierto los bytes a char
//                    System.out.print((char) dato);
//                }

                //ESTO ES OTRO MODO. Para ficheros más grandes!
                //NO VAV A SALIR EN CONSOLA a salir en consola los dos
                //le indico que lo lea:
                //read() lee en int, por eso ya no es Array
                //datos2 sigue leyendo en números, no letras
                int datos2 = fichero.read();
                //para mostrarlo:
                //hasta -1 (cuando termina el fichero = EOF: End Of File)
                while (datos2 != -1){
                    System.out.print((char)datos2);
                    datos2 = fichero.read();
                }


            } catch (IOException e){
                System.out.println("No puedo leer el fichero" + e.getMessage());
            }
        } catch (FileNotFoundException e){
            System.out.println("No existe el fichero. Error: " + e.getMessage());
        }


    }




    public static String reverse(String texto) {
        System.out.println("Texto al revés:");
        for (int i = texto.length() -1; i >= 0; i--){
            System.out.print(texto.charAt(i));
        }
        return texto;
    }



//    public static int dividePorCero (int num1, int num2){
//        int resultado = 0;
//        try {
//            resultado = num1 / num2;
//            System.out.println(resultado);
//        } catch (Exception e) {
//            System.out.println("No se puede dividir por CERO. Excepción: " + e.getClass());
//        } finally {
//            System.out.println("¿Jugaste bien?");
//        }
//        if (num2 != 0){
//            System.out.println("Sí, lo hiciste!");
//        } else {
//            System.out.println("No lo hiciste. Intentá de nuevo");
//        }
//        return resultado;

    public static int dividePorCero (int num1, int num2) throws ArithmeticException{
        int resultado = 0;
        try {
            resultado = num1 / num2;
            System.out.println("Resultado división: " + resultado);
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
        return resultado;

    }




}
