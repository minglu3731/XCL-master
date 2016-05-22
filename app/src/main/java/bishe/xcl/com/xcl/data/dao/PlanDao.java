package bishe.xcl.com.xcl.data.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import bishe.xcl.com.xcl.data.bean.Plan;
import bishe.xcl.com.xcl.data.helper.DatabaseHelper;

public class PlanDao {

    private Dao<Plan, Integer> dao;
    private DatabaseHelper helper;

    public PlanDao(Context context) {
        try {
            helper = DatabaseHelper.getHelper(context);
            dao = helper.getDao(Plan.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Plan plan) {
        try {
            dao.create(plan);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Plan getPlanWithId(int id) {
        Plan plan = null;
        try {
            plan = dao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plan;
    }

    public List<Plan> listByDate(String date) {
        try {
            return dao.queryBuilder().where().eq("data", date).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
