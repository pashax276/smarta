package com.lisnykov.service.showalldata;

import com.lisnykov.model.entity.GameData;

import java.util.List;

/**
 * Created by pasha on 2/4/17.
 */
public interface ShowAllGameDataService {

    List<GameData> getAllGameData();

    List<GameData> getGameDataType();

}
