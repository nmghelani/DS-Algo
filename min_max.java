public class min_max {
    static class Pair {
        int min, max;

        public Pair() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 46, 2355, 47, 3, 453, 645, 23, 34 };
        Pair pair = getMinMax(arr);
        System.out.println("Min: " + pair.min + " MAX: " + pair.max);
    }

    static Pair getMinMax(int[] arr) {
        Pair pair = new Pair();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pair.min) {
                pair.min = arr[i];
            }
            if (arr[i] > pair.max) {
                pair.max = arr[i];
            }
        }
        return pair;
    }
}
