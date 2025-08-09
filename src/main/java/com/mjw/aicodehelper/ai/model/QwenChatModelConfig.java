//package com.mjw.aicodehelper.ai.model;
//
//import dev.langchain4j.community.model.dashscope.QwenChatModel;
//import dev.langchain4j.model.chat.ChatModel;
//import dev.langchain4j.model.chat.listener.ChatModelListener;
//
//import jakarta.annotation.Resource;
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//import java.util.List;
//
///**
// * @Author 毛嘉伟
// * @Date 2025/08/09 18:28 （可以根据需要修改）
// * @Version 1.0 （版本号）
// */
//
//@Configuration
//@Data
//public class QwenChatModelConfig {
//
//    private String modelName;
//
//    private String apiKey;
//
//    @Resource
//    private ChatModelListener chatModelListener;
//
//    @Bean
//    public ChatModel myOwenChatModel() {
//        return QwenChatModel.builder()
//                .modelName(modelName)
//                .apiKey(apiKey)
//                .listeners(List.of(chatModelListener))
//                .build();
//    }
//}