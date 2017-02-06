package com.lisnykov.service.remove;

import com.lisnykov.model.entity.GameData;
import com.lisnykov.repository.gamedata.GameDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pasha on 2/5/17.
 */

@Service
public class RemoveGameDataServiceImpl implements RemoveGameDataService {

    @Autowired
    private GameDataRepository gameDataRepository;

    public void removeGameData(GameData gameData) {
        gameDataRepository.delete(gameData);
    }
}
