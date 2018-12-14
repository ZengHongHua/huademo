package com.example.hua.normalusedemo.db;

import android.content.Context;

import com.example.hua.normalusedemo.dao.DaoMaster;
import com.example.hua.normalusedemo.dao.GoodsInfoDao;
import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

/**
 * 数据库升级管理
 * Created by ZengHongHua on 2018/1/18.
 */

public class YatOpenHelper extends DaoMaster.OpenHelper {

    public YatOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //配置数据库升级
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
                    @Override
                    public void onCreateAllTables(Database db, boolean ifNotExists) {
                        DaoMaster.createAllTables(db, ifNotExists);
                    }

                    @Override
                    public void onDropAllTables(Database db, boolean ifExists) {
                        DaoMaster.dropAllTables(db, ifExists);
                    }
                }, GoodsInfoDao.class
        );

        /*switch (oldVersion) {
            case 1:
                break;
            case 2:
                //添加字段
                //db.execSQL("ALTER TABLE 'STUDENT' ADD 'SCORE' TEXT;");
                break;
        }*/
    }
}
