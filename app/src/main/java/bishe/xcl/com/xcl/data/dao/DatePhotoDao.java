package bishe.xcl.com.xcl.data.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import bishe.xcl.com.xcl.data.bean.DatePhoto;
import bishe.xcl.com.xcl.data.helper.DatabaseHelper;

public class DatePhotoDao {
    private Dao<DatePhoto, Integer> dao;
    private DatabaseHelper helper;

    public DatePhotoDao(Context context) {
        try {
            helper = DatabaseHelper.getHelper(context);
            dao = helper.getDao(DatePhoto.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加一个用户
     * @param DatePhoto
     */
    public void add(DatePhoto DatePhoto) {
        try {
            dao.create(DatePhoto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DatePhoto getDatePhotoWithId(int id) {
        DatePhoto DatePhoto = null;
        try {
            DatePhoto = dao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DatePhoto;
    }

    public DatePhoto photoByDate(String date) {
        try {
            return dao.queryBuilder().where().eq("data", date).query().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
