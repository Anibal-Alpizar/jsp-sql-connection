<%-- 
    Document   : validate
    Created on : Nov 15, 2022, 10:18:18 PM
    Author     : anibal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>

<%
    try{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=DB_EJEMPLO_SERVLET", "sa", "123456");
        PreparedStatement pst = conn.prepareStatement("select * from usuarios where USUARIO=? and PASS=?");
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        if(rs.next())
            out.println("Login Success");
        else
            out.println("Login Failed");       
    }catch(Exception e){
        out.println(e);
        out.println("Something went wrong || Please try again");
    }
%>