class CharTypeUnicode {
    public static void main(String[] args) {
        // char는 '부호없는 short 자료형'을 의미한다. (java에서는 부호없는 자료형을 명시적으로 표현할수는 없다.)
        // char는 Unicode를 저장하는데 사용될 수 있다. (한글, 영어 등을 전부 char 타입에 저장해서 사용한다.)
        char ch1 = '헐';
        char ch2 = '확';
        char ch3 = 54736;
        char ch4 = 54869;
        char ch5 = 0xD5D0;
        char ch6 = 0xD655;
        System.out.println(ch1 + " " + ch2);
        System.out.println(ch3 + " " + ch4);
        System.out.println(ch5 + " " + ch6);
    }
}