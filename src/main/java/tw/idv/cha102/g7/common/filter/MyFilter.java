package tw.idv.cha102.g7.common.filter;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        // TO DO the FILTER

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);


//        logAPI(request, response);
//        logBody(requestWrapper, responseWrapper);
//
//        responseWrapper.copyBodyToResponse();

        String contextPath = request.getContextPath();
        String requestUrl = request.getRequestURI().replace(contextPath,"");
        String loginFuncStr = "/u-and-me/tmp/Front/member/memberLoginIn.html";
        String login = "/member/login";



        if(loginFuncStr.equals(requestUrl)||login.equals(requestUrl)){
            chain.doFilter(request,response);
            return;
        }

        HttpSession session = request.getSession();
        Integer memId = (Integer)(session.getAttribute("memId"));
        if(memId==null){
            response.sendRedirect(contextPath + loginFuncStr);
            return ;
        }

        chain.doFilter(requestWrapper, responseWrapper);
        responseWrapper.copyBodyToResponse();
    }

    private void logAPI(HttpServletRequest request, HttpServletResponse response) {
        // 先前打印 API 的程式
        int httpStatus = response.getStatus();
        String httpMethod = request.getMethod();
        String uri = request.getRequestURI();
        String params = request.getQueryString();

        if (params != null) {
            uri += "?" + params;
        }

        System.out.println(String.join(" ", String.valueOf(httpStatus), httpMethod, uri));
    }

    private void logBody(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response) {
        String requestBody = getContent(request.getContentAsByteArray());
        System.out.println("Request: " + requestBody);

        String responseBody = getContent(response.getContentAsByteArray());
        System.out.println("Response: " + responseBody);
    }

    private String getContent(byte[] content) {
        String body = new String(content);
        return body.replaceAll("[\n\t]", "");
    }
}
