package org.zerock.test;


import java.util.Date;
import java.util.List;

import javax.inject.Inject;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml"})


public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	
	
	
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("test 글을 넣어볼게요");
		board.setContent("잘들어갈거에요");
		board.setWriter("user000");
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception {
	
		logger.info(dao.read(7).toString());
	}
	
	
	public void testUpdate() throws Exception {
		
		BoardVO board = new BoardVO();
		board.setBno(3);
		board.setTitle("수정된글입니다.");
		board.setContent("수정테스트 ");
		dao.update(board);
	}
	
	
	
	public void testDelete() throws Exception {
		dao.delete(3);
		dao.delete(4);
		dao.delete(5);
		dao.delete(6);
	}
	
	
	@Test
	  public void testListPage() throws Exception {

	    int page = 3;

	    List<BoardVO> list = dao.listPage(page);

	    for (BoardVO boardVO : list) {
	      logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
	    }
	  }
	
	@Test
	  public void testListCriteria() throws Exception {

	    Criteria cri = new Criteria();
	    cri.setPage(2);
	    cri.setPerPageNum(20);

	    List<BoardVO> list = dao.listCriteria(cri);

	    for (BoardVO boardVO : list) {
	      logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
	    }
	  }
	
	
	 @Test
	  public void testURI() throws Exception {

	    UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/board/read").queryParam("bno", 12)
	        .queryParam("perPageNum", 20).build();

	    logger.info("/board/read?bno=12&perPageNum=20");
	    logger.info(uriComponents.toString());

	  }

	  @Test
	  public void testURI2() throws Exception {

	    UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/{module}/{page}").queryParam("bno", 12)
	        .queryParam("perPageNum", 20).build().expand("board", "read").encode();

	    logger.info("/board/read?bno=12&perPageNum=20");
	    logger.info(uriComponents.toString());
	  }

}




















