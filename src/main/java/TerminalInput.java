
import java.sql.Date;
import java.util.Scanner;

public class TerminalInput {
    public static String getString(String s)
    {
        System.out.println(s);
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();

    }

    public static int getInt(String s)
    {
        while (true) {
            try {
                int ans = Integer.parseInt(getString(s));
                return ans;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }

    public static Date getDate(String s)
    {
        while (true) {
            try {
                Date ans = Date.valueOf(getString(s));
                return ans;
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong input");
            }
        }
    }
}