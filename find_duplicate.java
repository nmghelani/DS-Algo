import java.util.HashMap;

public class find_duplicate {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 3, 1, 4, 9 };
        int duplicate = findDuplicate(arr);
        System.out.println("Duplicate: " + duplicate);
    }

    private static int findDuplicate(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return arr[i];
            }
            map.put(arr[i], 0);
        }
        return -1;
    }
}
