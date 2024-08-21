package uwaayezu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class numbers
 */
@WebServlet("/allow_user_enter_quadratic_equation")
public class allow_user_enter_quadratic_equation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allow_user_enter_quadratic_equation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));

        double discriminant = b * b - 4 * a * c;
        String result;

        if (a == 0) {
            result = "Coefficient 'a' cannot be zero.";
        } else if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            result = "Roots are: " + root1 + " and " + root2;
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            result = "Root is: " + root;
        } else {
            result = "The equation has no real roots.";
        }
        response.setContentType("text/html");
        //yes
        response.getWriter().println("<html><style type=\"text/css\">\r\n"
        		+ "body{\r\n"
        		+ " 		text-align: flex;\r\n"
        		+ " 		color: white;\r\n"
        		+ " 		justify-content:center;	 \r\n"
        		+ " 		margin-left:300px;\r\n"
        		+ " 		background: black;\r\n"
        		+ " 		min-height:100vh;\r\n"
        		+ " 		flex-direction:column;\r\n"
        		+ " 		gap:30px;\r\n"
        		+ "\r\n"
        		+ " 	}</style><body>");
        
         response.getWriter().println("<h2>Results</h2>");
         response.getWriter().println("Equation:"+a+"x<sup>2</sup>+"+b+"x+"+c+"=0");
        response.getWriter().println("<p>" + result + "</p><br><hr>			");
        response.getWriter().println("<a href='number.html'>Exit</a>");
        response.getWriter().println("</body></html>");

	}

}
