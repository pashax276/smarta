package com.lisnykov.service.addgamedata;

import com.lisnykov.model.entity.GameData;
import com.lisnykov.repository.gamedata.GameDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pasha on 2/4/17.
 */
@Service
public class AddGameDataServiceImpl implements AddGameDataService{

    @Autowired
    private GameDataRepository gameDataRepository;

    public void saveGameData(GameData gameDataDAO) {
        GameData gameData = new GameData();

        gameData.setName(gameDataDAO.getName());
        gameData.setAnswer(gameDataDAO.getAnswer());
        gameData.setPoints(gameDataDAO.getPoints());
        gameData.setQuestion(gameDataDAO.getQuestion());
        gameData.setType(gameDataDAO.getType());

        gameDataRepository.save(gameData);

    }
}
