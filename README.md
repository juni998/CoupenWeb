## :arrow_forward:CoupenWeb

> CoupenWeb E-commerce

<br>

## 1. 제작 기간 & 참여 인원

- 2021.04 ~ 2021.07
- 팀 프로젝트 (2인)
- Front-End 담당

<br>

## 2. 사용 기술

#### `Back-End`
- Java 11
- Spring Boot
- Gradle
- Spring Data JPA
- QueryDSL
- H2
- MariaDB
- Spring Security

#### `Front-end`
- thymeleaf
- ajax


<br>

## 3. 주요 기능
### 3.1 Spring Security 에서 ajax post 통신시 오류
- ajax post 통신시 데이터가 전송되지 않는 오류 발생
- Spring Security에서 ajax post 방식을 이용할 때 csrf프로텍션이 적용되는 것을 확인
- 데이터를 전송하기 전 헤더에 csrf값을 설정하여 ajax 통신하는 것으로 해결
<details>
<summary><b>해당 코드</b></summary>
<div markdown="1">

~~~java
<head>
	/*csrf값 설정*/
	<meta name="_csrf" th:content="${_csrf.token}"/>
	<meta name="_csrf_header" th:content="${_csrf.headerName}"/>
</head>
	
<body>
	/*내용 생략*/
</body>
	
<script>
function infoCheck(){
    var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var form = document.loginCheck;
	var account = $('#username').val();
	var password = $('#password').val();
	var data = {account : account, password : password}

    $.ajax({
		type : "post",
		url : "/pwCheck",
		data : data,
		beforeSend : function(xhr){   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
				xhr.setRequestHeader(header, token);
        },
        success : function(result){
            if(result){
                form.submit();
            }else{
                $('#loginMsg').html("아이디 또는 비밀번호가 일치하지 않습니다.");
                $("#loginMsg").css("color", "red");
            }

        },
        error : function() {
               $('#loginMsg').html("계정이 존재하지 않습니다.");
                    $("#loginMsg").css("color", "red");
            }


        });
}
</script>
~~~
</div>
</details>

<br>

### 3.2 이미지를 Amazon S3에 업로드 하여 저장할 수 있도록 구현

- 이미지 파일을 데이터베이스에 저장하는 것은 데이터베이스 관리에 있어서 비효율적이라 생각했습니다.
- 따라서 이미지를 Amazon S3에 업로드 하여 저장하고, 데이터베이스에는 S3에 저장된 이미지의 URL을 저장하는 방식을 택했습니다.

