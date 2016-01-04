package com.github.hualuomoli.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.springframework.stereotype.Service;

import com.github.hualuomoli.base.Pagination;
import com.github.hualuomoli.demo.R;
import com.github.hualuomoli.demo.entity.User;
import com.github.hualuomoli.demo.mapper.UserMapper;
import com.github.hualuomoli.demo.service.UserService;

@Service(value = R.id.UserServiceImpl)
public class UserServiceImpl implements UserService {

	@Resource(name = R.id.UserMapper)
	private UserMapper userMapper;

	@Override
	public void insert(User user) {
		user.preInsert();
		int rows = userMapper.insert(user);
		Assert.assertEquals(rows, 1);
	}

	@Override
	public void batchInsert(List<User> userList) {
		if (userList == null || userList.size() == 0) {
			return;
		}
		for (User user : userList) {
			user.preInsert();
		}
		int rows = userMapper.batchInsert(userList);
		Assert.assertEquals(rows, userList.size());
	}

	@Override
	public void update(User user) {
		user.preUpdate();
		int rows = userMapper.update(user);
		Assert.assertEquals(rows, 1);
	}

	@Override
	public void delete(User user) {
		int rows = userMapper.delete(user);
		Assert.assertEquals(rows, 1);
	}

	@Override
	public void delete(String id) {
		int rows = userMapper.delete(id);
		Assert.assertEquals(rows, 1);
	}

	@Override
	public User get(User user) {
		return userMapper.get(user);
	}

	@Override
	public User get(String id) {
		return userMapper.get(id);
	}

	@Override
	public List<User> findList(User user) {
		return userMapper.findList(user);
	}

	@Override
	public Pagination findPage(User user, Pagination pagination) {
		user.setPagination(pagination);
		pagination.setDataList(userMapper.findList(user));
		return pagination;
	}

}
