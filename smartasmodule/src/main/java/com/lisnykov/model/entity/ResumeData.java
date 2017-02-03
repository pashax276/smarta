package com.lisnykov.model.entity;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by pasha on 2/1/17.
 */

public class ResumeData {

    @NotNull(message = "First name is required")
    private String firstName;
    @NotNull(message = "Last name is required")
    private String lastName;
    private String address;

    @NotNull(message = "Email is required")
    //@Pattern(regexp = ".+@.+\\\\.[a-z]+", message = "must be valid(ex.: name@gmail.com)")
    private String email;

    @NotNull(message = "Phone number is required")
    private String phone;
    private String website;

    @NotNull(message = "Education is required")
    private String education;

    @NotNull(message = "Education is required")
    private String experience;
    private String language;

    @NotNull(message = "Gender is required")
    private String gender;
    private Integer zipCode;
    private String country;
    private String phoneType;

    @Min(value = 0, message = "Minimum value is 0")
    @Max(value = 100, message = "Maximun value is 100")
    private Integer age;

    public ResumeData() {

    }

    public ResumeData(String firstName, String lastName, String address, String email, String phone, String website,
                      String education, String experience, String language, String gender, Integer zipCode,
                      String country, String phoneType, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.education = education;
        this.experience = experience;
        this.language = language;
        this.gender = gender;
        this.zipCode = zipCode;
        this.country = country;
        this.phoneType = phoneType;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ResumeData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", education='" + education + '\'' +
                ", experience='" + experience + '\'' +
                ", language='" + language + '\'' +
                ", gender='" + gender + '\'' +
                ", zipCode=" + zipCode +
                ", country='" + country + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", age=" + age +
                '}';
    }
}
