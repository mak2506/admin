HttpSession hs=request.getSession(false);//this will return session reference
		
		if(hs!=null)
		{
			hs.removeAttribute("userkey");
			hs.invalidate();
			response.sendRedirect("/buko");
		}
