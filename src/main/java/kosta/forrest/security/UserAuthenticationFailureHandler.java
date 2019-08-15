package kosta.forrest.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 스프링시큐리에서 로그인 실패시 호출되는 EventHandler임.
 * 
 *  springBean설정문서에서 <security:form-login태그에
 *  authentication-failure-handler-ref 추가하면
 *  로그인 실패시 onAuthenticationFailure 메소드가 자동 호출된다.
 * */
@Service //id="userAuthenticationFailureHandler"
public class UserAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException auth)
			throws IOException, ServletException {
		req.setAttribute("errorMessage", auth.getMessage());
		req.getRequestDispatcher("/WEB-INF/views/user/loginForm.jsp").forward(req, res);

	}
}





