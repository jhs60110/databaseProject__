package com.example.demo.model.project;

import com.example.demo.model.CommonDTO;

public class Participant extends CommonDTO {
    private String e_id;
    private String e_name;
    private String pr_id;
    private String p_description;
    private String p_start_date;
    private String p_end_date;
    private String p_role;

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getPr_id() {
        return pr_id;
    }

    public void setPr_id(String pr_id) {
        this.pr_id = pr_id;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    public String getP_start_date() {
        return p_start_date;
    }

    public void setP_start_date(String p_start_date) {
        this.p_start_date = p_start_date;
    }

    public String getP_end_date() {
        return p_end_date;
    }

    public void setP_end_date(String p_end_date) {
        this.p_end_date = p_end_date;
    }

    public String getP_role() {
        return p_role;
    }

    public void setP_role(String p_role) {
        this.p_role = p_role;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "e_id=" + e_id +
                ", e_name=" + e_name +
                ", pr_id='" + pr_id +
                ", p_description='" + p_description +
                ", p_start_date='" + p_start_date +
                ", p_end_date='" + p_end_date +
                ", p_role='" + p_role +
                '}';
    }

}
