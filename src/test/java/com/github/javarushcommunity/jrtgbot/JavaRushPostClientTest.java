package com.github.javarushcommunity.jrtgbot;

import com.github.javarushcommunity.jrtgbot.javarushclient.JavaRushPostClient;
import com.github.javarushcommunity.jrtgbot.javarushclient.JavaRushPostClientImpl;
import com.github.javarushcommunity.jrtgbot.javarushclient.dto.PostInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.javarushcommunity.jrtgbot.JavaRushGroupClientTest.JAVARUSH_API_PATH;

@DisplayName("Integration-level testing for JavaRushPostClient")
class JavaRushPostClientTest {

    private final JavaRushPostClient postClient = new JavaRushPostClientImpl(JAVARUSH_API_PATH);

    @Test
    public void shouldProperlyGetNew15Posts() {
        //when
        List<PostInfo> newPosts = postClient.findNewPosts(30, 2935);

        //then
        Assertions.assertEquals(15, newPosts.size());
    }
}