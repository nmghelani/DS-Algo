import java.util.Arrays;

//Code copied from GFG, mine is not optimal
public class merge_without_extra_space {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 0, 2, 6, 8, 10 };
        int n = arr1.length, m = arr2.length;
        merge(arr1, arr2, n, m);
        // region non-optimal
        // if (n == 0) {
        // return;
        // }
        // while (arr1[n - 1] > arr2[0]) {
        // int removed = addAndGetRemoved(arr1, 0, n - 1, arr2[0]);
        // addAndSort(arr2, 0, m - 1, removed);
        // }
        // endregion
        System.out.println(Arrays.toString(arr1) + " " + Arrays.toString(arr2));
    }

    public static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    public static void merge(int arr1[], int arr2[], int n, int m) {
        int i, j, gap = n + m, tmp;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    tmp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = tmp;
                }
            }

            for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    tmp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = tmp;
                }
            }

            if (j < m) {
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        tmp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = tmp;
                    }
                }
            }
        }
    }

    // region non-optimal
    // static int addAndGetRemoved(int[] arr, int start, int end, int no) {
    // int mid = (start + end) / 2;
    // if (start == end) {
    // if (arr[start] <= no) {
    // return addToPositionFromRight(arr, start + 1, no);
    // } else {
    // return addToPositionFromRight(arr, start, no);
    // }
    // } else {
    // if (arr[mid] <= no) {
    // return addAndGetRemoved(arr, mid + 1, end, no);
    // } else {
    // return addAndGetRemoved(arr, start, mid, no);
    // }
    // }
    // }

    // static void addAndSort(int[] arr, int start, int end, int no) {
    // int mid = (start + end) / 2;
    // if (start == end) {
    // if (arr[start] <= no) {
    // addToPositionFromLeft(arr, start + 1, no);
    // } else {
    // addToPositionFromLeft(arr, start, no);
    // }
    // } else {
    // if (arr[mid] <= no) {
    // addAndSort(arr, mid + 1, end, no);
    // } else {
    // addAndSort(arr, start, mid, no);
    // }
    // }
    // }

    // private static int addToPositionFromRight(int[] arr, int pos, int no) {
    // int removed = arr[arr.length - 1];
    // for (int i = arr.length - 2; i >= pos; i--) {
    // arr[i + 1] = arr[i];
    // }
    // arr[pos] = no;
    // return removed;
    // }

    // private static void addToPositionFromLeft(int[] arr, int pos, int no) {
    // for (int i = 1; i < pos; i++) {
    // arr[i - 1] = arr[i];
    // }
    // arr[pos - 1] = no;
    // }
    // endregion
}
