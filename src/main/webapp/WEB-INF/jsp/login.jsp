<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.example.demo.*" %>
<html>
<h1>Login Page</h1>
  <form action="/account/valid" method="post">
    <table>
    <tr><td>ID:</td><td><input type="text" name="id" placeholder="ID"></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password" placeholder="Password"></td></tr>
    <tr></tr>
    <tr><td></td><td><input type="submit" value="Login" style="width: 70px;"/></td></tr>
    </table>
  </form>
  
  <form name="f" action=" http://www.baidu.com/s" target="_blank">
    <table>
    <tr><td><input type="text" name="wd" id="wd" maxlength="100"></td></tr>
    <tr><td><input type="submit" value="百度一下" id="baidu"></td></tr>
    </table>
  </form>

</html>