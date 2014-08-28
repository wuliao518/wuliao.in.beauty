package wuliao.in.beauty.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import wuliao.in.beauty.dao.Sbject;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table wu_subject.
*/
public class SbjectDao extends AbstractDao<Sbject, Long> {

    public static final String TABLENAME = "wu_subject";

    /**
     * Properties of entity Sbject.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Subject_id = new Property(0, Long.class, "subject_id", true, "SUBJECT_ID");
        public final static Property User_id = new Property(1, Long.class, "user_id", false, "USER_ID");
        public final static Property Sub_title = new Property(2, String.class, "sub_title", false, "SUB_TITLE");
        public final static Property Add_time = new Property(3, String.class, "add_time", false, "ADD_TIME");
        public final static Property Modify_time = new Property(4, String.class, "modify_time", false, "MODIFY_TIME");
        public final static Property Page_photo = new Property(5, String.class, "page_photo", false, "PAGE_PHOTO");
    };

    private DaoSession daoSession;

    private Query<Sbject> user_SubjectsQuery;

    public SbjectDao(DaoConfig config) {
        super(config);
    }
    
    public SbjectDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'wu_subject' (" + //
                "'SUBJECT_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: subject_id
                "'USER_ID' INTEGER," + // 1: user_id
                "'SUB_TITLE' TEXT NOT NULL ," + // 2: sub_title
                "'ADD_TIME' TEXT NOT NULL ," + // 3: add_time
                "'MODIFY_TIME' TEXT NOT NULL ," + // 4: modify_time
                "'PAGE_PHOTO' TEXT NOT NULL );"); // 5: page_photo
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'wu_subject'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Sbject entity) {
        stmt.clearBindings();
 
        Long subject_id = entity.getSubject_id();
        if (subject_id != null) {
            stmt.bindLong(1, subject_id);
        }
 
        Long user_id = entity.getUser_id();
        if (user_id != null) {
            stmt.bindLong(2, user_id);
        }
        stmt.bindString(3, entity.getSub_title());
        stmt.bindString(4, entity.getAdd_time());
        stmt.bindString(5, entity.getModify_time());
        stmt.bindString(6, entity.getPage_photo());
    }

    @Override
    protected void attachEntity(Sbject entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Sbject readEntity(Cursor cursor, int offset) {
        Sbject entity = new Sbject( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // subject_id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // user_id
            cursor.getString(offset + 2), // sub_title
            cursor.getString(offset + 3), // add_time
            cursor.getString(offset + 4), // modify_time
            cursor.getString(offset + 5) // page_photo
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Sbject entity, int offset) {
        entity.setSubject_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUser_id(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setSub_title(cursor.getString(offset + 2));
        entity.setAdd_time(cursor.getString(offset + 3));
        entity.setModify_time(cursor.getString(offset + 4));
        entity.setPage_photo(cursor.getString(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Sbject entity, long rowId) {
        entity.setSubject_id(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Sbject entity) {
        if(entity != null) {
            return entity.getSubject_id();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "subjects" to-many relationship of User. */
    public List<Sbject> _queryUser_Subjects(Long user_id) {
        synchronized (this) {
            if (user_SubjectsQuery == null) {
                QueryBuilder<Sbject> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.User_id.eq(null));
                queryBuilder.orderRaw("MODIFY_TIME DESC");
                user_SubjectsQuery = queryBuilder.build();
            }
        }
        Query<Sbject> query = user_SubjectsQuery.forCurrentThread();
        query.setParameter(0, user_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUserDao().getAllColumns());
            builder.append(" FROM wu_subject T");
            builder.append(" LEFT JOIN wu_user T0 ON T.'USER_ID'=T0.'USER_ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Sbject loadCurrentDeep(Cursor cursor, boolean lock) {
        Sbject entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
        entity.setUser(user);

        return entity;    
    }

    public Sbject loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Sbject> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Sbject> list = new ArrayList<Sbject>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Sbject> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Sbject> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
