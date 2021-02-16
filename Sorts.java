


class Sorts{


    public Comparable[] Gnome_sort(Comparable[] array){
        int pos = 1;
        while (pos < array.length){
            if(pos == 0){ //Cuando la posicion llega a 0 esta se vuelve 1
                pos++;
            }
            if(array[pos].compareTo(array[pos-1])>=0){
                pos++;
            }
            else{
                Comparable temp1 = array[pos]; //Se intercambian los elementos en el array
                array[pos] = array[pos - 1]; 
                array[pos - 1] = temp1; 
                pos--;
            }
        }
        return array;
    }

    public Comparable[] BubbleSort(Comparable[] arr){
  
        for (int i = 0; i < arr.length-1; i++){ //Primer punter al array
            for (int j = 0; j < arr.length-i-1; j++){ //Puntero que recorre el array más rápido
                if (arr[j].compareTo(arr[j+1])>=0) 
                { 
                    Comparable temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp;  //Se intercambian los elementos en el array
                }
            } 
            
        } 
        return arr;
    }




  
  
    /* Funcion que implementa QuickSort() 
      arr[] --> Array con el que se va a trabajar, 
      low  --> Indice donde empieza, en este caso 0, 
      high  --> Indice final */
    public Comparable[] Quicksort(Comparable[] arr, int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi es el indice donde se parte el array.   */
            int pi = partition(arr,low,high); 
  
            // Usar recursividad para el sort 
            Quicksort(arr, low, pi-1); 
            Quicksort(arr, pi+1, high); 
        } 
        return arr;
    } 

    int partition(Comparable[] arr, int low, int high){ 
        Comparable pivot = arr[high];  //Pivote es el elemento más a la derecha en el array
        int i = (low-1); // Indice del elemento más pequño 
        for (int j=low; j<high; j++) 
        { 
            // Si el elemento es más pequeño que el pivote. 
            if (arr[j].compareTo(pivot)<=0){ 
                i++; 
                // swap arr[i] and arr[j] 
                Comparable temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // Intercambiar los elementos en el array usando un temporal
        Comparable temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 


    //*****MERGE SORT********
    void merge(Comparable arr[], int l, int m, int r)
    {
        // Encontrar los tamaños de los arrays que se crearan a partir del que se tiene
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Crear arrays temporales tipo Comparable */
        Comparable L[] = new Comparable[n1];
        Comparable R[] = new Comparable[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Usar el merge con los arrays */
 
        //Indices iniciales del primer y segundo arrays más pequeños
        int i = 0, j = 0;
 
        // Indice inicial del array merged
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j])>= 0) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copiar los elementos del array si es que todavia hay */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copiar los elementos del array si todavia los hay */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Funcion que hace el sort para luego hacer el merge de todos los arrays
    // merge()
    public Comparable[] MergeSort(Comparable arr[], int l, int r)
    {
        if (l < r) {
            // Encontrar donde se parte el algoritmo
            int m =l+ (r-l)/2;
            
            //Utilizar recursion para el algoritmo
            // Ordenar las primeras dos mitades
            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);
 
            // Unir las primeras dos mitadas
            merge(arr, l, m, r);
        }
        return arr;
    }

    //********RADIX SORT****************** */
    //Devolver el valor maximo dentro del array
    public Integer getMax(Comparable arr[], int n){ 
        Integer max = Integer.parseInt(arr[0].toString()); 
        for (int i = 1; i < n; i++){ 
            if (arr[i].compareTo(max)>=0){
                max = Integer.parseInt(arr[i].toString()); 
            }
        }
        return max; 
        
    } 


    public void countSort(Comparable arr[], int n, int exp) 
    { 
        Comparable output[] = new Comparable[n]; // array output 
        int i; 
        Integer count[] = new Integer[10]; 
        for(int j = 0; j< count.length; j++){
            count[j] = 0;
        }
  
        // LLevar cuenta de los datos del array principal y sus digitos en count[] 
        for (i = 0; i < n; i++) {
            count[(Integer.parseInt(arr[i].toString()) / exp) % 10]++; 
        }
  
        // Cambiar count[i] para que output[] tenga la verdader posicion del ditito
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
            
        } 
  
        // Crear un array output
        for (i = n - 1; i >= 0; i--) { 
            output[Integer.parseInt(count[(Integer.parseInt(arr[i].toString()) / exp) % 10].toString())- 1] = arr[i]; 
            count[(Integer.parseInt(arr[i].toString()) / exp) % 10]--; 
        } 
  
        // Copiar el output[i] a array para que array ahora tenga los numeros ordenados por sus digitos
        for (i = 0; i < n; i++){
            arr[i] = output[i]; 
        }
    } 
   
    public Comparable[] radixsort(Comparable arr[], int n) 
    { 

        Integer m = getMax(arr, n); 
  
        // Se hace una cuenta por cada numero que pasa, sin embargo lo que se está viendo es el digito más significante y de esa manera ordenarlos. 
        for (int exp = 1; Integer.parseInt(m.toString()) / exp > 0; exp *= 10){
            countSort(arr, n, exp); 
        }
        return arr;
    }
    

}