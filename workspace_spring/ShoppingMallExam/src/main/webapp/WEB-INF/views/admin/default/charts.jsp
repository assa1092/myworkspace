	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
 	<meta name="author" content="">

  <title>SB Admin 2 - Charts</title>

  <!-- Custom fonts for this template-->
  <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="color.html">
          <i class="fas fa-fw fa-folder"></i>
          <span>판매상품관리</span>
        </a>
      </li>
      
      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>판매상품등록</span></a>
      </li>
      
       <!-- Divider -->
      <hr class="sidebar-divider">


      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>


          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            
           

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie Luna</span>
                <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Activity Log
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  	로그아웃
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->
        <div class="col-sm-9 ml-sm-auto col-md-10 pt-3 common-right-body">
			<div class="common-right-title">
					<div class="row">
						<div class="col-md-11">
							<p class="h3">
								상품관리
							</p>
						</div>
						<div class="col-md-1">
							<button class="btn btn-outline-danger">저장</button>
						</div>
					</div>
			</div>
		
		<div class="common-inner-body">
				
				<form class="container">
					<div class="row">
							<p class="h4">상품 등록</p>
						</div>
					<div class="row container">
						<table class="table col-md-12">
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">상품명</th>
								<td class="col-md-4 container">
									<input class="form-control" type="text" placeholder="내용을 입력하세요.">
								</td>
								<th class="col-md-2 form-label table-active">자체상품코드</th>
								<td class="col-md-4 container">
									<input class="form-control" type="text" placeholder="내용을 입력하세요.">
								</td>
							</tr>
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">판매가</th>
								<td class="col-md-4 container">
									<input class="form-control col-md-11" type="text" id="datepicker" placeholder="내용을 입력해주세요.">
								</td>
								<th class="col-md-2 form-label table-active">판매설정</th>
								<td class="col-md-4 container">
									<div class="row">
										<div class="col-md-6">
											<div class="form-check">
												<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
												<label class="form-check-label" for="gridRadios1">
													판매함
												</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-check">
												<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
												<label class="form-check-label" for="gridRadios2">
													판매안함
												</label>
											</div>
										</div>
									</div>
								</td>
							</tr>
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">상품명</th>
								<td class="col-md-4 container">
									<input class="form-control col-md-11" type="text" id="datepicker" placeholder="내용을 입력해주세요.">
								</td>
								<th class="col-md-2 form-label table-active">상품소개</th>
								<td class="col-md-4 container">
									<input class="form-control col-md-11" type="text" id="datepicker" placeholder="내용을 입력해주세요.">
								</td>
							</tr>
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">제조사</th>
								<td class="col-md-4 container">
									<input class="form-control col-md-11" type="text" id="datepicker" placeholder="내용을 입력해주세요.">
								</td>
								<th class="col-md-2 form-label table-active">제조일</th>
								<td class="col-md-4 container">
									<input class="form-control col-md-11" type="text" id="datepicker" placeholder="내용을 입력해주세요.">
								</td>
							</tr>
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">제조국</th>
								<td class="col-md-4 container">
									<input class="form-control col-md-11" type="text" id="datepicker" placeholder="내용을 입력해주세요.">
								</td>
								<th class="col-md-2 form-label table-active">세탁법</th>
								<td class="col-md-4 container">
									파일 업로드
								</td>
							</tr>
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">공급사</th>
								<td class="col-md-4 container">
									<input class="form-control col-md-11" type="text" id="datepicker" placeholder="내용을 입력해주세요.">
								</td>
								<th class="col-md-2 form-label table-active">품질보증기준</th>
								<td class="col-md-4 container">
									파일업로드 붙이기
								</td>
							</tr>
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">재고</th>
								<td class="col-md-3 container">
									<div class="row container">
										<input class="form-control col-md-10" type="text" id="datepicker" placeholder="갯수입력">
										<span class="text col-md-1 mt-2">개</span>
									</div>
								</td>
								<td class="col-md-7 container">
									<p class="text" style="font-size: x-small;">
										<br>*상품의 재고는 쇼핑몰에 노출 되지 않습니다.	
									</p>
								</td>
							</tr>							
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">상품할인설정</th>
								<td class="col-md-4 container">
									<div class="row">
										<div class="col-md-6">
											<div class="form-check">
												<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
												<label class="form-check-label" for="gridRadios1">
													할인안함
												</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-check">
												<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
												<label class="form-check-label" for="gridRadios2">
													할인함
												</label>
											</div>
										</div>
									</div>
								</td>
								<th class="col-md-2 form-label table-active">상품할인율</th>
								<td class="col-md-4 container">
									<div class="row">
										<span class="text col-md-4 mt-1">상품금액의</span>
										<input class="form-control col-md-3 ml-1 mr-1" type="text" id="datepicker" placeholder="할인율">
										<span class="text col-md-1 mt-1">%</span>
									</div>
								</td>
							</tr>
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">메인 노출 이미지</th>
								<td class="col-md-10 container">
									<div class="row container">
										<input class="form-control col-md-3" type="text" id="datepicker" placeholder="no_img.jpg">
										<button class="btn btn-dark col-md-2 ml-2">찾아보기</button>
										<p class="text col-md-3" style="font-size: xx-small;"><br>*상품 상세 이용 안내에서 설정 가능합니다.</p>
									</div>
								</td>
							</tr>
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">상품 정보 이미지</th>
								<td class="col-md-10 container">
									<div class="row container">
										<input class="form-control col-md-3 mr-2" type="text" id="datepicker" placeholder="no_img.jpg">
										<button class="btn btn-dark col-md-2">찾아보기</button>
									</div>
								</td>
							</tr>
							<tr class="row form-group mb-0">
								<th class="col-md-2 form-label table-active">상품 짧은 설명</th>
								<td class="col-md-10 container">
									<input class="form-control col-md-11" type="text" id="datepicker" placeholder="*상품 짧은 설명은 메인 리스트에 노출됩니다.">
								</td>
							</tr>
							<tr class="row form-group mb-0 border border-left-0 border-right-0 border-top-0">
								<th class="col-md-2 form-label table-active">상품 상세 설명</th>
								<td class="col-md-10 container">
									<textarea class="form-control col-md-11" id="exampleFormControlTextarea1" rows="5" placeholder="내용을 입력해주세요."></textarea>
								</td>
							</tr>
							
						</table>
					</div>
					
					<div class="form-group row">
					</div>
					
					<div class="form-group row">
					</div>
					
					<div class="form-group row">
						<div class="col-sm-4">
						</div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-dark">상품등록</button>
						</div>
						<div class="col-sm-2">
						</div>
						<div class="col-sm-1">
							<button type="reset" class="btn btn-dark">취소</button>
						</div>
						<div class="col-sm-4">
						</div>
					</div>
				</form>
			</div>
        </div>


  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="../resources/vendor/jquery/jquery.min.js"></script>
  <script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="../resources/vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="../resources/js/demo/chart-area-demo.js"></script>
  <script src="../resources/js/demo/chart-pie-demo.js"></script>

</body>

</html>
 