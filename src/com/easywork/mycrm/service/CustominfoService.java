package com.easywork.mycrm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycore.utils.MyPage;
import com.easywork.mycrm.persistence.Custominfo;
import com.easywork.mycrm.persistence.CustominfoMapper;
import com.github.pagehelper.PageHelper;

@Transactional
@Service
public class CustominfoService {
	@Autowired
	private CustominfoMapper custominfoMapper;

	public CustominfoMapper getCustominfoMapper() {
		return custominfoMapper;
	}
	//插入一个记录到销售记录表
	public int addSell(Integer cid,String statu,Integer eid){
		Custominfo c=new Custominfo();
		c.setCustomid(cid);
		c.setFollowmanid(eid);
		c.setStatu(statu);
		c.setStartdate(new Date());
		int i = custominfoMapper.insertSelective(c);
		return i;
		
	}
	//查询销售及咨询所开发的客户的信息
	public MyPage<Map<String, Object>> listDeve(Integer id,int curr,int limit){
		int count = custominfoMapper.selectCountByFid(id);
		PageHelper.startPage(curr, limit);
		List<Map<String, Object>> list = custominfoMapper.listCinfo(id);
		MyPage<Map<String, Object>> myPage = new MyPage<>(count, limit, list);
		return myPage;		
	}
	//修改指定客户开发状态信息
	public int modCustomInfo(Integer id,String statu,Date plandate,String mark){
		Custominfo c = custominfoMapper.selectByPrimaryKey(id);
		if (statu!=null&&!"".equals(statu)) {
			c.setStatu(statu);
		}
		if (plandate!=null) {
			c.setPlandate(plandate);
		}		
		if (mark!=null&&!"".equals(mark)) {
			c.setMark(mark);
		}
		return custominfoMapper.updateByPrimaryKey(c);		
	}
	//根据id找指定额客户开发记录
	public Custominfo selectCinfoById(Integer id){
		return custominfoMapper.selectByPrimaryKey(id);
	}
	//主管根据部门id查看部门员工的客户开发信息
	public MyPage<Map<String, Object>> listDeveByDid(Integer did,int curr,int limit){
		int count = custominfoMapper.selectCountByDid(did);
		PageHelper.startPage(curr, limit);
		List<Map<String, Object>> list = custominfoMapper.listCinfoByDid(did);
		MyPage<Map<String, Object>> myPage = new MyPage<>(count, limit, list);
		return myPage;		
	}

}