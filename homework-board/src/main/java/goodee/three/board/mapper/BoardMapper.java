package goodee.three.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import goodee.three.board.vo.Board;
import goodee.three.board.vo.Page;

@Mapper
public interface BoardMapper 
{
	public List<Board> selectBoardList(Page page);
	
	public int countRow(Page page);
	
	public Board selectBoardOne(int no);
	
	public int deleteBoard(Board board);
	
	public int insertBoard(Board board);
	
	public int updateBoard(Board board);
}
