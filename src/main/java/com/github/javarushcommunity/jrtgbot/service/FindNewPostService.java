package com.github.javarushcommunity.jrtgbot.service;

/**
 * Service for finding new posts.
 */
public interface FindNewPostService {

    /**
     * Find new posts and notify subscribers about it.
     */
    void findNewPosts();
}