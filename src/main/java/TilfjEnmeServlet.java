import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@WebServlet(name = "TilføjEnmeServlet", value = "/TilføjEnmeServlet")
public class TilfjEnmeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("det tilføjer et emne nu");

        HttpSession session = request.getSession();

        Set<String> emneListe = (Set<String>) session.getAttribute("emneListe");

        if (emneListe == null) {   // det vil ske første jeg kommer her forbi

            System.out.println("liste på session scopet fandtes ikke så den oprettes");

            emneListe = new TreeSet<>();

        }

        Set<String> emneListeReq = (Set<String>) request.getAttribute("emneListeReq");

        if (emneListeReq == null) {   // det vil ske første jeg kommer her forbi

            System.out.println("liste på request scopet fandtes ikke så den oprettes");

            emneListeReq = new TreeSet<>();

        }

        ServletContext httpContext = getServletContext();
//         Object stringSetContext = httpContext.getAttribute("stringSetContext");
        Set<String> stringSetContext = (Set<String>) httpContext.getAttribute("stringSetContext");

        if (stringSetContext == null) {

            stringSetContext = new TreeSet<>();

        }







        String emne = request.getParameter("enme");


        stringSetContext.add(emne);

        emneListe.add(emne);   // session

        emneListeReq.add(emne); // request





        httpContext.setAttribute("stringSetContext",stringSetContext);
        request.setAttribute("emneListeReq",emneListeReq);

        session.setAttribute("emneListe", emneListe);
        session.setAttribute("antal", emneListe.size());

        request.getRequestDispatcher("WEB-INF/Konto side.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
