class CompAssignOp {
    public static void main(String[] args) {
        short num = 10;
        num = (short)(num + 77L);
        int rate = 3;
        rate = (int)(rate * 3.5);

        num = 10;
        num += 77L; // 형 변환이 필요하지 않다. (short = short + long 꼴인데도 형 변환이 필요하지 않다.)
        rate = 3;
        rate *= 3.5; // 형 변환이 필요하지 않다. (int = int * float 꼴인데도 형 변환이 필요하지 않다.)
    }
}