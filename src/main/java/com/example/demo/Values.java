package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name ="values",urlPatterns = "/values",
        initParams = {
                @WebInitParam(name = "db-user",value = "root"),
                @WebInitParam(name = "db-pw",value = "1234"),
                @WebInitParam(name = "db-url",value = "jdbc:mysql://localhost:3306/mini?createDatabaseIfNotExist=true"),
                @WebInitParam(name = "db-class",value = "com.mysql.cj.jdbc.Driver")
        }
        ,loadOnStartup = 1
)
public class Values extends HttpServlet {
    Connection connection;

    String SAVE_DATA ="INSERT INTO customer (id,name,city,email) VALUES(?,?,?,?)" ;
    String GET_DATA ="SELECT * FROM customer WHERE id = ?" ;
    String UPDATE_DATA = "UPDATE customer SET name = ?, city = ?, email = ? WHERE id = ?";
    String DELETE_DATA = "DELETE from customer WHERE id = ?";

    @Override
    public void init() throws ServletException {

        try {
            String user =getServletConfig().getInitParameter("db-user");
            String password =getServletConfig().getInitParameter("db-pw");
            String url =getServletConfig().getInitParameter("db-url");
            Class.forName(getServletConfig().getInitParameter("db-class"));
            this.connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getHeader("First_Name");
        String lastName = req.getHeader("Last_Name");
        System.out.println("hi. "+firstName+" "+lastName+"!");
        var age = req.getParameter("age");
        System.out.println("Your age is:"+age);
    }

}
