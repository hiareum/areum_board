package com.springbook.view.board;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller //@SessionAttributes board라는 이름으로 저장된 데이터가 있다면 그 데이터를 세션에도 자동으로 저장하라는 설정이다

@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//@ModelAttribute는 객체의 이름을 변경할 목적으로 사용하지만 view(jsp)에서 사용할 데이터를 설정하는 용도로도 사용할 수 있다
	//@ModelAttribute가 설정될 메서드는 @RequestMapping어노테이션이 적용된 메소드보다 먼저 호출
	//@ModelAttribute메서드 실행결과로 리턴된 객체는 자동으로 model에저장된다. 따라서 @ModelAttribute메서드 실행결과로 리턴된 객체를 view페이지에서 사용할 수 있다

	// 검색 조건 목록 설정
		@ModelAttribute("conditionMap")
		public Map<String, String> searchConditionMap(){
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("제목", "TITLE");
			conditionMap.put("내용", "CONTENT");
			return conditionMap;
		}

	
	// 글 등록
		/*
	@RequestMapping(value = "/insertBoard.do") //스프링컨테이너가 BoardVO객체 생성시 MultipartFile 객체를 생성하고 할당함,
	//그런데  multipartResolver라는 이름으로 등록된 CommonsMultipartResolver가 없으면 스프링 컨테이너는 MultipartFile객체를 생성할 수 없다 
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws IOException {
		// 파일 업로드 처리
				MultipartFile uploadFile = vo.getUploadFile();
				if(!uploadFile.isEmpty()){
					String fileName = uploadFile.getOriginalFilename();
					uploadFile.transferTo(new File("D:\\boardWebFile" + fileName));
				}
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}  */
	
	
		//컨트롤러에서 DAO메소드를 호출하면 안되는 이유는 유지보수 과정에서 DAO클래스를 다른클래스로 쉽게 교체하기 위해서다.
		// 글 등록
		@RequestMapping(value = "/insertBoard.do")
		public String insertBoard(BoardVO vo) throws IOException{
			// 파일 업로드 처리
			// MultipartFile 객체가 제공하는 세개의 메소드
			//getUploadFile, getOriginalFilename, transferTo만 이용하면 간단하게 파일업로드를 처리할 수 있다.
		/*	MultipartFile uploadFile = vo.getUploadFile();
			int boardNum = vo.getSeq();
			
			if(!uploadFile.isEmpty()){
				String fileName = uploadFile.getOriginalFilename();
				File file = new File("D:/board/" + boardNum);
				if (!file.exists()) {file.mkdir();}
				uploadFile.transferTo(new File(file,fileName));
			}  */
			
			boardService.insertBoard(vo);
			return "redirect:/getBoardList.do";
		}

		//글등록 
		@RequestMapping(value = "/newBoard.do")
		public String newBoard(BoardVO vo) throws IOException{
			return "insertBoard";
		}
		
		// 글 수정
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BoardVO vo) {			
			boardService.updateBoard(vo);
			return "redirect:/getBoardList.do";
		}

		// 글 삭제
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardVO vo) {
			boardService.deleteBoard(vo);
			System.out.println("삭제를 완료했습니다.");
			return "redirect:/getBoardList.do";
		}
		// 글 상세 조회
		@RequestMapping("/getBoard.do")
		public String getBoard(BoardVO vo, Model model) {
			model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장
			return "getBoard"; // View 이름 리턴
		}
		
	// 글 목록 검색
	//@RequestMapping("/getBoardList.do")
	//public String getBoardList(
		//	@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
		//	@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
		//	BoardDAO boardDAO, Model model) {
		//System.out.println("검색 조건 : " + condition);
	//	System.out.println("검색 단어 : " + keyword);
		// Model 정보 저장
	//	model.addAttribute("boardList", boardDAO.getBoardList(vo));																
		//return "getBoardList.jsp"; // View 이름 리턴
	//}  
		
//		
//		// 글 목록 검색
//		@RequestMapping("/getBoardList.do")
//		public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {		
//			// Model 정보 저장
//			model.addAttribute("boardList", boardDAO.getBoardList(vo));																
//			return "getBoardList.jsp"; // View 이름 리턴
//		}
		
		// 글 목록 검색
				@RequestMapping("/getBoardList.do")
				public String getBoardList(BoardVO vo, Model model) {
					// Null Check
					if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
					if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
					
					System.out.println(vo.getSearchKeyword());
					// Model 정보 저장
					model.addAttribute("boardList", boardService.getBoardList(vo));																
					return "getBoardList"; // View 이름 리턴
				}
			
			
		
		
			//글목록 변환처리
			//익스플로어는 버전에 따라서 json 데이터를 표시할수없으니 크롬으로 확인하자.
			@RequestMapping("/dataTransform.do")
			@ResponseBody
			public List<BoardVO> dataTransform(BoardVO vo) {
				vo.setSearchCondition("TITLE");
				vo.setSearchKeyword("");
				List<BoardVO> boardList = boardService.getBoardList(vo);
				return boardList;
			}
		
}
