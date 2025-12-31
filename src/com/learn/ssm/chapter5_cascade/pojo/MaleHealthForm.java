package com.learn.ssm.chapter5_cascade.pojo;

public class MaleHealthForm extends HealthForm {
    private String prostate;

    public String getProstate() {
        return prostate;
    }

    public void setProstate(String prostate) { this.prostate = prostate; }

    @Override
    public String toString() {
        return "MaleHealthForm{" +
                "id=" + id +
                ", empId=" + empId +
                ", heart='" + heart + '\'' +
                ", liver='" + liver + '\'' +
                ", spleen='" + spleen + '\'' +
                ", lung='" + lung + '\'' +
                ", kidney='" + kidney + '\'' +
                ", prostate='" + prostate + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
