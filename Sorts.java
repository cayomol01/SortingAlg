


class Sorts{


    public Comparable[] Gnome_sort(Comparable[] array){
        int pos = 1;
        while (pos < array.length){
            if(pos == 0){
                pos++;
            }
            if(array[pos].compareTo(array[pos-1])>=0){
                pos++;
            }
            else{
                Comparable temp1 = array[pos]; 
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
                if (arr[j].compareTo(arr[j+1])>=0) 
                { 
                    Comparable temp = arr[j]; 
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



  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public Comparable[] Quicksort(Comparable[] arr, int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr,low,high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            Quicksort(arr, low, pi-1); 
            Quicksort(arr, pi+1, high); 
        } 
        return arr;
    } 

    int partition(Comparable[] arr, int low, int high){ 
        Comparable pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j].compareTo(pivot)<0){ 
                i++; 
                // swap arr[i] and arr[j] 
                Comparable temp = arr[i]; 
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


    //*****MERGE SORT********
    void merge(Comparable arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        Comparable L[] = new Comparable[n1];
        Comparable R[] = new Comparable[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
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
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public Comparable[] MergeSort(Comparable arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }

    //********RADIX SORT****************** */
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
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            count[(Integer.parseInt(arr[i].toString()) / exp) % 10]++; 
        }
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
            
        } 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) { 
            output[Integer.parseInt(count[(Integer.parseInt(arr[i].toString()) / exp) % 10].toString())- 1] = arr[i]; 
            count[(Integer.parseInt(arr[i].toString()) / exp) % 10]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++){
            arr[i] = output[i]; 
        }
    } 
   
    public Comparable[] radixsort(Comparable arr[], int n) 
    { 

        Integer m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that 
        // instead of passing digit number, exp is passed. 
        // exp is 10^i where i is current digit number 
        for (int exp = 1; Integer.parseInt(m.toString()) / exp > 0; exp *= 10){
            countSort(arr, n, exp); 
        }
        return arr;
    }
    

}