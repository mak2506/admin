HttpSession hs=request.getSession(false);//this will return session reference
		if(hs!=null)
		{
			hs.removeAttribute("admin");
			hs.invalidate();
			response.sendRedirect("/buko/Admin");
		}
