package goodee.three.board.service;

import java.util.List;

import goodee.three.board.vo.Board;
import goodee.three.board.vo.Page;

public interface BoardService 
{
	public List<Board> selectBoardList(Page page);
	
	public int countRow(Page page);
	
	public Board selectBoardOne(int no);
	
	public Board deleteBoard(Board board);
	
	public int insertBoard(Board board);
	
	public int updateBoard(Board board);
}
