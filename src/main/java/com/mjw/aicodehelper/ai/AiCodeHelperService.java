package com.mjw.aicodehelper.ai;

import com.mjw.aicodehelper.ai.guardrail.SafeInputGuardrail;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.guardrail.InputGuardrails;
import dev.langchain4j.service.spring.AiService;

import java.util.List;

/**
 * @Author 毛嘉伟
 * @Date 2025/08/07 19:57 （可以根据需要修改）
 * AI Service高层服务 方便但不灵活
 * @Version 1.0 （版本号）
 */

//@AiService缺少一定灵活性
@InputGuardrails({SafeInputGuardrail.class})
public interface AiCodeHelperService {
    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String userMessage);
    //多用户隔离
    //String chat(@MemoryId int memoryId ,String userMessage);

    //结构化输出
    // 定义一个注解 @SystemMessage
    @SystemMessage(fromResource = "system-prompt.txt")
    Report chatForReport(String userMessage);

    // 学习报告 record当成一个类即可
    record Report(String name, List<String> suggestionList) {}

    // 返回封装后的结果
    @SystemMessage(fromResource = "system-prompt.txt")
    Result<String> chatWithRag(String userMessage);
}
