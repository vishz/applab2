package com.ceyentra.applab.constt;

public class OAuth2TokenConstants {

    /**
     * OAuth2TokenConstant for token generating purpose
     */

    public static final String CLIENT_ID = "user";
    public static final String CLIENT_SECRET = "pass";
    public static final String GRANT_TYPE_PASSWORD = "password";
    public static final String AUTHORIZATION_CODE = "authorization_code";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String IMPLICIT = "implicit";
    public static final String SCOPE_READ = "read";
    public static final String SCOPE_WRITE = "write";
    public static final String TRUST = "trust";
    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 60 * 60;
    public static final int REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30 * 3;
    public static final String TOKEN_SIGN_IN_KEY = "x+CTL*E4$D8Sp@CC";


}
