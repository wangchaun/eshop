<%@ include file="/commons/taglibs.jsp"%>
<%
response.setStatus(301);
response.setHeader( "Location",path+"/SysLogin!login.do" );
response.setHeader( "Connection", "close" );
%>