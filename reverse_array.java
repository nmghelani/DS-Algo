
//NOTE: This might not be the optimal solution, kindly refer some websites for most optimal solution
import java.util.Arrays;

class ReverseArray {

    static void rvereseArray(int arr[], int start, int end) {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start + 1, end - 1);
    }

    static void printArray(int arr[], String msg) {
        System.out.println(msg + " " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        printArray(arr, "Given Array:");
        rvereseArray(arr, 0, 5);
        printArray(arr, "Reversed Array:");
    }
}