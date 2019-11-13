package goodee.three.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.three.board.mapper.BoardMapper;
import goodee.three.board.vo.Board;
import goodee.three.board.vo.Page;

@Service
@Transactional
public class BoardServiceImple 
{
	@Autowired private BoardMapper boardMapper;
	public List<Board> selectBoardList(Page page)
	{
		System.out.println("*****리스트서비스*****");
		System.out.println("page : "+ page);
		System.out.println("*******************");
		return boardMapper.selectBoardList(page);
	}
	
	public int countRow(Page page)
	{
		return boardMapper.countRow(page);
	}
	
	public Board selectBoardOne(int no)
	{
		return boardMapper.selectBoardOne(no);
	}
	
	public int deleteBoard(Board board)
	{
		return boardMapper.deleteBoard(board);
	}
	
	public int insertBoard(Board board)
	{
		return boardMapper.insertBoard(board);
	}
	
	public int updateBoard(Board board)
	{
		return boardMapper.updateBoard(board);
	}
}
