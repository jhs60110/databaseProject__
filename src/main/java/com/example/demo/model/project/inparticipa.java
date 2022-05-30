package com.example.demo.model.project;

import com.example.demo.model.CommonDTO;

public class inparticipa extends CommonDTO {
    private String e_id_;
    private String e_name;
    private String pr_id_;
    private String p_des;
    private String p_start_;
    private String p_end_;
    private String p_role_;

    public String[][] getResponses() {
        return responses;
    }

    public void setResponses(String[][] responses) {
        this.responses = responses;
    }

    private String[][] responses;

    public String getE_id_() {
        return e_id_;
    }

    public void setE_id_(String e_id_) {
        this.e_id_ = e_id_;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getPr_id_() {
        return pr_id_;
    }

    public void setPr_id_(String pr_id_) {
        this.pr_id_ = pr_id_;
    }

    public String getP_des() {
        return p_des;
    }

    public void setP_des(String p_des) {
        this.p_des = p_des;
    }

    public String getP_start_() {
        return p_start_;
    }

    public void setP_start_(String p_start_) {
        this.p_start_ = p_start_;
    }

    public String getP_end_() {
        return p_end_;
    }

    public void setP_end_(String p_end_) {
        this.p_end_ = p_end_;
    }

    public String getP_role_() {
        return p_role_;
    }

    public void setP_role_(String p_role_) {
        this.p_role_ = p_role_;
    }

    @Override
    public String toString() {
        return "inparticipa{" +
                "pr_id_=" + pr_id_ +
                ", e_id_=" + e_id_ +
                ", p_des='" + p_des +
                ", p_start_='" + p_start_ +
                ", p_end_='" + p_end_ +
                ", p_role_='" + p_role_ +
                ", e_name='" + e_name +
                '}';
    }

}
