package com.gpg.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	/**
	 * 处理请求
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("访问到了action");
		System.out.println("调用了service");
		return "success";
	}
}
