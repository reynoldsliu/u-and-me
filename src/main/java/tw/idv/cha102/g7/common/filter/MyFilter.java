package tw.idv.cha102.g7.common.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException{
        // TO DO the FILTER
        int httpStatus = response.getStatus();
        String httpMethod = request.getMethod();
        String uri = request.getRequestURI();
        String params = request.getQueryString();

        if (params != null) {
            uri += "?" + params;
        }

        System.out.println(String.join(" ", String.valueOf(httpStatus), httpMethod, uri));

    }
}
