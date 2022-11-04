package kr.api.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.api.test.dao.BookInfoDAO;
import kr.api.test.vo.BookInfoVO;

@Service
public class BookInfoServiceImpl implements BookInfoService {

	@Autowired
	BookInfoDAO bookInfoDAO;
	
	
	@Override
	public List<BookInfoVO> selectAllBookInfo() {
		// TODO Auto-generated method stub
		return bookInfoDAO.selectAllBookInfo();
	}


	@Override
	public BookInfoVO selectByKey(String book_key) {
		// TODO Auto-generated method stub
		return bookInfoDAO.selectByKey(book_key);
	}


	@Override
	public void insertBookInfo(BookInfoVO bookInfo) {
		// TODO Auto-generated method stub
		bookInfoDAO.insert(bookInfo);
	}


	@Override
	public void updateBookInfo(String book_key, BookInfoVO updateBookInfo) {
		// TODO Auto-generated method stub
		BookInfoVO bookInfo = bookInfoDAO.selectByKey(book_key);
		if(bookInfo != null) {
			bookInfo.setBook_key(updateBookInfo.getBook_key());
			bookInfo.setBook_publisher(updateBookInfo.getBook_reg_no());
			bookInfo.setBook_title(updateBookInfo.getBook_title());
			bookInfo.setBook_author(updateBookInfo.getBook_author());
			bookInfo.setBook_publisher(updateBookInfo.getBook_publisher());
			
			bookInfoDAO.update(bookInfo);
		} else {
			throw new IllegalStateException("책이 존재하지 않습니다.");
		}
		
		
		
	}


	@Override
	public void deleteBookInfo(String book_key) {
		if(bookInfoDAO.selectByKey(book_key) != null) {
			bookInfoDAO.delete(book_key);
		} else {
			throw new IllegalStateException("책이 존재하지 않습니다");
		}
		
	}

}
