package com.spring.model;

//import java.util.Date;
import java.sql.Date;

public    class Data {

    private int id;
    private String number;
    private String system;
    private Date from ;
    private Date till ;
    private int income;
    private String scale;
    private String active;


    public Data() {}


    public Data(Integer dataId, String dataNumber, String dataSystem, Date dataFrom,
                Date dataTill, Integer dataIncome, String dataScale,
               String dataActive ) {
        this.id = dataId;
        this.number = dataNumber;
        this.system = dataSystem;
        this.from = dataFrom;
        this.till = dataTill;
        this.income = dataIncome;
        this.scale = dataScale;
        this.active = dataActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTill() {
        return till;
    }

    public void setTill(Date till) {
        this.till = till;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getActive () {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Data [id=" + id + ", number=" + number + ", system=" + system
                + ", from=" + from + ", till=" + till + ", income=" + income
                + ", scale=" + scale + ", active=" + active + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        if (id != other.id)
            return false;
        return true;
    }
}