package com.example.demo.model.project;

import com.example.demo.model.CommonDTO;

public class ProjectTDescr extends CommonDTO {
    private  String pr_id;
    private  String pr_name;
    private String pr_start_date;
    private String pr_end_date;
    private String pr_pm;
    private String pr_client;

    public String getPr_id() {
        return pr_id;
    }

    public void setPr_id(String pr_id) {
        this.pr_id = pr_id;
    }

    private String pr_price;
    private  String pr_termination;

    public String getPr_termination() {
        return pr_termination;
    }

    public void setPr_termination(String pr_termination) {
        this.pr_termination = pr_termination;
    }

    public  String getPr_name() {
        return pr_name;
    }

    public void setPr_name(String pr_name) {
        this.pr_name = pr_name;
    }

    public String getPr_start_date() {
        return pr_start_date;
    }

    public void setPr_start_date(String pr_start_date) {
        this.pr_start_date = pr_start_date;
    }

    public String getPr_end_date() {
        return pr_end_date;
    }

    public void setPr_end_date(String pr_end_date) {
        this.pr_end_date = pr_end_date;
    }

    public String getPr_pm() {
        return pr_pm;
    }

    public void setPr_pm(String pr_pm) {
        this.pr_pm = pr_pm;
    }

    public String getPr_client() {
        return pr_client;
    }

    public void setPr_client(String pr_client) {
        this.pr_client = pr_client;
    }

    public String getPr_price() {
        return pr_price;
    }

    public void setPr_price(String pr_price) {
        this.pr_price = pr_price;
    }
    @Override
    public String toString() {
        return "Project{" +
                "pr_name=" + pr_name +
                ", pr_start_date=" + pr_start_date +
                ", pr_end_date='" + pr_end_date +
                ", pr_pm='" + pr_pm +
                ", pr_client='" + pr_client +
                ", pr_price='" + pr_price +
                ", pr_termination='" + pr_termination +
                '}';
    }

}
