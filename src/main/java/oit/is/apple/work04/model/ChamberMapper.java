package oit.is.apple.work04.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChamberMapper {
    
    @Select("SELECT * from chamber where id = #{id}")
    Chamber selectById(int id);

}
