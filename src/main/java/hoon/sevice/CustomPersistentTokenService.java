package hoon.sevice;

import hoon.dao.persistent.PersistentRepository;
import hoon.error.errorCode.MemberErrorCode;
import hoon.error.exception.MemberException;
import hoon.model.entity.PersistentLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CustomPersistentTokenService implements PersistentTokenRepository {

    @Autowired
    PersistentRepository persistentRepository;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        PersistentLoginToken myToken = new PersistentLoginToken();
        myToken.setSeries(token.getSeries());
        myToken.setId(token.getUsername());
        myToken.setToken(token.getTokenValue());
        myToken.setLastused(token.getDate());

        persistentRepository.save(myToken);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        PersistentLoginToken token = persistentRepository.findBySeries(series);
        if (token != null) {
            token.setToken(tokenValue);
            token.setLastused(lastUsed);
            persistentRepository.save(token);
        }
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        PersistentLoginToken myToken = persistentRepository.findBySeries(seriesId);
        if (myToken == null) {
//            throw new MemberException(MemberErrorCode.NOT_FOUND_MEMBER);
            return null;
        }

        return new PersistentRememberMeToken(myToken.getId(), myToken.getSeries(), myToken.getToken(), myToken.getLastused());
    }

    @Override
    public void removeUserTokens(String username) {
        List<PersistentLoginToken> myTokens = persistentRepository.findById(username);
        persistentRepository.delete(myTokens);
    }

    private void dd(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("login");
    }
}
