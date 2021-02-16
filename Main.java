import java.io.*;
import java.util.*;




class Main {
    public static void main(String[] args)throws IOException{
        PrintWriter printer = new PrintWriter(new File("C:\\Users\\rosed\\Desktop\\numeros.txt"));
        Sorts sort = new Sorts();
        Random random = new Random();
        Comparable[] lista_num = new Comparable[3000];
        Comparable[] gnome;
        Comparable[] bubble;
        Comparable[] quick;
        Comparable[] merge;
        Comparable[] radix;
        int number = 0;
        int restantes = 3000;
        int contador = 0;
        while(restantes != 0){
            number = random.nextInt(3001);
            lista_num[contador] = number;
            printer.println(number);
            restantes--;
            contador++;
            

        }
        printer.flush();
        gnome = sort.Gnome_sort(lista_num);
        bubble = sort.BubbleSort(lista_num);
        quick = sort.Quicksort(lista_num, 0, lista_num.length-1);
        merge = sort.MergeSort(lista_num, 0, lista_num.length-1);
        radix = sort.radixsort(lista_num, lista_num.length -1);
        

        
        

    }
}

/*
Sorts sort = new Sorts();
        Comparable[] hola = {1,3,4,5,6,87,2,3,2,1,4,7,8,343};
        Comparable[] hola1 = sort.Quicksort(hola, 0, hola.length-1);
        System.out.println(hola);
        for(int i = 0; i<hola.length; i++){
            System.out.println(hola1[i]);
        }
*/