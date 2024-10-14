package Controller;

import dao.CategoryDAO;
import dao.MovieDAO;
import Model.Category;
import Model.Movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/movie/create")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> categories = categoryDAO.getAllCategories();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/view/movie_create.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String releasedDate = request.getParameter("releaseddate");
            boolean adultOnly = request.getParameter("adultonly") != null;
            int cid = Integer.parseInt(request.getParameter("category"));

            Movie movie = new Movie();
            movie.setMtitle(title);
            movie.setReleasedDate((Date) new SimpleDateFormat("yyyy-MM-dd").parse(releasedDate));
            movie.setAdultOnly(adultOnly);
            movie.setCid(cid);

            MovieDAO movieDAO = new MovieDAO();
            movieDAO.insertMovie(movie);
            
            response.sendRedirect("movie_list.jsp"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
