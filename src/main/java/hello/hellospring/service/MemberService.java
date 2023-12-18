package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     * @param member
     * @return
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 같은 이름이 있는지 찾는 메서드
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        // 같은 이름이 있는 중복 회원 X
        // ifPresent = null이 아니면 예외 처리 진행
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 멤버 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 단일 맴버 조회 진행
     * @param memberId
     * @return
     */
    public Optional<Member>  findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
