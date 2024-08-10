package com.github.javarushcommunity.jrtgbot.service;

import com.github.javarushcommunity.jrtgbot.javarushclient.dto.GroupDiscussionInfo;
import com.github.javarushcommunity.jrtgbot.repository.entity.GroupSub;

import java.util.List;
import java.util.Optional;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(Long chatId, GroupDiscussionInfo groupDiscussionInfo);

    GroupSub save(GroupSub groupSub);

    Optional<GroupSub> findById(Integer id);

    List<GroupSub> findAll();}