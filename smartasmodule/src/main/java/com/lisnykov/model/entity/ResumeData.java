package com.lisnykov.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by pasha on 2/1/17.
 */
@Entity
@Table(name = "RESUME")
public class ResumeData {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer Id;

    @NotNull(message = "First name is required")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @NotNull(message = "Email is required")
    //@Pattern(regexp = ".+@.+\\\\.[a-z]+", message = "must be valid(ex.: name@gmail.com)")
    @Column(name = "EMAIL")
    private String email;

    //@NotNull(message = "Phone number is required")
    @Column(name = "PHONE")
    private String phone;

    @Column(name = "PHONE_TYPE")
    private String phoneType;

    @Column(name = "WEBSITE")
    private String website;

    @NotNull(message = "Education is required")
    @Column(name = "EDUCATION")
    private String education;

    //@NotNull(message = "Experience is required")
    @Column(name = "EXPERIENCE")
    private String experience;

    @Column(name = "LANGUAGE")
    private String language;

    @NotNull(message = "Gender is required")
    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ZIP_CODE")
    private Integer zipCode;

    @Column(name = "COUNTRY")
    private String country;

    @Min(value = 0, message = "Minimum value is 0")
    @Max(value = 100, message = "Maximum value is 100")
    @Column(name = "AGE")
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

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
