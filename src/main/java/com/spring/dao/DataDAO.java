package com.spring.dao;
import java.util.List;

import com.spring.model.Data;

public interface DataDAO {


    public void addData (Data c);
    public void updateData (Data c);
    public Data getDataById (int id);
    public void deleteData(int id);
    public List<Data> listData();
    public List<Data> selectDataByActive(boolean dataActive);
    public void addData(List<Data> dataList);

}
