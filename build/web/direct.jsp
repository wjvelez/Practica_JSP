<%@page import="java.util.LinkedList"%>
<%@page import="controladores.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8" 
    import = 'java.sql.*' 
%>

<% 
    Connection conex = null;
    Statement sql = null;
    String db_name = "prueba";
    String db_usuario = "root";
    String db_pass = "julian";
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conex = (Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + db_name , db_usuario , db_pass );
        sql=conex.createStatement();
        ResultSet rs = sql.executeQuery("select * from usuarios" );
        LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
        while ( rs.next() )
         {
            Usuario rs_user = new Usuario();
            rs_user.setIdusuario( rs.getInt("id") );
            out.print("Id: " + rs_user.getIdusuario() + "<br>");
            
            rs_user.setNombreusuario( rs.getString("nombre") );
            out.print("Nombre: " + rs_user.getNombreusuario() + "<br>");
            
            rs_user.setEmailusuario( rs.getString("email") );
            out.print("Email: "+rs_user.getEmailusuario()+"<br>");
            
            rs_user.setRolusuario( rs.getString("rol") );
            out.print("Rol: "+rs_user.getRolusuario()+"<br>");
            
            listaUsuarios.add(rs_user);
         }
         rs.close();
         sql.close();
    }
    catch(Exception e){
        out.print("ERROR EN LA CONEXION");
    };
    
%>

<%
    
%>

