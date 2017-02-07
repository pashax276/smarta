package com.lisnykov.service.showalldata;

import com.lisnykov.model.entity.GameData;
import com.lisnykov.repository.gamedata.GameDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pasha on 2/4/17.
 */
@Service
public class ShowAllGameDataServiceImpl implements ShowAllGameDataService {

    @Autowired
    private GameDataRepository gameDataRepository;

    public List<GameData> getAllGameData() {
        return gameDataRepository.getAllData();
    }

    public List<GameData> getGameDataType() {
        return gameDataRepository.ComboType();
    }
}
