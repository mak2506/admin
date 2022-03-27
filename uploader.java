String uid=request.getParameter("user_id");
		String bid=request.getParameter("book_id");
		String price=request.getParameter("price");
		String filename=request.getParameter("filename");
		System.out.println(price+" "+uid+" "+bid+" "+filename);
		Connection con=DBConnection.createConnection();
		String strinsert="insert into orders (user_id, book_id, price, order_date) values (?,?,?,?)";
		 java.util.Date d=new java.util.Date();
		 java.sql.Date sql_date=new java.sql.Date(d.getTime());
		 PreparedStatement ps=null;
		 try {	
			 ps=con.prepareStatement(strinsert);
			 ps.setString(1,uid);
			 ps.setString(2,bid);
			 ps.setString(3,price);
			 ps.setDate(4, sql_date);
			 int status=ps.executeUpdate();
			 if(status>0)
			 {
				 		String path="C:\\Users\\pc\\git\\repository\\bookstore\\buko\\src\\main\\webapp\\pdf_files\\";				 		
				 		File downloadFile = new File(path+filename);
				 		FileInputStream fis = new FileInputStream(downloadFile);
				 		ServletContext context= getServletContext();
				 		String mime=context.getMimeType(path+filename);		
				 		response.setContentType(mime);
				 		response.setContentLength((int)downloadFile.length());
				 		 OutputStream os = response.getOutputStream();
				 		 byte []buffer=new byte[4096];
				 		 int byteRead = -1;
				 		 while((byteRead=fis.read(buffer)) != -1)
				 		 {
				 			 os.write(buffer, 0, byteRead);
				 		 }
				 		 fis.close();
				 		 os.close();
				 		System.out.println(mime);
			 }
				 			 
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
			 
