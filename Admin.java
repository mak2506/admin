String id=request.getParameter("id");
		String pass=request.getParameter("password");
		//System.out.println(id+" "+pass);
		
		Connection con=DBConnection.createConnection();//error
		
		String strsql="select * from admin where admin_id=? and admin_password=?";//error
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(strsql);
			ps.setString(1, id);
			ps.setString(2, pass);
			 rs=ps.executeQuery();
			// System.out.println("Done");				
			if(rs.next())
			{
				HttpSession hs=request.getSession();//this will create a session
				hs.setAttribute("admin", id);
				response.sendRedirect("/buko/admin/adminhome.jsp");
			}
			else { 
			  response.sendRedirect("/buko/Admin"); 
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
