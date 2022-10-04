import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "logudServlet", value = "/logudServlet")
public class logudServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        System.out.println("du ramte min get");
        log("bruger logger af");
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("WEB-INF/Bruger side.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
