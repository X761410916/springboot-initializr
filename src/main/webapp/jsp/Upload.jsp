<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"  isELIgnored="false" %>

<html>
<body>
	<form method="post" action="${pageContext.request.contextPath}/user/upload" enctype="multipart/form-data">
		头像：<input type="file" name="file" />
		<input type="submit" value="点击上传"/>
	</form>
	
	<center>
	偶吼吼  <a href="${pageContext.request.contextPath}/uploadFile/download?fileName=2b213a508cb988c0f9cbe9bbc7bc4a691574389723596.jpg">点击下载</a><br/>
	哈哈哈  <a href="${pageContext.request.contextPath}/uploadFile/download?fileName=hyr.txt">点击下载</a><br/>
	嘿嘿嘿  <a href="${pageContext.request.contextPath}/uploadFile/download?fileName=hy.txt">点击下载</a><br/>
	呵呵呵  <a href="${pageContext.request.contextPath}/uploadFile/download?fileName=h.txt">点击下载</a><br/>
	</center>
</body>
</html>