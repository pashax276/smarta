package com.lisnykov.repository.gamedata;

import com.lisnykov.model.entity.GameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pasha on 2/4/17.
 */
@Repository
public interface GameDataRepository extends JpaRepository<GameData, Integer>{

    @Query(value = "SELECT q FROM GameData q ORDER BY q.name")
    List<GameData> getAllData();
}
