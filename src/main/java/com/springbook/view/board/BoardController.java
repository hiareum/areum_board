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

@Controller //@SessionAttributes board��� �̸����� ����� �����Ͱ� �ִٸ� �� �����͸� ���ǿ��� �ڵ����� �����϶�� �����̴�

@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//@ModelAttribute�� ��ü�� �̸��� ������ �������� ��������� view(jsp)���� ����� �����͸� �����ϴ� �뵵�ε� ����� �� �ִ�
	//@ModelAttribute�� ������ �޼���� @RequestMapping������̼��� ����� �޼ҵ庸�� ���� ȣ��
	//@ModelAttribute�޼��� �������� ���ϵ� ��ü�� �ڵ����� model������ȴ�. ���� @ModelAttribute�޼��� �������� ���ϵ� ��ü�� view���������� ����� �� �ִ�

	// �˻� ���� ��� ����
		@ModelAttribute("conditionMap")
		public Map<String, String> searchConditionMap(){
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("����", "TITLE");
			conditionMap.put("����", "CONTENT");
			return conditionMap;
		}

	
	// �� ���
		/*
	@RequestMapping(value = "/insertBoard.do") //�����������̳ʰ� BoardVO��ü ������ MultipartFile ��ü�� �����ϰ� �Ҵ���,
	//�׷���  multipartResolver��� �̸����� ��ϵ� CommonsMultipartResolver�� ������ ������ �����̳ʴ� MultipartFile��ü�� ������ �� ���� 
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws IOException {
		// ���� ���ε� ó��
				MultipartFile uploadFile = vo.getUploadFile();
				if(!uploadFile.isEmpty()){
					String fileName = uploadFile.getOriginalFilename();
					uploadFile.transferTo(new File("D:\\boardWebFile" + fileName));
				}
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}  */
	
	
		//��Ʈ�ѷ����� DAO�޼ҵ带 ȣ���ϸ� �ȵǴ� ������ �������� �������� DAOŬ������ �ٸ�Ŭ������ ���� ��ü�ϱ� ���ؼ���.
		// �� ���
		@RequestMapping(value = "/insertBoard.do")
		public String insertBoard(BoardVO vo) throws IOException{
			// ���� ���ε� ó��
			// MultipartFile ��ü�� �����ϴ� ������ �޼ҵ�
			//getUploadFile, getOriginalFilename, transferTo�� �̿��ϸ� �����ϰ� ���Ͼ��ε带 ó���� �� �ִ�.
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

		//�۵�� 
		@RequestMapping(value = "/newBoard.do")
		public String newBoard(BoardVO vo) throws IOException{
			return "insertBoard";
		}
		
		// �� ����
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BoardVO vo) {			
			boardService.updateBoard(vo);
			return "redirect:/getBoardList.do";
		}

		// �� ����
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardVO vo) {
			boardService.deleteBoard(vo);
			System.out.println("������ �Ϸ��߽��ϴ�.");
			return "redirect:/getBoardList.do";
		}
		// �� �� ��ȸ
		@RequestMapping("/getBoard.do")
		public String getBoard(BoardVO vo, Model model) {
			model.addAttribute("board", boardService.getBoard(vo)); // Model ���� ����
			return "getBoard"; // View �̸� ����
		}
		
	// �� ��� �˻�
	//@RequestMapping("/getBoardList.do")
	//public String getBoardList(
		//	@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
		//	@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
		//	BoardDAO boardDAO, Model model) {
		//System.out.println("�˻� ���� : " + condition);
	//	System.out.println("�˻� �ܾ� : " + keyword);
		// Model ���� ����
	//	model.addAttribute("boardList", boardDAO.getBoardList(vo));																
		//return "getBoardList.jsp"; // View �̸� ����
	//}  
		
//		
//		// �� ��� �˻�
//		@RequestMapping("/getBoardList.do")
//		public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {		
//			// Model ���� ����
//			model.addAttribute("boardList", boardDAO.getBoardList(vo));																
//			return "getBoardList.jsp"; // View �̸� ����
//		}
		
		// �� ��� �˻�
				@RequestMapping("/getBoardList.do")
				public String getBoardList(BoardVO vo, Model model) {
					// Null Check
					if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
					if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
					
					System.out.println(vo.getSearchKeyword());
					// Model ���� ����
					model.addAttribute("boardList", boardService.getBoardList(vo));																
					return "getBoardList"; // View �̸� ����
				}
			
			
		
		
			//�۸�� ��ȯó��
			//�ͽ��÷ξ�� ������ ���� json �����͸� ǥ���Ҽ������� ũ������ Ȯ������.
			@RequestMapping("/dataTransform.do")
			@ResponseBody
			public List<BoardVO> dataTransform(BoardVO vo) {
				vo.setSearchCondition("TITLE");
				vo.setSearchKeyword("");
				List<BoardVO> boardList = boardService.getBoardList(vo);
				return boardList;
			}
		
}
