<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <title>My JSP 'success.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   

	<s:form action="login1">

  		<s:textfield name="testBean.name" label="Your name"/>
  		
  		<%-- <s:select list="#groups" listKey="id" listValue="name" label="组别" 
   headerValue="请选择组" headerKey="-1" ></s:select> --%>
  		<s:select list="checklist" listKey="id" listValue="name" label="组别" headerValue="请选择组" headerKey="-1" ></s:select>
	
	<%--  <s:radio list="#{'1':'男','0':'女' }" label="性别" value="1" name="gender"></s:radio> --%>
	 	<s:radio list="checklist" label="性别" listKey="id" listValue="name" value="0" name="gender"></s:radio>
	
	<%--  <s:checkboxlist  label="爱好" name="interest" list="#interest" 
   value="#{'football','basketball'}"></s:checkboxlist> --%>
	
		<s:checkboxlist  label="爱好" name="interest" list="checklist" listKey="id" listValue="name" value="0"></s:checkboxlist>
	
   		<s:submit value="Submit" />

	</s:form>

  </body>
</html>
