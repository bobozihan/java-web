package com.github.hualuomoli.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.hualuomoli.demo.R;
import com.github.hualuomoli.demo.entity.User;
import com.github.hualuomoli.stereotype.Mapper;

@Mapper(value = R.id.UserMapper)
public interface UserMapper {

	int insert(User user);

	int batchInsert(@Param(value = "userList") List<User> userList);

	int update(User user);

	int delete(User user);

	int delete(@Param(value = "id") String id);

	User get(User user);

	User get(@Param(value = "id") String id);

	List<User> findList(User user);

}
