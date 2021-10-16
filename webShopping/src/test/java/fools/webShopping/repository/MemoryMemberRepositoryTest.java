package fools.webShopping.repository;

import fools.webShopping.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setId("spring");

        repository.save(member);

        Member result = repository.findByCount(member.getCount()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setId("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("spring2");
        repository.save(member2);

        Member result = repository.findById("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setId("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setId("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);


    }
}
