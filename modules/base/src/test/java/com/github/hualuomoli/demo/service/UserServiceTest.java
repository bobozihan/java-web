package com.github.hualuomoli.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.github.hualuomoli.base.Pagination;
import com.github.hualuomoli.demo.R;
import com.github.hualuomoli.demo.entity.User;
import com.github.hualuomoli.junit4.SpringTestRunner;
import com.google.common.collect.Lists;

@FixMethodOrder(MethodSorters.CUSTOM)
public class UserServiceTest extends SpringTestRunner {

	@Resource(name = R.id.UserServiceImpl)
	private UserService userService;

	@Test(sort = 1)
	@Ignore
	public void testInsert() throws ParseException {
		User user = new User();
		user.setId("1234567890");
		user.setUserCode("hualuomoli");
		user.setNickName("花落莫离");
		user.setAge(22);
		user.setAddress("山东省青岛市市北区");
		user.setBirthDay(new SimpleDateFormat("yyyyMMdd").parse("20160101"));
		user.setSalary(8888.888);
		user.setRemark("个人信息维护");
		userService.insert(user);
	}

	@Test(sort = 2)
	@Ignore
	public void testBatchInsert() {
		List<User> userList = Lists.newArrayList();
		for (int i = 1; i <= 1000; i++) {
			userList.add(new User("test" + i, "测试" + i));
		}
		userService.batchInsert(userList);
	}

	@Test(sort = 3)
	@Ignore
	public void testUpdate() {
		User user = new User();
		user.setId("1234567890");
		user.setVersion(1);
		user.setAddress("中国");
		user.setNickName("就你长的好看");
		userService.update(user);
	}

	@Test(sort = 4)
	@Ignore
	public void testFindList() {
		User user = new User();
		user.setUserCode("hualuomoli");
		List<User> list = userService.findList(user);
		System.out.println(list.size());
	}

	@Test(sort = 5)
	@Ignore
	public void testFindPage() {
		User user = new User();
		user.setVersion(1);
		Pagination pagination = userService.findPage(user, new Pagination());
		System.out.println(pagination.getCount());
	}

	@Test(sort = 6)
	@Ignore
	public void testDeleteUser() {
		String id = "1234567890";
		userService.get(id);
		userService.delete(id);
		userService.get(id);
	}

}
