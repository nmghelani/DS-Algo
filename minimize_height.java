
//NOTE: This might not be the optimal solution, kindly refer some websites for most optimal solution
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class minimize_height {

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "{" + first + ", " + second + "}";
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 3, 4, 7, 2, 10, 3, 2, 1 };
        int k = 5, n = arr.length;
        System.out.println("Answer: " + getMinDiff(arr, n, k));
    }

    private static int getMinDiff(int[] arr, int n, int k) {
        ArrayList<Pair> map = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            if (arr[i] - k >= 0) {
                map.add(new Pair(arr[i] - k, i));
            }
            map.add(new Pair(arr[i] + k, i));
        }
        Collections.sort(map, new Comparator<Pair>() {

            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.first < p2.first) {
                    return -1;
                } else if (p1.first > p2.first) {
                    return 1;
                }
                return 0;
            }

        });

        int[] visited = new int[n];
        int ele = 0, l = 0, r = 0;
        while (ele < n && r < map.size()) {
            if (visited[map.get(r).second]++ == 0) {
                ele++;
            }
            r++;
        }
        int ans = map.get(r - 1).first - map.get(l).first;
        while (r < map.size()) {
            if (visited[map.get(l).second]-- == 1) {
                ele--;
            }
            l++;
            while (ele < n && r < map.size()) {
                if (visited[map.get(r).second]++ == 0) {
                    ele++;
                }
                r++;
            }
            if (ele == n) {
                ans = Math.min(ans, map.get(r - 1).first - map.get(l).first);
            } else {
                break;
            }
        }
        return ans;
    }
}
