package filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class authenticationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
            IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;

        HttpSession session = httpRequest.getSession();

        if(session.getAttribute("loginUser")==null) {
            ((HttpServletResponse) response).sendRedirect("../pages/login.jsp");
        }

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }

}
