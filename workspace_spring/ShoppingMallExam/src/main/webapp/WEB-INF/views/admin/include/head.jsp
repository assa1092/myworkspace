<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Base structure */
/* Move down content because we have a fixed navbar that is 50px tall */
body {
	padding-top: 50px;
}

/* Global add-ons */
.sub-header {
	padding-bottom: 10px;
	border-bottom: 1px solid #eee;
}
/* Top navigation * Hide default border to remove 1px line. */
.navbar-fixed-top {
	border: 0;
}

/* Sidebar */
/* Hide for mobile, show later */
.sidebar {
	display: none;
}

@media ( min-width : 768px) {
	.sidebar {
		position: fixed;
		top: 51px;
		bottom: 0;
		left: 0;
		z-index: 1000;
		display: block;
		padding: 20px;
		overflow-x: hidden;
		overflow-y: auto;
		/* Scrollable contents if viewport is shorter than content. */
		background-color: #f5f5f5;
		border-right: 1px solid #eee;
	}
}

/* Sidebar navigation */
.nav-sidebar {
	margin-right: -21px; /* 20px padding + 1px border */
	margin-bottom: 20px;
	margin-left: -20px;
}

#submenu-1, #submenu-2, #submenu-3, #submenu-4>li {
	list-style-type: none;
	margin-bottom: 5px;
}

#submenu-1, #submenu-2, #submenu-3, #submenu-4>li>a:link, a:visited {
	text-decoration: none;
}

.nav-sidebar>li>a {
	padding-right: 20px;
	padding-left: 20px;
}

.nav-sidebar>.active>a, .nav-sidebar>.active>a:hover, .nav-sidebar>.active>a:focus
	{
	color: #fff;
	background-color: #428bca;
}

/* Main content */
.main {
	padding: 20px;
}

@media ( min-width : 768px) {
	.main {
		padding-right: 40px;
		padding-left: 40px;
	}
}

.main .page-header {
	margin-top: 0;
}

#mytable th, td {
	text-align: center;
}

th {
	text-align: center;
}

.fileDrop {
	width: 100%;
	height: 50px;
}

.uploadedList {
	margin-top: 20px;
}

.uploadedList {
	list-style: none;
}

.orifilename {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>