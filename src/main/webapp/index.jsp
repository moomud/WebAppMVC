<%@page import="mud.controller.InsertData"%>
<%@page import="mud.model.GetData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <link rel="stylesheet" href="Styindex.css">
        <h1>Welcome</h1>
        
        <%
            if (request.getParameter("txtfname") != null)
            {
                String id = request.getParameter("txtid");
                String fname = request.getParameter("txtfname");
                String lname = request.getParameter("txtlname");
                String email = request.getParameter("txtemail");
                String phone= request.getParameter("txtphone");
                String salary= request.getParameter("txtsalary");
                
               InsertData ins = new InsertData();
             ins.Insert(id,fname,lname,email,phone, Double.parseDouble(salary) );
                
                 
            }
            
            %>
            
        <label id="lasearch">Search</label> 
        <input id="inputsearch">
        <select id="sesearch">
            <option>name</option>
            <option>email</option>
            <option>phone</option>
            <option>salary</option>
        </select>
        <button id="btnsearch">Search</button>
        <form method="post" action="Newinsert.jsp"> 
            <button id="btninsert">Insert</button>
        </form>
        
        <button id="btnupdate">Update</button>
        <button id="btndelete">Delete</button>
        
        <%
        GetData gd = new GetData();
        gd.RunData();
        %>
        
        <table>
            <thead>
                <tr>
                    <td id="cno">no.</td>
                    <td id="cid">employee id</td>
                    <td id="cfname">first name</td>
                    <td id="clname">last name</td>
                    <td id="cemail">email</td>
                    <td id="cphone">phone number</td>
                    <td id="csalary">salary</td>
                    <td id="cshow">show data</td>
                </tr>
            </thead>
            <tbody>
                <%
                for(int i = 0 ; i < gd.getId().size() ; i++){
                    
                    %>
                <tr>
                    <td><%=(i+1)+"" %></td>
                    <td><%=gd.getId().get(i) %></td>
                    <td><%=gd.getFname().get(i) %></td>
                    <td><%=gd.getLname().get(i) %></td>
                    <td><%=gd.getEmail().get(i) %></td>
                    <td><%=gd.getPhone().get(i) %></td>
                    <td><%=gd.getSalary().get(i) %></td>
                    <td>ope</td>
                <tr/>
                <%
                }
                %>
            </tbody>
        </table>
        
        
    </body>
</html>
