class TwoDimensionArrayProblem1 {
    public static void addOneDArr(int[] arr, int add) {
        for(int i = 0; i < arr.length; i++)
            arr[i] += add;
    }

    public static void addTwoDArr(int[][] arr, int add) {
        for(int i = 0; i < arr.length; i++)
            addOneDArr(arr[i], add);
    }
}

class TwoDimensionArrayProblem1Main {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        TwoDimensionArrayProblem1.addTwoDArr(a, 3);

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}