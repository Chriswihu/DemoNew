import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet
{


    Map<String, Bruger> brugerMap = new TreeMap<>();

    public void init()
    {
//        ServletContext servletContext = getServletContext();

        Map<String, Bruger> contextBrugerMap = new TreeMap<>();

        Bruger bruger1 = new Bruger("nik", "1");
        Bruger bruger2 = new Bruger("palle", "1");

        contextBrugerMap.put(bruger1.getNavn(), bruger1);
        contextBrugerMap.put(bruger1.getNavn(), bruger1);

        getServletContext().setAttribute("contextBrugerMap", contextBrugerMap);

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        //System.out.println("du ramte login servletten via Get" );

        String loginBesked ="";

        String navn = request.getParameter("navn");
        String kode = request.getParameter("kode");

        Map<String , Bruger> contextBrugerMap = (Map<String, Bruger>) getServletContext().getAttribute("contextBrugerMap");

        if (!contextBrugerMap.containsKey(navn)) {

            loginBesked = "En bruger med det navn findes ikke, prøv igen eller gå til opret";

            request.setAttribute("loginBesked",loginBesked );
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        if (!contextBrugerMap.get(navn).getKode().equals(kode)  ) {

            loginBesked = "Koden er forkert, prøv igen";

            request.setAttribute("loginBesked",loginBesked );
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        // alt er gået fint

        HttpSession session = request.getSession();


        session.setAttribute("sessionId", session.getId());
        request.getRequestDispatcher("WEB-INF/Bruger side.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Map<String, Bruger> contextBrugerMap = (Map<String, Bruger>) getServletContext().getAttribute("contextBrugerMap");

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

        if (contextBrugerMap.containsKey(opretNavn)) {

            besked = "en bruger med det navn findes allerede, prøv igen";
            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        contextBrugerMap.put(opretNavn, new Bruger(opretNavn, kode1));

        getServletContext().setAttribute("contextBrugerMap", contextBrugerMap);

        HttpSession session = request.getSession();

        session.setAttribute("sessionId", session.getId());
        request.setAttribute("navn", opretNavn);

        request.getRequestDispatcher("WEB-INF/Bruger side.jsp").forward(request, response);


    }
}
