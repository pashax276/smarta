package com.lisnykov.service.addresume;

import com.lisnykov.model.entity.ResumeData;
import com.lisnykov.repository.resume.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pasha on 2/3/17.
 */
@Service
public class AddResumeServiceImpl implements AddResumeService {
    @Autowired
    private ResumeRepository resumeRepository;

    public void saveResume(ResumeData resumeDataDAO) {
        ResumeData resumeData = new ResumeData();

        resumeData.setAddress(resumeDataDAO.getAddress());
        resumeData.setAge(resumeDataDAO.getAge());
        resumeData.setCountry(resumeDataDAO.getCountry());
        resumeData.setEducation(resumeDataDAO.getEducation());
        resumeData.setExperience(resumeDataDAO.getExperience());
        resumeData.setEmail(resumeDataDAO.getEmail());
        resumeData.setExperience(resumeDataDAO.getExperience());
        resumeData.setGender(resumeDataDAO.getGender());
        resumeData.setLanguage(resumeDataDAO.getLanguage());
        resumeData.setLastName(resumeDataDAO.getLastName());
        resumeData.setFirstName(resumeDataDAO.getFirstName());
        resumeData.setPhone(resumeDataDAO.getPhone());
        resumeData.setPhoneType(resumeDataDAO.getPhoneType());
        resumeData.setWebsite(resumeDataDAO.getWebsite());
        resumeData.setZipCode(resumeDataDAO.getZipCode());

        resumeRepository.save(resumeData);
    }
}
