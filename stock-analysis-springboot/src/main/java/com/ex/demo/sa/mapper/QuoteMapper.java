package com.ex.demo.sa.mapper;

import com.ex.demo.sa.domain.Quote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author edison
 * On 2018/8/8 15:45
 */
@Mapper
public interface QuoteMapper {

	@Insert("insert into quote values(#{stockId}, #{price}, #{createTime})")
	void insert(Quote quote);

	List<Quote> findAll();

	Quote getLatestQuoteInfo(String stockId);
}
