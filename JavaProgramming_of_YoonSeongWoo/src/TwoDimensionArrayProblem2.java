class TwoDimensionArrayProblem2 {
    public static void slideTwoDArr(int[][] arr) {
        int[] finalRowClone = arr[arr.length-1].clone();

        // Silde down array's row by a one.
        for(int i = arr.length-1; i > 0; i--)
            arr[i] = arr[i-1];
        arr[0] = finalRowClone;
    }

    public static void printTwoDArr(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class TwoDimensionArrayProblem2Main {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        TwoDimensionArrayProblem2.slideTwoDArr(a);
        TwoDimensionArrayProblem2.printTwoDArr(a);
    }
}