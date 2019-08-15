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
 * ��������ť������ �α��� ���н� ȣ��Ǵ� EventHandler��.
 * 
 *  springBean������������ <security:form-login�±׿�
 *  authentication-failure-handler-ref �߰��ϸ�
 *  �α��� ���н� onAuthenticationFailure �޼ҵ尡 �ڵ� ȣ��ȴ�.
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





