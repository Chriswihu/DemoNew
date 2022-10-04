import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        System.out.println("du ramte login servletten via Get");


        request.getRequestDispatcher("WEB-INF/Bruger side.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        System.out.println("du ramte login servletten via Post");


        String opretNavn = request.getParameter("OpretNavn");
        String kode1 = request.getParameter("kode1");
        String kode2 = request.getParameter("kode2");

        String besked ="";

        if (opretNavn.equals("") || kode1.equals("") || kode2.equals("") ) {
            besked = "huske alle felter skal udfyldes";

            System.out.println("opret bruger ikke udfyldt korrekt");
           // log("opret bruger ikke udfyldt korrekt");

            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request,response);


        }



        request.getRequestDispatcher("WEB-INF/Bruger side.jsp").forward(request, response);



    }
}
