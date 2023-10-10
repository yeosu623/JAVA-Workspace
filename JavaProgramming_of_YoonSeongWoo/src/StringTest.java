class StringTest {
    public static void main(String[] args) {
        String str1 = "Simple String";
        String str2 = "Simple String";

        System.out.println("Str1 hashcode = " + str1.hashCode());
        System.out.println("Str2 hashcode = " + str2.hashCode() + "\n");

        str1 = "Different String";

        System.out.println("Str1 hashcode = " + str1.hashCode());
        System.out.println("Str2 hashcode = " + str2.hashCode());

        String str3 = "Simple String";
        System.out.println("Str3 hashcode = " + str3.hashCode());
    }
}