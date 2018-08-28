<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="msUrl" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
var msUrl='${msUrl}';
</script>
<!-- 公共资源CSS,JS  -->
<link href="" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/bcss/style.default.css">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/bcss/jquery.gritter.css">
  
<!--Css -->
<link rel="stylesheet" type="text/css" href="${msUrl}/css/layer/layer.css">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/layer/laycode.css">
<link rel="stylesheet" href="${msUrl}/css/bcss/bootstraptable/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/liststyle.css">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/valid.css">
<!-- ** Javascript ** -->

<script src="${msUrl}/js/jquerylib/jquery-1.11.1.min.js"></script>
<script src="${msUrl}/js/jquerylib/jquery-migrate-1.2.1.min.js"></script>
<script src="${msUrl}/js/jquerylib/jquery-ui-1.10.3.min.js"></script>
<script src="${msUrl}/js/jquerylib/jquery.gritter.min.js"></script>
<script src="${msUrl}/js/jquerylib/jquery.sparkline.min.js"></script>
<script src="${msUrl}/js/jquerylib/jquery.cookies.js"></script>
<script type="text/javascript" src="${msUrl}/js/tAd/moment.js"></script>

<!--[if lte IE 8]>
<script language="javascript" type="text/javascript" src="${msUrl}/js/jquerylib/flot/excanvas.js"></script>
<![endif]-->
<script src="${msUrl}/js/jquerylib/flot/jquery.flot.min.js"></script>
<script src="${msUrl}/js/jquerylib/flot/jquery.flot.resize.min.js"></script>
<script src="${msUrl}/js/jquerylib/flot/jquery.flot.spline.min.js"></script>


<script src="${msUrl}/js/bootstraplib/bootstrap.min.js"></script>
<script src="${msUrl}/js/bootstraplib/modernizr.min.js"></script>
<script src="${msUrl}/js/bootstraplib/toggles.min.js"></script>
<script src="${msUrl}/js/bootstraplib/bootstrap-waitingfor.js"></script>
<!-- <script src="${msUrl}/js/bootstraplib/retina.min.js"></script> -->


<script src="${msUrl}/js/bootstraplib/morris.min.js"></script>
<!-- <script src="${msUrl}/js/bootstraplib/raphael-2.1.0.min.js"></script> -->

<script src="${msUrl}/js/bootstraplib/custom.js"></script>




<script src="${msUrl}/js/layer/layer.js"></script>
<script src="${msUrl}/js/layer/laycode.js"></script>
<script src="${msUrl}/js/bootstraplib/bootstraptable/bootstrap-table.js"></script>
<script src="${msUrl}/js/bootstraplib/bootstraptable/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${msUrl}/js/bootstraplib/bootstraptable/extensions/export/bootstrap-table-export.js"></script>
<script type="text/javascript" src="${msUrl}/js/bootstraplib/bootstraptable/extensions/export/export-plugin/tableExport.js"></script>
<script type="text/javascript" src="${msUrl}/js/bootstraplib/bootstraptable/extensions/export/export-plugin/jquery.base64.js"></script>
<script type="text/javascript">$.base64.utf8encode = true;</script>  
<script type="text/javascript" src="${msUrl}/js/bootstraplib/bootstraptable/extensions/export/export-plugin/html2canvas.js"></script>
<script type="text/javascript" src="${msUrl}/js/layer/laydate/laydate.dev.js"></script>

<script src="${msUrl}/js/jquerylib/jquery-form.js"></script>
<script type="text/javascript" src="${msUrl}/js/jquerylib/jquery.formFill.js"></script>

<script type="text/javascript" src="${msUrl}/js/jquerylib/validate/jquery.validate.js"></script>
<script type="text/javascript" src="${msUrl}/js/jquerylib/validate/valadate-message.js"></script>
<script type="text/javascript" src="${msUrl}/js/jquerylib/validate/additional-methods.js"></script>
<script src="${msUrl}/js/common/SPlatForm.js"></script>
<script src="${msUrl}/js/common/STableUtils.js"></script>
   	
<style>
.tooltip-inner{
	background-color: red;
}
.tooltip.right .tooltip-arrow{
	border-right-color:red;
}
</style>
