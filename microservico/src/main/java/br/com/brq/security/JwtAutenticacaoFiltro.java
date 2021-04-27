package br.com.brq.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class JwtAutenticacaoFiltro extends UsernamePasswordAuthenticationFilter {

	/*pegando valor do application.properties*/
	@Value("${jwt.token_prefix}")
	private String token_prefix;	
	
	private AuthenticationManager authenticationManager;
    
    private JwtUtil jwtUtil;

    //contrutor
    public JwtAutenticacaoFiltro(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
    	setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }
	
    /*
     * Para verificar se o email e senha estão corretos
     * */
	@Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {

		
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
        		req.getAttribute("email"), req.getAttribute("senha"), new ArrayList<>()
        	);
        
        Authentication auth = authenticationManager.authenticate(authToken);
        return auth;
		
	}
	
	 /*
     * Se a autenticação deu certo, entra aqui
     * */
	@Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
	
		String username = ((CredencialSecurityModel) auth.getPrincipal()).getUsername();
		/*
		 * Se a autenticação deu certo, gera-se o token
		 * */
        String token = jwtUtil.generateToken(username);
        res.addHeader("Authorization", "Bearer " + token);
        res.addHeader("access-control-expose-headers", "Authorization");
	}
	
	/*Se a autenticação for inválida, sobrescrever o autenticação inválida*/
	private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {
		 
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
                throws IOException, ServletException {
            response.setStatus(401);
            response.setContentType("application/json"); 
            response.getWriter().append(json());
        }
        
        private String json() {
            long date = new Date().getTime();
            return "{\"timestamp\": " + date + ", "
                + "\"status\": 401, "
                + "\"error\": \"Não autorizado\", "
                + "\"message\": \"Email ou senha inválidos\", "
                + "\"path\": \"/login\"}";
        }
    }
}
