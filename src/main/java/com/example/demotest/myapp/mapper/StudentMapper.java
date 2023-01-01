package com.example.demotest.myapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demotest.myapp.entity.Student;
import com.example.demotest.myapp.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liqingyuan
 * @since 2022-12-31
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
