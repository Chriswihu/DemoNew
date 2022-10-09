import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet
{
    Map<String, Konto> AdminMap = new TreeMap<>();

    public void init()
    {
        String sql = "select * from AdminKonto";

        Map<String, Konto> contextAdminMap = new TreeMap<>();
//        Konto u;
//
//
//        try (Connection con = ConnectionConfig.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ResultSet resultSet = ps.executeQuery();
//
//            while (resultSet.next()) {
//                Integer ID = resultSet.getInt("idAdminData");
//                String AdminName = resultSet.getString("AdminNavn");
//                String AdminKode = resultSet.getString("AdminKode");
//
//                u = new Konto(AdminName, AdminKode);
//
//                contextAdminMap.put(ID, u);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Konto admin1 = new Konto("chris", "3");

        contextAdminMap.put(admin1.getNavn(), admin1);

        getServletContext().setAttribute("contextAdminMap", contextAdminMap);
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setAttribute("sessionID", session.getId());
        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

        String loginBesked = "";

        String navn = request.getParameter("navn");
        String kode = request.getParameter("kode");

        Map<String , Konto> contextKontoMap = (Map<String, Konto>) getServletContext().getAttribute("contextKontoMap");

        if(!contextKontoMap.containsKey(navn)){
            loginBesked = "En Konto med det navn findes ikke, prøv igen";

            request.setAttribute("loginBesked", loginBesked);
            request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
        }
        session = request.getSession();

        session.setAttribute("sessionID", session.getId());
        request.getRequestDispatcher("WEB-INF/Admin side.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
