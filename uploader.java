// TODO Auto-generated method stub
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		String name=request.getParameter("bookname");
		String author=request.getParameter("author");		
		String genre=request.getParameter("genre");
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		String desc=request.getParameter("description");
		int price=Integer.parseInt(request.getParameter("price"));
		Part book=request.getPart("book");
		String bookfile=book.getSubmittedFileName();
		Part cover=request.getPart("bookcover");
		String coverfile=cover.getSubmittedFileName();
		//System.out.println(user_id+" "+name+" "+author+" "+genre+" "+isbn+" "+desc+" "+price+" "+bookfile+" "+coverfile);
		
		Connection con=DBConnection.createConnection();
		String strinsert="insert into book_details (book_name, author, genre, price, description, file, image, book_isbn, user_id, publishdate) values (?,?,?,?,?,?,?,?, ?, ?)";
		 java.util.Date d=new java.util.Date();
		 java.sql.Date sql_date=new java.sql.Date(d.getTime());//fr system print date
		 PreparedStatement ps=null;
		 try {	
			 ps=con.prepareStatement(strinsert);
			 //ps.setString(1,id);
			 ps.setString(1,name);
			 ps.setString(2,author);
			 ps.setString(3, genre);
			 ps.setInt(4, price);
			 ps.setString(5, desc);
			 ps.setString(6, bookfile);
			 ps.setString(7, coverfile);
			 ps.setInt(8, isbn);
			 ps.setInt(9, user_id);
			 ps.setDate(10, sql_date);
			 //System.out.println(ps);
			 int status=ps.executeUpdate();//error
			 if(status>0) {
				 	InputStream is1=book.getInputStream();
				 	InputStream is2=cover.getInputStream();
					byte []bookdata = new byte[is1.available()];
					byte []coverdata = new byte[is2.available()];
					is1.read(bookdata);
					is2.read(coverdata);
					String bookpath= "C:/Users/pc/Desktop/BookStore/buko/src/main/webapp/pdf_files/"+bookfile;
					String coverpath= "C:/Users/pc/Desktop/BookStore/buko/src/main/webapp/bookcovers/"+coverfile;
					//System.out.println(path);
					FileOutputStream fos1 = new FileOutputStream(bookpath);
					fos1.write(bookdata);
					fos1.close();
					FileOutputStream fos2 = new FileOutputStream(coverpath);
					fos2.write(coverdata);
					fos2.close();
				 	System.out.println("uploader login sucessfully done");
				 	response.sendRedirect("/buko/uploader/addbook.jsp");
//				 	request.setAttribute("message", "Book added successfully!!");
//					RequestDispatcher rd=request.getRequestDispatcher("/uploader/addbook.jsp");
//					rd.forward(request, response);					
			 }
			 else {
				 response.sendRedirect("/buko/uploader/addbook.jsp");
//				 request.setAttribute("message", "Some error occurred!!");
//					RequestDispatcher rd=request.getRequestDispatcher("/uploader/addbook.jsp");
//					rd.forward(request, response);		
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
			 
		 }
