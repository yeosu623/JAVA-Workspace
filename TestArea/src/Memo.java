public class MemberService {
    // 다형성이란 속성을 이용하게 되면, 이렇게 하나의 참조변수에 원하는 객체를 생성하여 연결할 수 있다.

    //private MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository = new JdbcMemberRepository();
}