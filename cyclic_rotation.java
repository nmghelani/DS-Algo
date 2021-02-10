import java.util.Arrays;

//NOTE: This might not be the optimal solution, kindly refer some websites for most optimal solution
public class cyclic_rotation {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6, 7 };
        System.out.println("Before: " + Arrays.toString(arr));
        arr = rotateLeft(arr, 2);
        System.out.println("After: " + Arrays.toString(arr));
    }

    private static int[] rotateLeft(int[] arr, int rotateBy) {
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < rotateBy; i++) {
            int temp = arr[0];
            for (int j = 1; j < arr.length; j++) {
                arr[j - 1] = arr[j];
            }
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

    private static int[] rotateRight(int[] arr, int rotateBy) {
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < rotateBy; i++) {
            int temp = arr[arr.length - 1];
            for (int j = arr.length - 2; j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[0] = temp;
        }
        return arr;
    }
}
