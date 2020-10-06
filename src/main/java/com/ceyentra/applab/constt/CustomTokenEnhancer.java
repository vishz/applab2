package com.ceyentra.applab.constt;
import com.ceyentra.applab.entity.AuthUserDetails;
import com.ceyentra.applab.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;


@Component
@Log4j2
@RequiredArgsConstructor
public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    private final UserService userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();

        AuthUserDetails user = (AuthUserDetails) oAuth2Authentication.getPrincipal();

//        additionalInfo.put("user", new TokenUserDetails(
//                user.getId(), user.getUsername(), user.getRole().name(),
//                user.getRole() == ROLE_DEALER && user.getLocationUpdated() ==1,
//                user.getPrivileges().stream().map(Privilege::getName).collect(toList())));

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);

        return super.enhance(oAuth2AccessToken, oAuth2Authentication);
    }
}
