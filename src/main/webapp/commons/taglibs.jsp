<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.extremecomponents.org" prefix="ec" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ctxgood" value="http://localhost:7979/shopcloud-goods"/>
<c:set var="ctxaccount" value="http://127.0.0.1:8081"/>
<c:set var="base" value="<%=basePath%>"/>
<c:set var="version" value="1.1.18"></c:set>
<script language="javascript" type="text/javascript">

  var ctx = '${ctx}';
  var todo = '${todo}';<%--做什么,show,即只能查看，不能编辑--%>
  var base='${base}';
  var ctxgood='${ctxgood}';
  var ctxaccount='${ctxaccount}';
</script>