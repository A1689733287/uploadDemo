package com.gpg.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadDemo extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File file;
	
	private String fileFileName;
	private String fileFileContentType;
	
	
	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	public void setFileFileContentType(String fileFileContentType) {
		this.fileFileContentType = fileFileContentType;
	}

	public String up() throws Exception {
		//获取上传文件的目录路径
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		//创建目标文件对象
		File file = new File(path,fileFileName);
		//把上传的文件拷贝到目标文件中
		FileUtils.copyFile(this.file, file);
		return "success";
	}
	
	public String list() {
		//得到upload目录
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		//得到所有需要下载的文件名
		File file_1 = new File(path);
		String[] fileNames = file_1.list();
		//保存
		ActionContext ac = ActionContext.getContext();
		//得到request
		Map<String, Object> request = ac.getContextMap();
		request.put("list", fileNames);
		return "list";
	}
	//获取请求的要下载的文件的文件名
	private String fileName;
	public void setFileName(String fileName) {
		//处理文件名
		try {
			fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		this.fileName = fileName;
	}
	
	// 下载提交的业务方法
	public String down(){
		
		return "down";
	}
	// 返回流的方法
	private InputStream attrInputStream;
	// 返回输出流
	public InputStream getAttrInputStream() {
		attrInputStream = ServletActionContext.getServletContext().getResourceAsStream("/upload/" + fileName);
		return attrInputStream;
	}
	//下载显示的用户名（浏览器显示的文件名）
	public String getDownFileName() {
		try {
			// 转换文件名编码
			fileName = URLEncoder.encode(fileName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return fileName;
	}
}
