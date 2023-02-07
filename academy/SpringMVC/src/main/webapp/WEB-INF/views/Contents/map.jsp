<!-- jsp에 들어가는 인코딩 문장 language(사용 스타일) 
contentType(클라이언트에 자원을 보낼때 타입을 전송 , char(클라우저가 받을 타입)) 
page(jsp 작성 타입) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<!-- Basic -->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>착한가격업소 - 지도</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/resources/images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- 네이버 지도 API -->
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=fzdqev292q"></script>
	<!-- 지도 표시 parsing js -->
    <script src="${pageContext.request.contextPath}/resources/js/map.js"></script>

</head>

<body>
	<div id="map" style="width:100%;height:900px;"></div>
	

	<script>
	<!-- 지도 좌표와 확대 -->
	var mapOptions = {
		center: new naver.maps.LatLng(37.4508, 126.6656),
		zoom: 14
	};
	<!-- 지도 생성 -->
	var map = new naver.maps.Map('map', mapOptions);
	<!-- 마커 표시 -->
	var marker = new naver.maps.Marker({
	    position: new naver.maps.LatLng(37.4508, 126.6656),
	    map: map
	});
	</script>
</body>

</html>