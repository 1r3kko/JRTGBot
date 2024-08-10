package com.github.javarushcommunity.jrtgbot.service;

import com.github.javarushcommunity.jrtgbot.dto.StatisticDTO;

/**
 * Service for getting bot statistics.
 */
public interface StatisticsService {
    StatisticDTO countBotStatistic();
}