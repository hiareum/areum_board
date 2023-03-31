package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceCilent {
	public static void main(String[] args) {
//1.스프링컨테이너 구동
		AbstractApplicationContext container=new GenericXmlApplicationContext("applicationContext.xml");
	//2.스프링 컨테이너로부터 boardserviceImpl 객체(boardservice)를 LookUp함
		BoardService boardService=(BoardService) container.getBean("boardService");
		//3.글 등록 기능 테스트
		BoardVO vo=new BoardVO();
		vo.setTitle("임시제목");
		vo.setWriter("홍길동");
		vo.setContent("임시내용...");
		boardService.insertBoard(vo);
		
		//4.글 목록 검색 기능 테스트
		List<BoardVO> boardList=boardService.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println("-->"+board.toString());
		}
		
		//5.스프링 컨테이너 종료
		//에러가나서 H2의 버전을 올려줬다
		/*
		 <dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<version>2.1.214</version>
		</dependency>
		 
		  
		  */
	}
}
