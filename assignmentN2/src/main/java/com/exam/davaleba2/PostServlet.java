package com.exam.davaleba2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "postServlet", value = "/post-servlet")
public class PostServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String content = request.getParameter("content");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/data","root","");
            String sql = "INSERT INTO `posts` (`Title`, `Content`,`Author`) " +
                    "VALUES ('"+title+"', '"+content+"',  '"+author+"')";
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate(sql);
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (i > 0) {
                out.println("<h1>Post Added</h1>");
            } else {
                out.println("<h1>Post could not be added</h1>");
                out.println("</body></html>");
            }
            out.println("<a href=\"./index.jsp\">Add Post</a>");
            out.println("<br>");
            out.println("<a href=\""+request.getContextPath()+"/post-servlet\">Show Posts</a>");
            out.println("</body></html>");
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<a href=\"./index.jsp\">Add Post</a>");
        out.println("<br>");
        out.println("<table>\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th>Title</th>\n" +
                "      <th>Author</th>\n" +
                "      <th>Content</th>\n" +
                "      <th>Date</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/data","root","");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM `posts`");
            while ( rs.next() ) {
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                String content = rs.getString("Content");
                String date = rs.getString("Date");
                out.println("<tr>");
                out.println("<td>"+title+"</td>");
                out.println("<td>"+author+"</td>");
                out.println("<td>"+content+"</td>");
                out.println("<td>"+date+"</td>");
                out.println("<tr>");
            }
            con.close();
        } catch (Exception e) {}
        out.println("<table>");
        out.println("</body></html>");
    }
}
