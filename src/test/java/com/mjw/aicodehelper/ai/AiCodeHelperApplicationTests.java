package com.mjw.aicodehelper.ai;

import com.mjw.aicodehelper.ai.AiCodeHelper;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeHelperApplicationTests {

    @Resource
    private AiCodeHelper aiCodeHelper;


    @Test
    void chat() {
       aiCodeHelper.chat("你好我叫伟嘉毛");
    }

    //如果有阿里云百炼送的免费额度，大家可以换成qwen-vl-plus模型，然后图片选一张没有反扒机制的图片就好了，可以去bing里面搜一张
    @Test
    void chatWithMessage() {
        UserMessage userMessage = UserMessage.from(
                TextContent.from("描述一下这张图片"),
                ImageContent.from("https://tse2-mm.cn.bing.net/th/id/OIP-C.l7StzaQZuDHBabhKy1WQEgHaHY?w=167&h=180&c=7&r=0&o=7&dpr=1.5&pid=1.7&rm=3")
        );
        aiCodeHelper.chatWithMessage(userMessage);
    }
}
