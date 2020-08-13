<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li><a href="/main/index"><span class="glyphicon glyphicon-home"></span>&nbsp;HOME</a></li>
		<li><a data-toggle="collapse" data-target="#submenu-1"><span class="glyphicon glyphicon-gift"></span>&nbsp;PRODUCT <span
				class="glyphicon glyphicon-menu-down"></span> </a>
			<ul id="submenu-1" class="collapse">
				<li><a href="/admin/product/list"> 판매 상품 관리</a></li>
				<li><a href="#"> 상품 문의 관리</a></li>
				<li><a href="#"> 상품 후기 관리</a></li>
			</ul></li>
		<li><a data-toggle="collapse" data-target="#submenu-2"><span class="glyphicon glyphicon-qrcode"></span>&nbsp;ORDER <span
				class="glyphicon glyphicon-menu-down"></span> </a>
			<ul id="submenu-2" class="collapse">
				<li><a href="#"> SUBMENU 1.1</a></li>
				<li><a href="#"> SUBMENU 1.2</a></li>
				<li><a href="#"> SUBMENU 1.3</a></li>
			</ul></li>
		<li><a data-toggle="collapse" data-target="#submenu-3"><span class="glyphicon glyphicon-user"></span>&nbsp;MEMBERS <span
				class="glyphicon glyphicon-menu-down"></span> </a>
			<ul id="submenu-3" class="collapse">
				<li><a href="#"> SUBMENU 1.1</a></li>
				<li><a href="#"> SUBMENU 1.2</a></li>
				<li><a href="#"> SUBMENU 1.3</a></li>
			</ul></li>
		<li><a data-toggle="collapse" data-target="#submenu-4"><span class="glyphicon glyphicon-folder-close"></span>&nbsp;MANAGEMENT <span
				class="glyphicon glyphicon-menu-down"></span> </a>
			<ul id="submenu-4" class="collapse">
				<li><a href="/admin/manage/boardList">게시판 리스트</a></li>
				<li><a href="/admin/manage/couponList">쿠폰 관리</a></li>
				<li><a href="/admin/manage/SmsSendMain">SMS 발송</a></li>
				<li><a href="/admin/manage/EmailSendMain">Email 발송</a></li>
			</ul></li>
		<li>
			<form class="navbar-form">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</li>
	</ul>
</div>