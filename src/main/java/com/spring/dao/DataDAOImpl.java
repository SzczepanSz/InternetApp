package com.spring.dao;
//import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.spring.model.Data;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAOImpl implements DataDAO {
    private static final String DATA_ID = "id";
    private static final String DATA_NUMBER = "number";
    private static final String DATA_SYSTEM = "systems";
    private static final String DATA_FROM = "from";
    private static final String DATA_TILL = "till";
    private static final String DATA_INCOME = "income";
    private static final String DATA_SCALE = "scale";
    private static final String DATA_ACTIVE = "active";

    private final String url = "jdbc:postgresql://localhost:5433/postgres";
    private final String user = "postgres";
    private final String password = "holandia";

    private String SQLinsert = "INSERT INTO data "
            + "(id, number, system, from, till, income, scale, active)"
            + "VALUES (?,?,?,?,?,?,?,?) ";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addData(Data data) {

        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQLinsert)) {

            statement.setString(1, data.getNumber());
            statement.setString(2, data.getSystem());
            statement.setDate(3, data.getFrom());
            statement.setDate(4, data.getTill());
            statement.setInt(5, data.getIncome());
            statement.setString(6, data.getScale());
            statement.setString(7, data.getActive());

            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void updateData(Data data) {
        String SQLupdate = "UPDATE data "
                + "SET number =?, systems = ?, fromm = ? , till = ?, income = ?, "
                + "scale = ?, active = ? " + "WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQLupdate)) {
            statement.setString(1, data.getNumber());
            statement.setString(2, data.getSystem());
            statement.setDate(3, data.getFrom());
            statement.setDate(4, data.getTill());
            statement.setInt(5, data.getIncome());
            statement.setString(6, data.getScale());
            statement.setString(7, data.getActive());

            statement.setInt(9, data.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Data getDataById(int id) {
        String SQLgetData = "SELECT  id, systems ,number, fromm, till, income,"
                + " scale, active " + "FROM datatable ";
        Data data = new Data();

        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQLgetData)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                data.setId(rs.getInt(DATA_ID));
                data.setNumber(rs.getString(DATA_NUMBER));
                data.setSystem(rs.getString(DATA_SYSTEM));
                data.setFrom(rs.getDate(DATA_FROM));
                data.setTill(rs.getDate(DATA_TILL));
                data.setIncome(rs.getInt(DATA_INCOME));
                data.setScale(rs.getString(DATA_SCALE));
                data.setActive(DATA_ACTIVE);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return data;
    }

    public void deleteData(int id) {
        String SQLDelete = "DELETE FROM data WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQLDelete)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Data> selectDataByActive(boolean dataActive) {
        String SQLSelectModel = "SELECT id, make, model, year, fuel,"
                + " engine, gearbox, color, kilometer  "
                + "FROM data WHERE model = ?";
        List<Data> foundDataList = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement statement = conn
                     .prepareStatement(SQLSelectModel)) {

            statement.setString(1, String.valueOf(dataActive));

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Data data = new Data();
                data.setId(rs.getInt(DATA_ID));
                data.setNumber(rs.getString(DATA_NUMBER));
                data.setSystem(rs.getString(DATA_SYSTEM));
                data.setFrom(rs.getDate(DATA_FROM));
                data.setTill(rs.getDate(DATA_TILL));
                data.setIncome(rs.getInt(DATA_INCOME));
                data.setScale(rs.getString(DATA_SCALE));
                data.setActive(DATA_ACTIVE);
                foundDataList.add(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundDataList;
    }



    public void addData(List<Data> dataList) {

        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQLinsert,
                     Statement.RETURN_GENERATED_KEYS)) {

            conn.setAutoCommit(false);

            for (Data data : dataList) {
                statement.setString(1, data.getNumber());
                statement.setString(2, data.getSystem());
                statement.setDate(3, data.getFrom());
                statement.setDate(4, data.getTill());
                statement.setInt(5, data.getIncome());
                statement.setString(6, data.getScale());
                statement.setString(7, data.getActive());
                statement.addBatch();
            }

            statement.executeBatch();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Data> listData() {
        String SQLSelectModel = "SELECT  ID, number, fromm, till, income,"
                + " scale, active " + "FROM datatable ";
        List<Data> foundDataList = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement statement = conn
                     .prepareStatement(SQLSelectModel)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Data data = new Data();
                data.setId(rs.getInt(DATA_ID));
                data.setNumber(rs.getString(DATA_NUMBER));
                data.setSystem(rs.getString(DATA_SYSTEM));
                data.setFrom(rs.getDate(DATA_FROM));
                data.setTill(rs.getDate(DATA_TILL));
                data.setIncome(rs.getInt(DATA_INCOME));
                data.setScale(rs.getString(DATA_SCALE));
                data.setActive(DATA_ACTIVE);

                foundDataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundDataList;
    }

}
