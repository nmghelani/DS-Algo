import java.util.HashMap;

public class union_intersection {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        int[] b = { 2, 3, 4, 5 };
        int union = getUnionCnt(a, b);
        int intersect = getIntersectCnt(a, b);
        System.out.println("Union: " + union + " Intersection: " + intersect);
    }

    private static int getIntersectCnt(int[] a, int[] b) {
        int cnt = 0;
        for (int i = 0; i < b.length; i++) {
            if (contains(a, 0, a.length - 1, b[i])) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int getUnionCnt(int[] a, int[] b) {
        HashMap<Integer, Integer> union = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!union.containsKey(a[i])) {
                union.put(a[i], 0);
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (!union.containsKey(b[i])) {
                union.put(b[i], 0);
            }
        }
        return union.size();
    }

    private static boolean contains(int[] arr, int start, int end, int no) {
        if (end < start)
            return false;
        int mid = (start + end) / 2;
        if (arr[mid] == no) {
            return true;
        } else if (no < arr[mid]) {
            return contains(arr, start, mid - 1, no);
        } else if (no > arr[mid]) {
            return contains(arr, mid + 1, end, no);
        }
        return false;
    }
}
