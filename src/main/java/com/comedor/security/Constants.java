package com.comedor.security;

public class Constants {
	// Spring Security
	public static final String LOGIN_URL = "/login";
	public static final String REGISTER_URL = "/registro";
	public static final String PLATOS_URL = "/api/platos";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT
	public static final String ISSUER_INFO = "Comedor App";
	public static final String SUPER_SECRET_KEY = "1234";
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
}
