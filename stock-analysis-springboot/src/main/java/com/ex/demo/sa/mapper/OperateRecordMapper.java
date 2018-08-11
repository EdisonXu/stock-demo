package com.ex.demo.sa.mapper;

import com.ex.demo.sa.domain.OperateRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author edison
 * On 2018/8/8 16:46
 */
@Mapper
public interface OperateRecordMapper {

	@Insert("insert into operate_record values(#{userId}, #{stockId}, #{stockName}, #{price}, #{quantity}, #{createTime})")
	void insert(OperateRecord record);

	@Select("select * from operate_record where userId=#{arg0} and stockId=#{arg1} order by createTime desc")
	List<OperateRecord> findByUserIdAndStockId(long userId, String stockId);
}
