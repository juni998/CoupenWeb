package com.group6.demo.entity;

public class LoginController {

    // Login header로 적용 thymeleaf 태크 #{auth.header.login}
//    @GetMapping("/login")
//    // 에러 메시지와 로그아웃 메시지를 파라미터로 사용
//    public String loginForm(String error, String logout, Model model) {
//        if (error != null) {
//            model.addAttribute("error", "Login Error!!!");
//        }
//        if (logout != null) {
//            model.addAttribute("logout", "Logout!!!");
//        }
//        return "auth/loginForm";
//    }



//<html xmlns:th="http://www.thymeleaf.org"
//    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
//    layout:decorate="~{/layouts/common_template}">
//<head>
//	<title>Login</title>
//	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
//</head>
//<body>
//<div layout:fragment="content">
//	<h2 th:text="#{auth.header.login}">로그인</h2>
//	<h2 th:text="${error}">${error}</h2>
//	<h2 th:text="${logout}">${logout}</h2>
//	<form method="post" action="../home.html" th:action="@{/auth/login}">
//		<table>
//			<tr>
//				<td>아이디</td>
//				<td><input type="text" name="username" value=""></td>
//			</tr>
//			<tr>
//				<td>비밀번호</td>
//				<td><input type="password" name="password" value=""></td>
//			</tr>
//			<tr>
//				<td colspan="2" align="center"><button th:text="#{action.login}">로그인</button></td>
//			</tr>
//		</table>
//	</form>
//</div>
//</body>
//</html>

}
