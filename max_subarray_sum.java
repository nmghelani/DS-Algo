//NOTE: This might not be the optimal solution, kindly refer some websites for most optimal solution
public class max_subarray_sum {
    public static void main(String[] args) {
        int[] arr = { -1, -2, -3, -4 };
        int max_sum = maxSubArraySum(arr, arr.length);
        System.out.println("Max subarray sum: " + max_sum);
    }

    static int maxSubArraySum(int arr[], int n) {
        int max_ending_here = 0, max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max_ending_here += arr[i];
            max_so_far = Integer.max(max_ending_here, max_so_far);
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
}
