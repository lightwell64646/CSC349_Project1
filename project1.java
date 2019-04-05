class lab0{   
   public static void selectionSort(int[] arr, int N){
      for (int i = 0; i < N; i++){
         int min = arr[i];
         int min_index = i;
         for (int j = i + 1; j < N; j++){
            if (min > arr[j]){
               min = arr[j];
               min_index = j;
            }
         }
         arr[min_index] = arr[i];
         arr[i] = min;
      }
   }
   public static void mergeSort(int[] arr, int N){
      mergeSort(arr, 0, N - 1);
   }
   private static void mergeSortedHalves(int[] arr, int first, int middle, int last){
      int temp[last - first + 1];
      int index1 = first;
      int index2 = middle + 1;
      int index = 0;

      //pull smallest step
      while (index1 < middle && index2 < last){
         if (arr[index1] < arr[index2]){
            temp[index] = arr[index1];
            index1 += 1;
         }
         else{
            temp[index] = arr[index2];
            index2 += 1;
         }
         index += 1;
      }

      //copy remainder
      while (index1 != middle){
         temp[index] = arr[index1];
         index += 1;
         index1 += 1;
      }
      while (index2 != last){
         temp[index] = arr[index2];
         index += 1;
         index2 += 1;
      }

      //copy tmp step
      for (index = 0; index < last - first + 1; index++){
         arr[first + index] = temp[index];
      }
   }
   private static void mergeSort(int[] arr, int first, int last){
      if (first < last){
         //normal
         int middle = (first + last) / 2;
         mergeSort(arr, first, middle);
         mergeSort(arr, middle + 1, last);
         mergeSortedHalves(arr, first, middle, last);
      }
      else{
         //basecase
      }
   }

   public static void quickSort(int[] arr, int N){
      quickSort(arr, 0, N - 1); 
   }

   private static void quickSort(int[] arr, int first, int last){
      int pivot = (first - last)/2;
   }

   public static void main(String []args){

   }

}




