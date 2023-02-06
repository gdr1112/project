function ajaxpage(page){
	$.ajax({
		type : "GET",
		url : 'couple?page2=' + page,
		data : page,
		datatype:"text",
		success:function(result){
			$('#replace').load("couple?page2=" + page + " #rpcontent");
		}
	});
}




new Swiper('.swiper-container', {

	slidesPerView : 1, // 동시에 보여줄 슬라이드 갯수
	spaceBetween : 0, // 슬라이드간 간격
	slidesPerGroup : 1, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음

	// 그룹수가 맞지 않을 경우 빈칸으로 메우기
	// 3개가 나와야 되는데 1개만 있다면 2개는 빈칸으로 채워서 3개를 만듬
	loopFillGroupWithBlank : true,

	loop : true, // 무한 반복

	pagination : { // 페이징
		el : '.swiper-pagination',
		clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
	},
	navigation : { // 네비게이션
		nextEl : '.swiper-button-next', // 다음 버튼 클래스명
		prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
	},
});



function GetShow(){	 // 설명 자세히
		
		var con = document.getElementById("hide");
		
		if(con.style.display == "none"){
			con.style.display = "block"; 
		}
		else{
			con.style.display = "none"
		}
}


function Getshow(){	 // 설명 자세히
		var con = document.getElementById("hide2");
		
		if(con.style.display == "none"){
			con.style.display = "block"; 
		}
		else{
			con.style.display = "none"
		}
}

	
function getShow(){	 // 코스 정보 자세히
		var con = document.getElementById("hide1");
		if(con.style.display == "none"){
			con.style.display = "block"; 
		}
		else{
			con.style.display = "none"
		}
	}
	
	
	function getshow(){	 // 코스 정보 자세히
		var con = document.getElementById("hide3");
		if(con.style.display == "none"){
			con.style.display = "block"; 
		}
		else{
			con.style.display = "none"
		}
	}

	function Get_Show(){	 // 설명 자세히
		var con = document.getElementById("hide4");
		if(con.style.display == "none"){
			con.style.display = "block"; 
		}
		else{
			con.style.display = "none"
		}
	}
	
	function get_Show(){	 // 코스 정보 자세히
		var con = document.getElementById("hide5");
		if(con.style.display == "none"){
			con.style.display = "block"; 
		}
		else{
			con.style.display = "none"
		}
	}
