$(document).ready(function() {
			$.ajax({
//				url : 'your_server_url'
				url : 'http://apis.data.go.kr/3510500/good_price_business/getList',
				type : 'GET',
				dataType : 'json',
//				성공하면
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						var marker = new naver.maps.Marker({
							position : new naver.maps.LatLng(data[i].latitude,
									data[i].longitude),
							map : map
						});
					}
				}
			});
});