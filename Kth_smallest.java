//NOTE: This might not be the optimal solution, kindly refer some websites for most optimal solution
public class Kth_smallest {
    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 4;
        if (k <= arr.length) {
            System.out.println(k + "th smallest number: " + getKthSmallest(arr, k)); // Ignore st/rd/th :D
        } else {
            System.out.println("K cannot be greater than size of array");
        }
    }

    private static int getKthSmallest(int[] arr, int k) {
        // You can use any sorting algorithm or can use Arrays.sort(arr) if allowed
        arr = quickSort(arr, 0, arr.length - 1);
        return arr[k - 1];
    }

    private static int[] quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int q = partition(arr, l, r);
            arr = quickSort(arr, l, q - 1);
            arr = quickSort(arr, q + 1, r);
        }
        return arr;
    }

    private static int partition(int[] arr, int l, int r) {
        int i = l - 1;
        int pivot = arr[r];
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }
}
