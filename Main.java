class Main 
{
  public static void main(String[] args){
    int[] arr = {23, 6, 87, 4, 5, 20};
    //sort(arr);
    sortRecursive(arr, arr.length, 0);
    for(int e:arr)
    {
      System.out.println(e);
    }//end for loop
  }//end main method

  public static void sortRecursive(int[] a, int n, int index)
  {
    if (index == n)
      return;
    
    int k = minIndex(a, index, n-1);

    if(k != index)
    {
      int temp = a[k];
      a[k] = a[index];
      a[index] = temp;
    }
    sortRecursive(a, n, index+1);
  }//end recursive implemenation method
  //helper method for finding the minimum of the unsorted array
  public static int minIndex(int a[], int i, int j)
  {
    if (i == j)
    {
      return i;
    }
    int k = minIndex(a, i+1, j);
    //ternary operator
    return (a[i] < a[k]) ? i : k;
    /*conditional equivalent
    if (a[i] < a [k])
      return i;
    else
      return k;
    */
  }

  public static void sort (int a[])
  {
    int n = a.length;
    //outer loop to iterate to the next spot
    //this also seperates between the sorted and unsorted subarrays
    //don't need to sort the last element

  
    for(int i = 0; i < n-1; i++)
    {
      //find the minimum of the unsorted subarrays
      int minIndex = i;
      for (int j = i + 1; j < n; j++)
      {
        if(a[j] < a[minIndex])
        {
          minIndex = j;
        }
      }//end inner for loop to find minimum 

      //now swap those two values
      int temp = a[minIndex];
      a[minIndex] = a[i];
      a[i] = temp;
    }//end outer for loop
  }//end nested loop selection sort method
}//end class Main