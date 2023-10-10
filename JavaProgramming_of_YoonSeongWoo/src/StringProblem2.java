class StringProblem2 {
    public static void main(String[] args) {
        StringBuilder stb = new StringBuilder("990925-1012999");

        stb.replace(6, 7, " ");

        String str = stb.toString();
        System.out.println("Converted Result : " + str);
    }
}