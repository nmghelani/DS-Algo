import java.util.Arrays;

public class sort_012 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 1, 1, 2, 0, 2, 0, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
        System.out.println("Before: " + Arrays.toString(arr));
        arr = sort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

    private static int[] sort(int[] arr) {
        int n = arr.length;
        for (int low = 0, high = n - 1, mid = 0; mid <= high;) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
        return arr;
    }
}
