class ArrayHasReferenceValue {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7};
        int sum = sumOfAry(ar);
    }

    // 배열의 참조값을 매개변수로 입력할 수 있다.
    static int sumOfAry(int[] ar) {
        int sum = 0;
        for(int i = 0; i < ar.length; i++)
            sum += ar[i];
        return sum;
    }

    // 배열의 참조값을 반환할 수도 있다.
    static int[] makeNewIntAry(int len) {
        int[] ar = new int[len];
        return ar;
    }
}