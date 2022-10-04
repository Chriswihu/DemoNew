import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet
{
    Map<String, Brugere> brugereMap = new TreeMap<>();


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
            besked = "huske alle felter skal udfyldes, prøv igen";

            System.out.println("opret bruger ikke udfyldt korrekt");
           // log("opret bruger ikke udfyldt korrekt");

            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        if (!kode1.equals(kode2)) {

            besked = "den angivende koder  er forskellige, prøv igen";

            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        request.setAttribute("navn", opretNavn);

        request.getRequestDispatcher("WEB-INF/Bruger side.jsp").forward(request, response);



    }
}
