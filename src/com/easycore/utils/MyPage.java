package com.easycore.utils;

import java.util.List;
import java.util.Map;

import com.easywork.mycrm.persistence.Employee;
import com.easywork.mycrm.persistence.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

public class MyPage<T> {
	public MyPage(int count, int limit, List<T> list) {
		this.count = count;
		this.list = list;
		// 计算pagecount
		this.pagecount = count % limit == 0 ? (count / limit) : (int) (count / limit) + 1;
	}

	private int count;
	private int pagecount;
	private List<T> list;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	// select分页
	public static <T> MyPage<T> selectByPage(Mapper<T> mapper, T t, int curr, int limit) {
		// 参数计算
		int count = mapper.selectCount(t);
		// 分页拦截
		PageHelper.startPage(curr, limit);
		List<T> list = mapper.select(t);
		MyPage<T> page = new MyPage<T>(count, limit, list);
		return page;
	}

	// selectAll分页
	public static <T> MyPage<T> selectAllByPage(Mapper<T> mapper, int curr, int limit) {
		// 参数计算
		int count = mapper.selectCount(null);
		// 分页拦截
		PageHelper.startPage(curr, limit);
		List<T> list = mapper.selectAll();
		MyPage<T> page = new MyPage<T>(count, limit, list);
		return page;
	}

	// selectByExample分页
	public static <T> MyPage<T> selectByExampleAndPage(Mapper<T> mapper, Example exm, int curr, int limit) {
		// 参数计算
		int count = mapper.selectCountByExample(exm);
		// 分页拦截
		PageHelper.startPage(curr, limit);
		List<T> list = mapper.selectByExample(exm);
		MyPage<T> page = new MyPage<T>(count, limit, list);
		return page;
	}

	// List<Map<string,object>>selectByExample分页
	public static  MyPage<Map<String, Object>> selectByExampleAndPageMap(EmployeeMapper mapper, String id,String dname, int curr, int limit) {
		// 参数计算
		int count = mapper.selectCountByIdAndDname(id, dname);
		// 分页拦截
		PageHelper.startPage(curr, limit);		
		List<Map<String, Object>> list = mapper.showEmp(id,dname);
		MyPage<Map<String, Object>> page = new MyPage<Map<String, Object>>(count, limit, list);
		return page;
	}

	//
}
