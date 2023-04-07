package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;



//map타입의 컬렉션을 멤버변수로 갖고 게시판 프로그램에 필요한 모든 controller객체들을 등록하고 관리
public class HandlerMapping {

	private Map<String,Controller>mappings;
	public HandlerMapping() {
		mappings=new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/logout.do", new LogoutController());
		
		
	}
	
	//path에 해당하는 controller객체를 HashMap컬렉션으로부터 검색하여 리턴
	public Controller getController(String path){
		return mappings.get(path);
		
	}
}
