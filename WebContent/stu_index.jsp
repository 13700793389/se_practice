<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="src/common/layui/css/layui.css" />
    <title>登录</title>
	
	<link rel="stylesheet" href="src/common/css/sccl.css">
	<link rel="stylesheet" type="text/css" href="src/common/skin/qingxin/skin.css" id="layout-skin"/>
    
  </head>
  
  <body>
	<div class="layout-admin">
		<header class="layout-header">
			<span class="header-logo">国科大选课系统</span> 
			<!-- <a class="header-menu-btn" href="javascript:;"><i class="icon-font">&#xe600;</i></a> -->
			<ul class="header-bar">
				<% String username = (String)(session.getAttribute("cookie_username"));
				String institution = (String)(session.getAttribute("cookie_institution"));
				if(username!=null){
				%>
				<li class="header-bar-role"><a href="javascript:;"><%= institution %></a></li>
				<li class="header-bar-nav">
					<a href="javascript:;"><%= username %><i class="icon-font" style="margin-left:5px;">&#xe60c;</i></a>
					<ul class="header-dropdown-menu">
						<li><a href="javascript:;">个人信息</a></li>
						<li><a href="javascript:;">切换账户</a></li>
						<li><a href="javascript:;">退出</a></li>
					</ul>
				</li>
				<li class="header-bar-nav"> 
					<a href="javascript:;" title="换肤"><i class="icon-font">&#xe608;</i></a>
					<ul class="header-dropdown-menu right dropdown-skin">
						<li><a href="javascript:;" data-val="qingxin" title="清新">清新</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="molv" title="墨绿">墨绿</a></li>
					</ul>
				</li>
				<%} else{ %>
				<li><a href="javascript:;">请先登录</a></li>
				<%} %>
			</ul>
		</header>
		<aside class="layout-side">
			<ul class="side-menu">
			  
			</ul>
		</aside>
		
		<div class="layout-side-arrow"><div class="layout-side-arrow-icon"><i class="icon-font">&#xe60d;</i></div></div>
		
		<section class="layout-main">
			<div class="layout-main-tab">
				<button class="tab-btn btn-left"><i class="icon-font">&#xe60e;</i></button>
                <nav class="tab-nav">
                    <div class="tab-nav-content">
                        <a href="javascript:;" class="content-tab active" data-id="stu_home.html">首页</a>
                    </div>
                </nav>
                <button class="tab-btn btn-right"><i class="icon-font">&#xe60f;</i></button>
			</div>
			<div class="layout-main-body">
				<iframe class="body-iframe" name="iframe0" width="100%" height="99%" src="stu_home.html" frameborder="0" data-id="home.html" seamless></iframe>
			</div>
		</section>
		<div class="layout-footer">@中国科学院大学-计算机网络信息中心</div>
	</div>
	<script type="text/javascript" src="src/common/lib/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="src/common/js/sccl.js"></script>
	<script type="text/javascript" src="src/common/js/sccl-util.js"></script>
  </body>
</html>