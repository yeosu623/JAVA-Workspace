class BankAccount {
    // 인스턴스 변수
    String accNumber; // 계좌번호
    String ssNumber; // 주민번호
    int balance = 0;

    // 인스턴스 메소드
    public int deposit(int amount) { // 입금
        balance += amount;
        return balance;
    }
    public int withdraw(int amount) { // 출금
        balance -= amount;
        return balance;
    }
    public int checkMyBalance() { // 예금 조회
        System.out.println("잔액 : " + balance);
        return balance;
    }

    /* 초기화를 위한 메서드
    public void initAccount(String acc, String ss, int bal) {
        accNumber = acc;
        ssNumber = ss;
        balance = bal;
    }
    */

    // 초기화 메소드를 대신하는 생성자
    // 생성자의 이름은 클래스의 이름과 동일해야 한다.
    public BankAccount() {

    }
}

class BankAccount00{
    public static void main(String[] args) {
        BankAccount yoon = new BankAccount();

        yoon.checkMyBalance();
    }
}