package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.model.Data;
import com.spring.dao.DataDAO;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService{
    @Autowired
    DataDAO dataDAO;

    public void setDataDAO(DataDAO dataDAOSpring){
        this.dataDAO = dataDAOSpring;
    }

    public void addData(Data c) {
        this.dataDAO.addData(c);
    }

    public void updateData(Data c) {
        this.dataDAO.updateData(c);
    }

    public Data getDataById(int id) {
        return this.dataDAO.getDataById(id);
    }

    public void deleteData(int id) {
        this.dataDAO.deleteData(id);
    }

    public List<Data> listData() {
        return this.dataDAO.listData();
    }

    public List<Data> selectDataByActive(boolean dataActive) {
        return this.dataDAO.selectDataByActive(dataActive);
    }


    public void addData(List<Data> dataList) {
        this.dataDAO.addData(dataList);
    }

}
