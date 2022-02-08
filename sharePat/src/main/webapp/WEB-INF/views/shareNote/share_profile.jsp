<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
  byte[] 프로필=(byte[])request.getAttribute("share_profile"); 
  response.setContentType("image/png");
  ServletOutputStream 배송자= response.getOutputStream();
   배송자.write(프로필);
%>