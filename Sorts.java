


class Sorts {


    public Comparable[] Gnome_sort(Comparable[] array){
        int pos = 1;
        while (pos < array.length){
            if(array[pos].compareTo(array[pos-1])==1){
                pos++;
            }
            else{
                int temp1 = array[pos]; 
                array[pos] = array[pos - 1]; 
                array[pos - 1] = temp1; 
                pos--;
            }
        }
        return array;
    }

    public Comparable[] BubbleSort(Comparable[] arr){
  
        for (int i = 0; i < arr.length-1; i++){ 
            for (int j = 0; j < arr.length-i-1; j++){
                if (arr[j].compareTo(arr[j+1])==1) 
                { 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }
            } 
            
        } 
        return arr;
    }

    public Comparable[] MergeSort(Comparable[] arr){

        return arr;
    }


    int partition(Comparable[] arr){ 
        int low = 0; 
        int high =  arr.length-1;
        Comparable pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j].compareTo(pivot)<0){ 
                i++; 
                // swap arr[i] and arr[j] 
                comparable temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        Comparable temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(Comparable arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 

    public int getMax(Comparable arr[]){ 
        int n = arr.length;
        int max = arr[0]; 
        for (int i = 1; i < n; i++){ 
            if (arr[i].compareTo(max)>0){
                max = arr[i]; 
            }
        }
        return mx; 
        
    } 

    public void radixsort(Comparable arr[]) 
    { 
        int n = arr.length;
        int m = getMax(arr); 
  
        // Do counting sort for every digit. Note that 
        // instead of passing digit number, exp is passed. 
        // exp is 10^i where i is current digit number 
        for (int exp = 1; m / exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 

}