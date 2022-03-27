// TODO Auto-generated method stub
		Part part=request.getPart("file");
		String filename=part.getSubmittedFileName();
		//System.out.print(filename);
		
		InputStream is=part.getInputStream();
		byte []data = new byte[is.available()];
		is.read(data);
		String path= "C:/Users/pc/Desktop/BookStore/buko/src/main/webapp/images/"+filename;
		//System.out.println(path);
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);
		fos.close();
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		pw.println("<img src="+path+"'>");
