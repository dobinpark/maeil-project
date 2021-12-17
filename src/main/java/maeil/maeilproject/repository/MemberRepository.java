package maeil.maeilproject.repository;

import maeil.maeilproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email); //중복된 회원 검사를 위한 쿼리문
}
