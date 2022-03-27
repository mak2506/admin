String email=request.getParameter("email");//user id is control name text box
		String pass=request.getParameter("password");
		//System.out.print(email);
		//System.out.print(pass);
		
		Connection con=DBConnection.createConnection();
		String strsql="select * from uploader where email=? and password=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(strsql);
			ps.setString(1, email);
			ps.setString(2, pass);
			//System.out.print(ps);
			 rs=ps.executeQuery();
			if(rs.next())
			{
				//System.out.println("Hello");
				HttpSession hs=request.getSession();//this will create a session
				hs.setAttribute("userkey", email);
				System.out.println("Unique session id is: "+hs.getId());//getId will return the token or session id
				response.sendRedirect("/buko/uploader/uploaderhome.jsp");
			}
			else
			{
				//System.out.println(Message.LOGIN_ERROR_MESSAGE);
				request.setAttribute("message", Message.LOGIN_ERROR_MESSAGE);
				RequestDispatcher rd=request.getRequestDispatcher("/uploader/uploaderlogin.jsp");
				rd.forward(request, response);
				//response.sendRedirect("/buko/uploader/uploaderlogin.jsp");
				
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	
	finally {
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}	
