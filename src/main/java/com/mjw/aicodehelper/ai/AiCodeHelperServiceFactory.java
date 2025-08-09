package com.mjw.aicodehelper.ai;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;

import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 毛嘉伟
 * @Date 2025/08/07 20:04 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */

@Configuration
public class AiCodeHelperServiceFactory {
    @Resource
    private ChatModel qwenChatModel;
    @Resource
    private ContentRetriever contentRetriever;

    @Bean
    public AiCodeHelperService aiCodeHelperService() {
        // 会话记忆
        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        // 构造 AI Service
        AiCodeHelperService aiCodeHelperService = AiServices.builder(AiCodeHelperService.class)
                .chatModel(qwenChatModel)
                .chatMemory(chatMemory)// 会话记忆
                //.chatMemoryProvider(memoryId->MessageWindowChatMemory.withMaxMessages(10))//多用户隔离
                .contentRetriever(contentRetriever)
                .build();

        return aiCodeHelperService;
    }
}