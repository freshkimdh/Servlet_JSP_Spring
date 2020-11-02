package edu.bit.ex;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String,Controller> mappings; // <K, V>
	
	public HandlerMapping() { // 
		mappings = new HashMap<String, Controller>();
		//Key에 값을 넣어준다.
		//PUT으로 KEY, Value 값을 넣어준다
		//Key를 불러오면 Value의 값을 가지고 올 수 있다
		//System.out.println(mappings.get("/")); 이렇게 하면 value 객체 가지고 옴 
		mappings.put("/list",new BListController());
	}
	
	public Controller getController(String path) { // 리턴타입 인터페이스
		return mappings.get(path); //인터페이스에서 받은 "list"를 가지고 옴
	}
}
