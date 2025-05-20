package com.practica.estructura.base.controller.arreglo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.practica.estructura.base.controller.dataStruct.list.LinkedList;
import com.practica.estructura.base.controller.dataStruct.list.Node;

public class Arreglo {


public static LinkedList<Integer> extractData(String filePath) {
    LinkedList<Integer> lista = new LinkedList<>();
    try (Scanner scanner = new Scanner(new File(filePath))) {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                lista.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado: " + filePath);
    }
    return lista;
}

public static int[] toArray(LinkedList<Integer> lista) {
    int[] array = new int[lista.getLength()];
    Node<Integer> current = lista.getHead();
    int index = 0;
    while (current != null) {
        array[index++] = current.getData();
        current = current.getNext();
    }
    return array;
}

public static int[][] toMatrix(int[] numeros) {
    int filas = (int) Math.ceil(numeros.length / 2.0);
    int[][] matriz = new int[filas][2];
    for (int i = 0; i < numeros.length; i++) {
        matriz[i / 2][i % 2] = numeros[i];
    }
    return matriz;
}

public static LinkedList<Integer> buscarRepetidos(LinkedList<Integer> lista) {
    LinkedList<Integer> repetidos = new LinkedList<>();
    Node<Integer> current = lista.getHead();

    while (current != null) {
        int data = current.getData();
        boolean found = false;

        Node<Integer> check = repetidos.getHead();
        while (check != null) {
            if (check.getData() == data) {
                found = true;
                break;
            }
            check = check.getNext();
        }

        if (!found) {
            int count = 0;
            Node<Integer> temp = lista.getHead();
            while (temp != null) {
                if (temp.getData() == data) {
                    count++;
                }
                temp = temp.getNext();
            }

            if (count > 1) {
                repetidos.add(data);
            }
        }

        current = current.getNext();
    }

    return repetidos;
}

public static void imprimirResultados(int[] numeros, int[][] matriz, LinkedList<Integer> repetidos,
        long tiempoArreglo, long tiempoLista) {
    System.out.println("\nDatos en arreglo:");
    for (int n : numeros)
        System.out.print(n + " ");

    System.out.println("\n\nMatriz 2 columnas:");
    for (int[] fila : matriz) {
        System.out.print("[");
        for (int j = 0; j < fila.length; j++) {
            System.out.print(fila[j]);
            if (j < fila.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    System.out.println("\n\n Elementos repetidos:\n\n");
    Node<Integer> node = repetidos.getHead();
    while (node != null) {
        System.out.print(node.getData() + " ");
        node = node.getNext();
        
    }
    

    System.out.println("\nCantidad de valores repetidos: \n" + repetidos.getLength());

    System.out.println("\nComparación de rendimiento:");
    System.out.println("Tiempo para llenar arreglo: " + (tiempoArreglo / 1_000_000.0) + " ms");
    System.out.println("\nTiempo para llenar LinkedList: " + (tiempoLista / 1_000_000.0) + " ms");

}

public static void main(String[] args) {
    String filePath = "Data/data.txt";

    long inicioArreglo = System.nanoTime();
    LinkedList<Integer> listaOriginal = extractData(filePath);
    int[] numeros = toArray(listaOriginal);
    long finArreglo = System.nanoTime();

    long inicioLista = System.nanoTime();
    LinkedList<Integer> lista = new LinkedList<>();
    for (int num : numeros)
        lista.add(num);
    long finLista = System.nanoTime();

    int[][] matriz = toMatrix(numeros);
    LinkedList<Integer> repetidos = buscarRepetidos(lista);

    imprimirResultados(numeros, matriz, repetidos, finArreglo - inicioArreglo, finLista - inicioLista);
}


} 
