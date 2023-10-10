import java.util.Optional;

class Friend { // 친구 정보
    String name;
    Company cmp; // null 일 수 있음

    public Friend(String n, Company c) {
        name = n;
        cmp = c;
    }
    public String getName() { return name; }
    public Company getCmp() { return cmp; }
}

class Company { // '친구 정보'에 속하는 '회사 정보'
    String cName;
    ContInfo cInfo; // null 일 수 있음

    public Company(String cn, ContInfo ci) {
        cName = cn;
        cInfo = ci;
    }
    public String getCName() { return cName; }
    public ContInfo getCInfo() { return cInfo; }
}

class ContInfo { // '회사 정보'에 속하는 '회사 연락처'
    String phone; // null 일 수 있음
    String adrs; // null 일 수 있음

    public ContInfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }
    public String getPhone() { return phone; }
    public String getAdrs() { return adrs; }
}

class ContInfoMain {
    public static void main(String[] args) {
        Optional<ContInfo> ci = Optional.of(new ContInfo(null, "Republic of Korea"));

        String phone = ci.map(c -> c.getPhone())
                         .orElse("There is no phone number.");
        String addr = ci.map(c -> c.getAdrs())
                        .orElse("There is no address.");

        System.out.println(phone);
        System.out.println(addr);
    }
}
