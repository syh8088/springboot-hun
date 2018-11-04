package hoon.config.handler;

import hoon.dao.member.MemberRepository;
import hoon.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// NOTE #8 어디서 유저 정보를 가져올까?
@Component
public class UserServiceHandler implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Autowired
    public UserServiceHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.getMemberById(username);

        if (member == null) {
            throw new UsernameNotFoundException("unsername not found");
        }

        List<GrantedAuthority> grants = member.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

        // NOTE #8 User를 사용하고 싶지 않다면 Member가 UserDetail을 상속 받아도 됨
        return new User(member.getId(), member.getPassword(), grants);
    }
}
