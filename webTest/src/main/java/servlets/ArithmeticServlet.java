package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content="""
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="arithmetic" method="post">
	A = <input type="text" name="a"> </br>
	B = <input type="text" name="b"> </br>
	<input type="submit" name="operation" value="Add"/>
	<input type="submit" name="operation" value="Sub"/>
	<input type="submit" name="operation" value="Mul"/>
	<input type="submit" name="operation" value="Div"/>
</form>
</body>
</html>
				
				
				""";
		resp.getWriter().print(content);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer a = Integer.parseInt(req.getParameter("a"));
		Integer b = Integer.parseInt(req.getParameter("b"));
		
		String operation = req.getParameter("operation");
		// call business logic , not write business logic
		
		int result= 0;
		if("Add".equals(operation)) {
			result = a+b;
		}else if("Sub".equals(operation)) {
			result= a-b;
		}else if("Mul".equals(operation)) {
			result = a*b;
		}else{
			result = a/b;
		}
		//PrintWriter out = req.getWriter();
		System.out.println(MessageFormat.format("A= {0} {1} B = {2} = {3} ",a,operation,b,result));
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("arithmetic.jsp").forward(req, resp);
		
		
		
		
//		String content = """
//				
//<!DOCTYPE html>
//<html>
//<head>
//<meta charset="UTF-8">
//<title>Insert title here</title>
//</head>
//<body>
//A = {0}</br>
//B = {1}</br>
//Operation = {2}</br>
//Result = {3}</br>
//<form action="arithmetic" method="post">
//	A = <input type="text" name="a"> </br>
//	B = <input type="text" name="b"> </br>
//	<input type="submit" name="operation" value="Add"/>
//	<input type="submit" name="operation" value="Sub"/>
//	<input type="submit" name="operation" value="Mul"/>
//	<input type="submit" name="operation" value="Div"/>
//</form>
//</body>
//</html>
//				""";
//		PrintWriter out = resp.getWriter();
//		out.print(MessageFormat.format(content, a,b,operation,result));
//		
	}
}
