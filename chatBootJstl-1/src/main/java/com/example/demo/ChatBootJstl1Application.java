package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatBootJstl1Application {

	public static void main(String[] args) {
		SpringApplication.run(ChatBootJstl1Application.class, args);
	}

	
//	<c:forEach var="chat" items="${chatList}">
//    <tr>
//        <td><p>${chat.subject}</p></td>
//        <td><p>${chat.name}</p></td>
//        <td><p>${chat.content}</p></td>
//    </tr>
//</c:forEach>

}
