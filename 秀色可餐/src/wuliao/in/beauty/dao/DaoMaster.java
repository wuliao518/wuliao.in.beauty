package wuliao.in.beauty.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import wuliao.in.beauty.dao.UserDao;
import wuliao.in.beauty.dao.SbjectDao;
import wuliao.in.beauty.dao.SourceDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 1): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        UserDao.createTable(db, ifNotExists);
        SbjectDao.createTable(db, ifNotExists);
        SourceDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        UserDao.dropTable(db, ifExists);
        SbjectDao.dropTable(db, ifExists);
        SourceDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(UserDao.class);
        registerDaoClass(SbjectDao.class);
        registerDaoClass(SourceDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
    
//    private static void addUser(Schema schema)
//    {
//        //增加User表
//		Entity user = schema.addEntity("User");
//        user.setTableName("wu_user");
//        user.addLongProperty("user_id").primaryKey().autoincrement();
//        user.addStringProperty("user_name").notNull();
//        user.addStringProperty("password").notNull();
//        user.addStringProperty("email").notNull(); 
//        user.addStringProperty("user_img").notNull();
//        user.addStringProperty("user_info");
//        user.addStringProperty("add_time");
//        //增加Subject表
//        Entity subject = schema.addEntity("Sbject");
//        subject.setTableName("wu_subject");
//        subject.addLongProperty("subject_id").primaryKey().autoincrement();
//        Property userId=subject.addLongProperty("user_id").getProperty();
//        subject.addStringProperty("sub_title").notNull();
//        subject.addStringProperty("add_time").notNull(); 
//        Property modifyTime=subject.addStringProperty("modify_time").notNull().getProperty(); 
//        subject.addStringProperty("page_photo").notNull();
//        //增加Source表
//        Entity source = schema.addEntity("Source");
//        source.setTableName("wu_source");
//        source.addLongProperty("source_id").primaryKey().autoincrement();
//        Property subject_id=source.addLongProperty("subject_id").getProperty();
//        source.addStringProperty("content_image").notNull();
//        source.addStringProperty("content").notNull();
//        Property addTime=source.addStringProperty("add_time").notNull().getProperty();
//        source.addStringProperty("modify_time");
//        source.addIntProperty("like_num");
//        //建立映射关系
//        //user=====>subject
//        subject.addToOne(user, userId);
//        ToMany userToSuject=user.addToMany(subject, userId);
//        userToSuject.setName("subjects");
//        userToSuject.orderDesc(modifyTime);
//        //subject=====>source
//        source.addToOne(subject, subject_id);
//        ToMany subjectToSource=subject.addToMany(source, subject_id);
//        subjectToSource.setName("sources");
//        subjectToSource.orderAsc(addTime);;
//        //行南走北，一生输给平均值;忙东搞西，半辈
//    }
    

    
    
    
}
