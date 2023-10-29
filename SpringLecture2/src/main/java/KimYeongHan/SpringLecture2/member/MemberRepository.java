package KimYeongHan.SpringLecture2.member;


public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
