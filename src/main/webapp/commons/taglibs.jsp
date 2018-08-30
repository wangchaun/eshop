<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.extremecomponents.org" prefix="ec" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String base=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/UserService"+"/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ctxgood" value="http://localhost:8081"/>
<c:set var="base" value="<%=base %>"/>
<c:set var="version" value="1.0.9"></c:set>
<script language="javascript" type="text/javascript">
  var ctx = '${ctx }';
  var todo = '${todo }';<%--做什么,show,即只能查看，不能编辑--%>
  var base='${base}';
  var ctxgood='${ctxgood}';
</script>