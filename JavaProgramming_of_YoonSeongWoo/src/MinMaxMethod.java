class MinMaxMethod {
    public static int minValue(int[] arr) {
        int min = arr[0]; // 초기화

        for(int i = 0; i < arr.length; i++) {
            if(min > arr[i]) { min = arr[i]; }
        }

        return min;
    }

    public static int maxValue(int[] arr) {
        int max = arr[0];

        for(int e : arr) {
            if(max < e) { max = e; }
        }

        return max;
    }
}

class MinMaxMethodMain {
    public static void main(String[] args) {
        int[] a = {3, 7, 10, 5, 2};

        int min = MinMaxMethod.minValue(a);
        int max = MinMaxMethod.maxValue(a);

        System.out.println("배열의 최소값 : " + min);
        System.out.println("배열의 최대값 : " + max);
    }
}