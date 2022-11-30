package gruppe_12_backend.rest_api_12.config;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.utils.TokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptorConfig implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().equals("/api/users/current")) {
            String token = request.getHeader("Authorization");
            if (token != null) {
                User user = TokenUtils.validateToken(token);
                if (user != null) {
                    request.setAttribute("username", user.getUsername());
                    return true;
                }
            }

            // If the authentication failed
            response.setStatus(401);
            return false;
        }

        return true;
    }
}
