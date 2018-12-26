package com.ipapon.line_bot_spring_boot.linebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;


@SpringBootApplication
@LineMessageHandler
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@EventMapping
    public Message handleTextMessage(MessageEvent<TextMessageContent> e) {
        System.out.println("event: " + e);
        TextMessageContent message = e.getMessage();
       
        return new TextMessage(message.getText());
    }

}
