package com.easywork.mycrm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycore.utils.MyPage;
import com.easywork.mycrm.persistence.Consultrecord;
import com.easywork.mycrm.persistence.ConsultrecordMapper;
import com.github.pagehelper.PageHelper;

@Transactional
@Service
public class ConsultrecordService {
	@Autowired
	private ConsultrecordMapper consultrecordMapper;

	public ConsultrecordMapper getConsultrecordMapper() {
		return consultrecordMapper;
	}
	
	//插入一条会话记录（销售分配客户）
	public int addCRecord(Integer cid,String statu,Integer eid){
		Consultrecord c= new Consultrecord();
		c.setCustomid(cid);
		c.setConsultstatu(statu);
		c.setConsultmanid(eid);
		c.setConsultdate(new Date());
		int i = consultrecordMapper.insertSelective(c);
		return i;		
	}
	//咨询师查询自己的咨询记录
	public MyPage<Map<String, Object>> listRecord(Integer id,int curr,int limit){
		int count = consultrecordMapper.selectRecordCountByCid(id);
		PageHelper.startPage(curr, limit);
		List<Map<String, Object>> list = consultrecordMapper.selectRecordByCid(id);
		MyPage<Map<String, Object>> myPage = new MyPage<>(count, limit, list);
		return myPage;		
	}
	//咨询师根据记录id查询记录
	public Consultrecord selectRecordById(Integer id){
		return consultrecordMapper.selectByPrimaryKey(id);
	}
	//咨询师根据记录id修改
	public int modConRecord(Integer id,String consultstatu,Date consultdate,String result){
		Consultrecord c = consultrecordMapper.selectByPrimaryKey(id);
		c.setConsultstatu(consultstatu);
		c.setConsultdate(consultdate);
		c.setResult(result);
		return consultrecordMapper.updateByPrimaryKeySelective(c);		
	}
	//部门主管根据部门id查找部门员工的客户咨询状态
	public MyPage<Map<String, Object>> listDeptRe(Integer did,int curr,int limit){
		int count = consultrecordMapper.selectRecordCountByDid(did);
		PageHelper.startPage(curr, limit);
		List<Map<String, Object>> list = consultrecordMapper.selectRecordByDid(did);
		MyPage<Map<String, Object>> myPage = new MyPage<>(count, limit, list);
		return myPage;
		
	}

}