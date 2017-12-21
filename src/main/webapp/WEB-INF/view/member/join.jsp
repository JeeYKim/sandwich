<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/sandwich/resources/css/joinForm.css">
<link rel="stylesheet" href="/sandwich/resources/css/main.min.css">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.7.2.js"></script>
<style>
.button_{
	position: relative;
	bottom: 5%;
	right: 5%;
    width:100px;
    background-color: #373735;
    border: none;
    color:#fff;
    padding: 15px 0;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px;
    cursor: pointer;
    border-radius:10px;
    z-index:3;
}
</style>
<script type="text/javascript">
	//아이디 중복 확인
	function checkId() {
		var f = document.frm;

		var mem_id = f.MEMBER_ID.value;

		if (mem_id == '') {
			alert("아이디를 입력하세요");
		} else {
			var total = ({
				"mem_id" : mem_id
			});
			$.ajax({

				type : "POST",
				url : "/sandwich/checkId.jy",
				data : total,

				success : function(data) {
					console.log("로그 내용1");

					if (data != 0) {
						alert("사용중인 아이디입니다. 다른 아이디를 입력해 주세요");
						$("#MEMBER_ID").val("");

						return false;
					} else {
						$("#check").val("true");
						alert("사용가능한 아이디 입니다.");
						return true;
					}

				},
				error : function(e) {
					alert('error' + e);
				}
			});
		}

	}

	//비밀번호 일치 확인
	function checkpw() {
		var f = document.frm;
		var k = $("#check").val();

		if (f.MEMBER_PW.value != f.password_confirm.value) {
			alert("비밀번호가 일치하지 않습니다.");

			f.MEMBER_PW.value = "";
			f.password_confirm.value = "";

			return false;
		}

		else {

			if (k == "true") {
				f.submit();
			}

			else if (k == "false") {

				alert("아이디 중복검사를 해주세요.");

				return false;
			}

		}

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<div class="container">
		<div class="body_center" style="width: 70%; list-style: none;">

			<form id="frm" name="frm" action="join.jy" method="post">
				<input type="hidden" id="check" name="check" value="false" />
				<section class="input-horizontal list-horizontal section box-shadow">
				<div class="main_subject">
					<h2>회원정보</h2>
				</div>

				<ul class="section-body" style="list-style: none;">
					<li class="id">
						<div class="item-label col-lg-3 col-md-4">
							<label for="mi"> <strong>* 아이디</strong>
							</label>
						</div>
						<div class="col-lg-21 col-md-20">
							<input type="text" name="MEMBER_ID" id="MEMBER_ID" value=""
								maxlength="20" class="xx-control" label="아이디"
								required="required">
							<p class="alert alert-positive"></p>
							<input type="button" class="button_" style="width:50; margin:0 0 50 0; float:right;"value="중복확인" onclick="javascript:checkId()" />
							${message}
						</div>

					</li>

					<li class="password">
						<div class="item-label col-lg-3 col-md-4">
							<label for="input-password"> <strong>* 비밀번호</strong>
							</label>
						</div>
						<div class="col-lg-21 col-md-20">
							<input type="password" id="input-password" class="xx-control"
								value="" name="MEMBER_PW" required="required" label="비밀번호">
						</div>
					</li>

					<li class="password-check">
						<div class="item-label col-lg-3 col-md-4">
							<label for="input-password-check"> <strong>*
									비밀번호 확인</strong>
							</label>
						</div>
						<div class="col-lg-21 col-md-20">
							<input type="password" id="input-password-check"
								class="xx-control" value="" name="password_confirm" label="비밀번호"
								onkeyup="checkPwd()" required="">
						</div>
					</li>

					<li class="name">
						<div class="item-label col-lg-3 col-md-4">
							<label for="input-name"> <strong>* 이름</strong>
							</label>
						</div>
						<div class="col-lg-21 col-md-20">
							<input type="text" id="input-name" class="xx-control"
								name="MEMBER_NAME" value="" required="required" label="이름">
						</div>
					</li>

					<li class="mail">
						<div class="item-label col-lg-3 col-md-4">
							<label for="input-mail"> <strong>* 이메일</strong>
							</label>
						</div>
						<div class="col-lg-21 col-md-20">
							<div class="input-box">
								<input type="text" name="MEMBER_EMAIL1" class="xx-control x01"
									label="이메일" required="required" value="${sessionScope.email1}"
									size="10" readonly> <span>@</span> <input type="text"
									name="MEMBER_EMAIL2" id="email2" class="xx-control x02"
									label="이메일" required="required" value="${sessionScope.email2}"
									size="20" readonly>

							</div>
					</li>



					<div class="btnArea">
						<!-- <input class="effect effect-5" type="submit" value="가입완료" /> -->
						<input class="button_" type="button" style=" width:90%;" onclick="checkpw();"
							value="가입완료" />
					</div>
				</ul>
				</section>
			</form>
		</div>
		<br><br><br>
	</div>
</body>
</html>


