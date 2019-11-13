package goodee.three.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.three.board.service.BoardServiceImple;
import goodee.three.board.vo.Board;
import goodee.three.board.vo.Page;

@Controller
public class BoardController 
{
	@Autowired private BoardServiceImple boardService;
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(Model model,
							  Board board)
	{
		System.out.println("-----boardUpdate 진입-----");
		System.out.println("board : "+board);
		
		System.out.println("입력할 내용 : "+board);
		
		int check = boardService.updateBoard(board);
		
		System.out.println("update 성공? : "+ check);
		
		return "redirect:/boardList";
	}
	
	@PostMapping("/boardAdd")
	public String boardAdd(Model model,
						   Board board)
	{
		System.out.println("-----boardAdd 진입-----");
		
		System.out.println("입력할 내용 : "+board);
		
		int check = boardService.insertBoard(board);
		
		System.out.println("insert 성공? : "+ check);
		
		return "redirect:/boardList";
	}
	
	@PostMapping("/deleteBoard")
	public String deleteBoard(Model model,
							  Board board)
	{
		System.out.println("-----delete 진입-----");
		System.out.println("삭제할 board : "+ board);
		
		int check = boardService.deleteBoard(board);
		System.out.println("삭제 성공? : "+ check);
		
		return "redirect:/boardList";
	}
	
	@GetMapping("/boardOne")
	public String boardOne(Model model,
					@RequestParam(value="no")int no)
	{
		System.out.println("-----BoardOne 진입-----");
		
		Board board = new Board();
		
		board = boardService.selectBoardOne(no);
		
		System.out.println("No : " + no );
		System.out.println("board : " + board);
		
		model.addAttribute("board", board);
		return "boardOne";
	}
	
	@GetMapping("/index")
	public String index()
	{
		System.out.println("-----index 진입-----");
		return "index";
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model, 
					@RequestParam(value="searchWord", required = false) String searchWord,
					@RequestParam(value="currentPage", defaultValue="1")int currentPage)
	{

		System.out.println("-----List 진입-----");
		
		int rowPerPage = 10;
		int beginRow = 0;
		int lastPage = 0;
		int totalRow = 0;
		beginRow = (currentPage-1)*10;
		
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		
		totalRow = boardService.countRow(page);
		
		if(totalRow%rowPerPage ==0)
		{
			lastPage = totalRow / rowPerPage;
		}
		else
		{
			lastPage = totalRow / rowPerPage + 1;
		}
		
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("beginRow : "+beginRow);
		System.out.println("lastPage : "+lastPage);
		System.out.println("totalRow : "+totalRow);
		
		System.out.println("Page : "+page);
		
		List<Board> list = boardService.selectBoardList(page);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("lastPage", lastPage);
		return "boardList";
	}
}
