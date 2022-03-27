//String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");		
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		System.out.println(name);
		System.out.println(password);
		System.out.println(email);
		System.out.println(gender);
		System.out.println(phone);
		
		Connection con=DBConnection.createConnection();
		String strinsert="insert into uploader (name, password, email, gender, phonenumber, date) values (?,?,?,?,?,?)";
		 java.util.Date d=new java.util.Date();
		 java.sql.Date sql_date=new java.sql.Date(d.getTime());//fr system print date
		 PreparedStatement ps=null;
		 try {	
			 ps=con.prepareStatement(strinsert);
			 //ps.setString(1,id);
			 ps.setString(1,name);
			 ps.setString(2,password);
			 ps.setString(3,email);
			 ps.setString(4,gender);
			 ps.setString(5,phone);
			 ps.setDate(6, sql_date);
			 System.out.println(ps);
			 int status=ps.executeUpdate();//error
			 if(status>0)
				 	System.out.println("uploader login sucessfully done");			 
		 	}
		 	catch(SQLException se)
		 	{
			 se.printStackTrace();
		 	}
		 	finally {
			 try {
				 if(ps!=null)
					 ps.close();
				 
			 }
			 catch(SQLException se)
			 {
				 se.printStackTrace();
				 
			 }
			 
		 }
