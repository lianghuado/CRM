package com.easywork.mycrm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.easycore.utils.BaseController;
import com.easycore.utils.MyDateUtils;
import com.easycore.utils.MyPage;
import com.easywork.mycrm.persistence.Custom;
import com.easywork.mycrm.service.CustomService;

@Controller
@RequestMapping("/mycrm/Custom")
public class CustomController extends BaseController {
	@Autowired
	private CustomService customService;

	// 查询所有的客户,并分页
	@RequestMapping("/listCustom")
	@ResponseBody
	public MyPage<Custom> listCustom(String name, String invitename, int curr, int limit) {
		return customService.listCustom(name, invitename, curr, limit);
	}

	// 添加客户
	@RequestMapping("/addCus")
	public void addCus(HttpServletResponse resp, String name, String education, String phoneno, String qq, String email,
			String invitename) {
		Custom c = new Custom();
		c.setName(name);
		c.setEducation(education);
		c.setPhoneno(phoneno);
		c.setQq(qq);
		c.setEmail(email);
		c.setCreatedate(new Date());
		c.setCustomstatu("0");
		c.setInvitename(invitename);
		int i = customService.addCus(c);
		if (i != 1) {
			super.print(resp, "fail");
			return;
		}
		super.print(resp, "success");
	}

	// 修改客户信息
	@RequestMapping("/modifyCus")
	public void modifyCus(HttpServletResponse resp, Integer id, String name, String edu, String ph, String qq,
			String email, String statu) {
		Custom c = new Custom();
		c.setId(id);
		c.setName(name);
		c.setEducation(edu);
		c.setPhoneno(ph);
		c.setQq(qq);
		c.setEmail(email);
		c.setCustomstatu(statu);
		System.out.println(name);
		int i = customService.modifyCus(c);
		if (i != 1) {
			super.print(resp, "fail");
			return;
		}
		super.print(resp, "success");

	}

	// 根据id查询客户户
	@RequestMapping("/selectById")
	@ResponseBody
	public Custom selectById(Integer id) {
		return customService.selectById(id);
	}

	// 客户信息导出
	@RequestMapping("/outPut")
	public void outPut(HttpServletResponse resp) throws IOException {
		List<Custom> list = customService.listAllCus();
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("客户信息表");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("客户信息一览表");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("客户编号");
		row2.createCell(1).setCellValue("客户姓名");
		row2.createCell(2).setCellValue("教育水平");
		row2.createCell(3).setCellValue("手机号码");
		row2.createCell(4).setCellValue("qq");
		row2.createCell(5).setCellValue("邮箱");
		row2.createCell(6).setCellValue("客户状态");
		row2.createCell(7).setCellValue("创建日期");
		row2.createCell(8).setCellValue("邀请人姓名");
		// 创建以下的行
		for (int i = 0; i < list.size(); i++) {
			HSSFRow row = sheet.createRow(i + 2);
			row.createCell(0).setCellValue(list.get(i).getId());
			row.createCell(1).setCellValue(list.get(i).getName());
			row.createCell(2).setCellValue(list.get(i).getEducation());
			row.createCell(3).setCellValue(list.get(i).getPhoneno());
			row.createCell(4).setCellValue(list.get(i).getQq());
			row.createCell(5).setCellValue(list.get(i).getEmail());
			row.createCell(6).setCellValue(list.get(i).getCustomstatu());
			row.createCell(7).setCellValue(MyDateUtils.getDate(list.get(i).getCreatedate()));
			row.createCell(8).setCellValue(list.get(i).getInvitename());
		}

		// 输出Excel文件
		// FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
		OutputStream output = resp.getOutputStream();
		resp.reset();
		resp.setHeader("Content-disposition", "attachment; filename=details.xls");
		resp.setContentType("application/msexcel");
		wb.write(output);
		output.flush();
		output.close();
	}

	// 客户信息导入
	@RequestMapping("/inCus")
	public void inCus(HttpServletRequest req, HttpServletResponse resp, MultipartFile myFile)
			throws IllegalStateException, IOException {
		String dirstr = req.getServletContext().getRealPath("") + "\\files";
		File file = new File(dirstr);
		file.mkdirs();
		String str = dirstr + "\\" + UUID.randomUUID().toString() + "-" + myFile.getOriginalFilename();
		File myFile2 = new File(str);
		myFile.transferTo(myFile2);
		// 导入已存在的Excel文件，获得只读的工作薄对象
		FileInputStream fis = new FileInputStream(str);
		// 根据指定的文件输入流导入Excel从而产生Workbook对象
		Workbook wb0 = new HSSFWorkbook(fis);
		// 获取Excel文档中的第一个表单
		Sheet sht0 = wb0.getSheetAt(0);		
		// 对Sheet中的每一行进行迭代
		for (Row r : sht0) {
			if(r.getRowNum()<2){  
				continue;  
			}  			
			// 创建实体类
			Custom c = new Custom();
			c.setName(r.getCell(1).getStringCellValue());
			c.setEducation(r.getCell(2).getStringCellValue());
			c.setPhoneno(r.getCell(3).getStringCellValue());
			c.setQq(r.getCell(4).getStringCellValue());
			c.setEmail(r.getCell(5).getStringCellValue());
			c.setCustomstatu(r.getCell(6).getStringCellValue());
			c.setCreatedate(MyDateUtils.StrToDate(r.getCell(7).getStringCellValue(), "yyyy-MM-dd"));
			c.setInvitename(r.getCell(8).getStringCellValue());
			customService.inCus(c);
		}		
		fis.close();
		if (myFile2.exists()) {
			myFile2.delete();
			System.out.println("文件已删除");
			super.print(resp, "success");
		}
	}
}