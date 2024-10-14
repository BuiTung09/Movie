
package dao;

import Model.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    public void insertMovie(Movie movie) throws Exception {
        Connection conn = DBContext.getConnection();
        String sql = "INSERT INTO Movie (mtitle, releaseddate, adultonly, cid) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, movie.getMtitle());
        ps.setDate(2, new java.sql.Date(movie.getReleasedDate().getTime()));
        ps.setBoolean(3, movie.isAdultOnly());
        ps.setInt(4, movie.getCid());
        ps.executeUpdate();
        conn.close();
    }
    
    public List<Movie> getAllMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "SELECT * FROM Movie";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Movie movie = new Movie();
            movie.setMid(rs.getInt("mid"));
            movie.setMtitle(rs.getString("mtitle"));
            movie.setReleasedDate(rs.getDate("releaseddate"));
            movie.setAdultOnly(rs.getBoolean("adultonly"));
            movie.setCid(rs.getInt("cid"));
            movies.add(movie);
        }
        conn.close();
        return movies;
    }

    
}
