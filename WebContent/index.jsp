<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/upload_up" method="post" enctype="multipart/form-data">
		用户：<input type="text" name="username"><br/>
		 文件：<input
			type="file" name="file"><br/>
			<input type="submit" value="上传"/>
	</form>
</body>
</html>