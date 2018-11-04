package hoon.config.handler;

import hoon.model.entity.Member;
import hoon.model.enums.OauthType;
import hoon.model.wrappper.OauthIDAndName;
import hoon.sevice.MemberService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class OAuthSuccessHandler implements AuthenticationSuccessHandler {

    private final OauthType type;
    private final MemberService memberService;

    public OAuthSuccessHandler(OauthType type, MemberService memberService) {
        this.type = type;
        this.memberService = memberService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Member member = memberService.getMemberByOauthTypeAndId(type, authentication.getName());
        List<GrantedAuthority> grants = null;

        if (member == null) {
            // NOTE #9 지금은 멤버를 임시로 만들어 주지만, 회원가입 페이지로 redirect 할 수도 있다.
            member = makeNewMemberByType(authentication, type);
        } else {
            grants = member.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        }

        if (grants == null || grants.isEmpty()) {
            grants = createDefaultPermissions();
        }
        // NOTE #9 UsernamePasswordAuthenticationToken으로 통일을 시켜줬을 뿐 꼭 해당 클래스가 되어야 하진 않는다.
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(new User(member.getId(), member.getPassword(), grants), null, grants));
        response.sendRedirect("/main");
    }

    private List<GrantedAuthority> createDefaultPermissions() {
        // TODO 권한 부여 처리(mapping table insert...)
        return Collections.singletonList(new SimpleGrantedAuthority("ADMIN"));
    }

    private Member makeNewMemberByType(Authentication authentication, OauthType type) {
        Member member;
        member = new Member();
        member.setPassword(UUID.randomUUID().toString());
        member.setOauthType(type);

        OauthIDAndName oauthIDAndName = getOauthIDAndNameByType(authentication, type);
        member.setId(oauthIDAndName.getName());
        member.setOauthId(oauthIDAndName.getId());

        return memberService.saveSomethingMember(member);
    }

    private OauthIDAndName getOauthIDAndNameByType(Authentication authentication, OauthType type) {
        OauthIDAndName oauthIDAndName = new OauthIDAndName();

        Map details = (Map) ((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
        switch (type) {
            case GOOGLE:
                oauthIDAndName.setId(authentication.getName());
                oauthIDAndName.setName(details.get("email").toString());
                break;
            case NAVER:
                Map detailsByNaver = (Map) details.get("response");
                oauthIDAndName.setId(detailsByNaver.get("id").toString());
                oauthIDAndName.setName(detailsByNaver.get("nickname").toString());
        }

        return oauthIDAndName;
    }
}
