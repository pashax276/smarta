package com.lisnykov.repository.resume;

import com.lisnykov.model.entity.ResumeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pasha on 2/3/17.
 */
@Repository
public interface ResumeRepository extends JpaRepository<ResumeData, Integer> {


}
