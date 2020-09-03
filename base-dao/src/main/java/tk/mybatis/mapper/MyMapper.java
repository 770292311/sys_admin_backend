package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * ProjectName：lottery
 * ClassName：MyMapper
 * Description：TODO
 * Date：2020/7/15 17:42
 * Author：GSean
 * Version: 1.0
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
