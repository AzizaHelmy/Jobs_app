package com.example.jobsapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class JobsModel implements Serializable {
    @SerializedName("id")
    private String id;
    @SerializedName("type")
    private  String type;
    @SerializedName("url")
    private String url;
    @SerializedName("created_at")
    private String  dateOfJob;
    @SerializedName("company")
    private String companyName;
    @SerializedName("company_url")
    private String companyUrl;
    @SerializedName("location")
    private String location;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDateOfJob() {
        return dateOfJob;
    }

    public void setDateOfJob(String dateOfJob) {
        this.dateOfJob = dateOfJob;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
