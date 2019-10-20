package P3;

public class Main_Radix_Sort {

    private static void countSort(int arr[], int exp) {

        int count[] = new int[10];
        for (int i = 0; i < 10; i++)
            count[i] = 0;

        for (int i = 0; i < arr.length; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        int sortedArr[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = sortedArr[i];
    }

    private static void radixSort(int arr[]) {

        int maxNumber = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > maxNumber)
                maxNumber = arr[i];

        for (int exp = 1; maxNumber / exp > 0; exp *= 10)
            countSort(arr, exp);}

    public static void main(String[] args) {

        int arr[] = {789,88,4,11,0,12,3,7890,56};
        radixSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}


