## :arrow_forward:CoupenWeb

> CoupenWeb E-commerce

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

#### 'other'
- Junit 5
- Amazon S3
- Amazon EC2

<br>

## 3. 트러블 슈팅
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

## 4. 회고 / 느낀점
Spring Boot와 JPA를 이용하여 웹 애플리케이션 개발 경험
<details>
<summary><b>느낀점</b></summary>
<div markdown="1">
Spring Boot과 JPA를 처음 알게 되어 프로젝트를 진행했다
처음이라 역시 아쉬움이 많이 남는 프로젝트였다 부트와 JPA를 처음 사용해보며,
<br><br>
프로젝트 시작 시기에 팀원 한 분은 취업에 성공하여, 한 분은 개인 사정으로 떠나게 되었기 때문에 배포까지 계획했었지만 그럴 수 없었던 점이 아쉬움이 크게 남는다.
<br><br>
하지만 팀원과 소통하며, 밤낮으로 같이 프로젝트를 진행했던 기억이 즐거웠으며, 많이 배우게 된 계기가 된 것 같다. 회고를 쓰는 지금은 프로젝트를 끝낸 지 10개월 정도 지난 후인데 이제 와서 코드를 다시 보면 뜯어고치고 싶은 부분이 많다. 
<br><br>
설계부터 시작해서 배포까지 해보는 개인 프로젝트를 진행해 보고 싶어서 우선순위에서 밀리게 됐지만, 개인 프로젝트 종료 후 아쉬움이 남는 첫 프로젝트를 리팩토링 해서 배포까지 다시 한번 해봐야겠다고 생각을 한다.
</div>
</details>
