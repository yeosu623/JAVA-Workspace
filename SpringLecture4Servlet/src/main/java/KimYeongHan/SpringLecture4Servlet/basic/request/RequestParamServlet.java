package KimYeongHan.SpringLecture4Servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 * 2. 동일한 파라미터 전송 가능
 * http://localhost:8080/request-param?username=hello&username=kim&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        /*
        String username = request.getParameter("username"); // 단일 파라미터 조회
        Enumeration<String> parameterNames = request.getParameterNames(); // 파라미터 이름들 모두 조회
        Map<String, String[]> parameterMap = request.getParameterMap(); // 파라미터를 Map으로 조히
        String[] usernames = request.getParameterValues("username"); // 복수 파라미터 조회
         */
    }
}
