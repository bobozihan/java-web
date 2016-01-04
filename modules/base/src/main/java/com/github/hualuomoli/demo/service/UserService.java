package com.github.hualuomoli.demo.service;

import java.util.List;

import com.github.hualuomoli.base.Pagination;
import com.github.hualuomoli.demo.entity.User;

public interface UserService {

	void insert(User user);

	void batchInsert(List<User> userList);

	void update(User user);

	void delete(User user);

	void delete(String id);

	User get(User user);

	User get(String id);

	List<User> findList(User user);

	Pagination findPage(User user, Pagination pagination);

}
