import java.util.Arrays;

public class negative_to_left {
    public static void main(String[] args) {
        int[] arr = { -12, -11, -13, -5, 6, -1, 5, -3, -6, 10, 12, 13, -6 };
        System.out.println("Before: " + Arrays.toString(arr));
        arr = arrange(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

    private static int[] arrange(int[] arr) {
        for (int i = 0, j = 1; j < arr.length; j++) {
            if (arr[i] > 0 && arr[j] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            } else if (arr[i] > 0 && arr[j] > 0) {
                continue;
            } else {
                i++;
            }
        }
        return arr;
    }

    // solution from GFG
    // static void arrange(int arr[], int n) {
    // int j = 0, temp;
    // for (int i = 0; i < n; i++) {
    // if (arr[i] < 0) {
    // if (i != j) {
    // temp = arr[i];
    // arr[i] = arr[j];
    // arr[j] = temp;
    // }
    // j++;
    // }
    // }
    // }
}
