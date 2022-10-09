import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet
{
    Map<String, Konto> KontoMap = new TreeMap<>();

    public void init()
    {
//        ServletContext servletContext = getServletContext();

        Map<String, Konto> contextKontoMap = new TreeMap<>();

        Konto Konto1 = new Konto("nik", "1");
        Konto Konto2 = new Konto("palle", "1");

        contextKontoMap.put(Konto1.getNavn(), Konto1);
        contextKontoMap.put(Konto1.getNavn(), Konto2);

        getServletContext().setAttribute("contextKontoMap", contextKontoMap);

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        //System.out.println("du ramte login servletten via Get" );

        String loginBesked ="";

        String navn = request.getParameter("navn");
        String kode = request.getParameter("kode");

        Map<String , Konto> contextKontoMap = (Map<String, Konto>) getServletContext().getAttribute("contextKontoMap");

        if (!contextKontoMap.containsKey(navn)) {

            loginBesked = "En Konto med det navn findes ikke, prøv igen eller gå til opret";

            request.setAttribute("loginBesked",loginBesked );
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        if (!contextKontoMap.get(navn).getKode().equals(kode)  ) {

            loginBesked = "Koden er forkert, prøv igen";

            request.setAttribute("loginBesked",loginBesked );
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        // alt er gået fint

        HttpSession session = request.getSession();

        session.setAttribute("sessionId", session.getId());
        request.getRequestDispatcher("WEB-INF/Konto side.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Map<String, Konto> contextKontoMap = (Map<String, Konto>) getServletContext().getAttribute("contextKontoMap");

        System.out.println("du ramte login servletten via Post");


        String opretNavn = request.getParameter("OpretNavn");
        String kode1 = request.getParameter("kode1");
        String kode2 = request.getParameter("kode2");

        String besked ="";

        if (opretNavn.equals("") || kode1.equals("") || kode2.equals("") ) {
            besked = "huske alle felter skal udfyldes, prøv igen";

            System.out.println("opret Konto ikke udfyldt korrekt");
           // log("opret Konto ikke udfyldt korrekt");

            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        if (!kode1.equals(kode2)) {

            besked = "den angivende koder  er forskellige, prøv igen";

            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        if (contextKontoMap.containsKey(opretNavn)) {

            besked = "en Konto med det navn findes allerede, prøv igen";
            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        contextKontoMap.put(opretNavn, new Konto(opretNavn, kode1));

        getServletContext().setAttribute("contextKontoMap", contextKontoMap);

        HttpSession session = request.getSession();

        session.setAttribute("sessionId", session.getId());
        request.setAttribute("navn", opretNavn);

        request.getRequestDispatcher("WEB-INF/Konto side.jsp").forward(request, response);


    }
}
