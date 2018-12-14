package com.example.hua.normalusedemo.db;

import android.content.Context;


import com.example.hua.normalusedemo.dao.DaoMaster;
import com.example.hua.normalusedemo.dao.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * 数据库核心类
 * Created by ZengHongHua on 2018/1/8.
 */
public class DbCore {
    private static final String DEFAULT_DB_NAME = "radio_player.db";
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static Context mContext;
    private static String DB_NAME;

    public static void init(Context context) {
        init(context, DEFAULT_DB_NAME);
    }

    public static void init(Context context, String dbName) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        mContext = context.getApplicationContext();
        DB_NAME = dbName;
    }

    public static DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            synchronized (DbCore.class) {
                if (daoMaster == null) {
                    //第一版本开发时可用DevOpenHelper
                    //此处不可用 DaoMaster.DevOpenHelper, 那是开发辅助类，我们要自定义一个，方便升级
                    DaoMaster.OpenHelper helper = new YatOpenHelper(mContext, DB_NAME);
                    daoMaster = new DaoMaster(helper.getWritableDatabase());
                }
            }
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    public static void enableQueryBuilderLog() {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

}
