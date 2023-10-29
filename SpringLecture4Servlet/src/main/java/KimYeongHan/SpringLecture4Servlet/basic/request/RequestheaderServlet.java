package KimYeongHan.SpringLecture4Servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//http://localhost:8080/request-header?username=hello
public class RequestheaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        printStartLine(request);
//        printHeaders(request);
//        printHeaderUtils(request);
//        printEtc(request);

        response.getWriter().write("ok");
    }
}
