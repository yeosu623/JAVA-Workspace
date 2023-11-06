package KimYeongHan.SpringLecture4Servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // data
        Member member = new Member("hello", 20);

        // process
        Member savedMember = memberRepository.save(member);

        // test
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        // data
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        // process
        List<Member> result = memberRepository.findAll();

        // test
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1, member2);
    }
}
