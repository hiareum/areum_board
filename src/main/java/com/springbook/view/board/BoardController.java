package com.springbook.view.board;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
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
	}

	// 글 수정
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
			System.out.println("번호 : " + vo.getSeq());
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("작성자 : " + vo.getWriter());
			System.out.println("내용 : " + vo.getContent());
			System.out.println("등록일 : " + vo.getRegDate());
			System.out.println("조회수 : " + vo.getCnt());
			
			boardDAO.updateBoard(vo);
			return "getBoardList.do";
		}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
		@RequestMapping("/getBoard.do") //model에도 board라는 이름으로 boardVO객체가 저장된다 왜냐하면 @SessionAttributes("board")설정으로 인해 
		public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
			model.addAttribute("board", boardDAO.getBoard(vo)); // Model 정보 저장
			return "getBoard.jsp"; // View 이름 리턴
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
		public String getBoardList(BoardVO vo,  Model model) {	
			//널 체크,. 검색조건과 검색키워드가 전달되지 않을 때를 위하여 (예를 들면 로그인 성공 후 getBoardList.do 요청이 전달되거나 상세화면에서 글목록
			//보드 VO객체의SearchCondition , SearchKeyword변수 )
			if(vo.getSearchCondition()==null) {
				vo.setSearchCondition("TITLE");
			}
			if(vo.getSearchKeyword()==null) {
				vo.setSearchKeyword("");
			}
			//모델정보 저장
			model.addAttribute("boardList", boardService.getBoardList(vo));																
			return "getBoardList.jsp"; // View 이름 리턴
		}
		
		
}
