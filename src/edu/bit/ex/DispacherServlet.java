package edu.bit.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispacherServlet
 */
@WebServlet("/") // "/" 시작하는 것을 전부 받겠다.
public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private HandlerMapping handlerMapping; // "HandlerMapping" 클래스를 변수에 넣어 줌
	private ViewResolver viewResolver; //"ViewResolver" 클래스를 변수에 넣어 줌	
	
    public DispacherServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException{
    	
    	handlerMapping = new HandlerMapping(); // 객체 생성
    	viewResolver = new ViewResolver(); // 객체 생성
    	
    	//viewResolver 클래스에서
    	//setPrefix 함수에 단순히 "./" 이것을 넣어 주었음 
    	viewResolver.setPrefix("./"); // "./"로 되어 있는것을 받겠다 	
    	viewResolver.setSuffix(".jsp"); // ".jsp"로 되어 있는것을 받겠다.
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("ECU-KR");
		process(request, response);
	}	
	
	//actionDo와 같은 놈
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{ 
		
		//1. 클라이언트 요청 path 정보를 추출한다.
		String uri = request.getRequestURI(); //uri 주소 가지고 옴
		String path = uri.substring(uri.lastIndexOf("/")); 
		//특정문자 이후의 문자열 제거
		//String str = "ABCD/DEFGH";
		//String result = str.substring(str.lastIndexOf("/")+1);
		//System.out.println(result); 
		//결과값 DEFGH 
		//+1 이 없으면 "/" 포함하고 가지고 옴 -> /DEFGH
		
		//2.handlermapping 을 통해 path 에 해당하는 contlloer 를 검색한다
		//HandlerMapping 클래스에 uri 주소를 가지고 옴 
		Controller ctrl = handlerMapping.getController(path); 
		
		//3. 검색된 컨트롤러를 실행한다. 
		//인터페이스의 request, response 객체를 viewName에 넣어 줌
		String viewName = ctrl.handleRequest(request, response);
		
		//4.viewresolver 를 통해  viewname에 해당하는 화면을 검색한다. 
		//view 즉, uri 주소를 지정 해준다.
		//.do 혹은 .jsp를 모두 모아서 view 넣어줘서 다 받도록 설정
		String view = null;
		if(!viewName.contains(".do")) { 
			view = viewResolver.getView(viewName); 
		}else {
			view = viewName;
		}
		// if 문에서 설정했던 것을 view 하나로 정의해서 요청한것을 모두 받겠다.
		//5.검색된 화면으로 이동한다
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
