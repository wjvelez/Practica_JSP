<%@page import="java.sql.*"%>

<%
   String role = request.getParameter("q");
   String n = request.getParameter("n");
   String e = request.getParameter("e");
   
    Connection conex = null;
    Connection conex2 = null;
    Statement sql = null;
    Statement sql2 = null;
    String db_name = "prueba";
    String db_usuario = "root";
    String db_pass = "julian";
   
   try {
        Class.forName("com.mysql.jdbc.Driver");
        conex = (Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + db_name , db_usuario , db_pass );
        conex2 = (Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + db_name , db_usuario , db_pass );
        sql = conex.createStatement();
        sql2 = conex2.createStatement(); // Para consultar primero y obtener el id siguiente
        ResultSet rs = sql2.executeQuery("select * from usuarios");
        
        int size = 0;
        if (rs != null){  
          rs.beforeFirst();  
          rs.last();  
          size = rs.getRow();  
        }
        
        sql.executeUpdate("INSERT INTO usuarios VALUES (" +(size+1)+ ",'" +n+"','" +e+ "','" +role+ "');");
        
        out.print("Conexion Establecida");
        
        conex.close();
        
   } catch (Exception ex) {
        ex.printStackTrace();
   }
%>
