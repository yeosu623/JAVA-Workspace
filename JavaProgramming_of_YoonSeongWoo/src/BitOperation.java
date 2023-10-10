class BitOperation {
    public static void main(String[] args) {
        int num = 5;
        System.out.print((num++) + " ");
        System.out.print((num++) + " ");
        System.out.print(num + '\n' + " "); //왜 '\n'안되지??

        System.out.print((num--) + " ");
        System.out.print((num--) + " ");
        System.out.print(num);
    }
}