package edu.czjt.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.czjt.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by jinkun.tian on 2023/4/21
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
    @Update("<script>"
            + "UPDATE dish"
            + " SET status = #{status}"
            + " WHERE id IN "
            + "<foreach item='id' index='index' collection='ids' open='(' separator=',' close=')'>"
            + "#{id}"
            + "</foreach>"
            + "</script>")
    int updateBatchStatusByIds(@Param("status") Integer status, @Param("ids") List<Long> ids);
}
