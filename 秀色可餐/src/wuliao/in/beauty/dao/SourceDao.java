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

import wuliao.in.beauty.dao.Source;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table wu_source.
*/
public class SourceDao extends AbstractDao<Source, Long> {

    public static final String TABLENAME = "wu_source";

    /**
     * Properties of entity Source.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Source_id = new Property(0, Long.class, "source_id", true, "SOURCE_ID");
        public final static Property Subject_id = new Property(1, Long.class, "subject_id", false, "SUBJECT_ID");
        public final static Property Content_image = new Property(2, String.class, "content_image", false, "CONTENT_IMAGE");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public final static Property Add_time = new Property(4, String.class, "add_time", false, "ADD_TIME");
        public final static Property Modify_time = new Property(5, String.class, "modify_time", false, "MODIFY_TIME");
        public final static Property Like_num = new Property(6, Integer.class, "like_num", false, "LIKE_NUM");
    };

    private DaoSession daoSession;

    private Query<Source> sbject_SourcesQuery;

    public SourceDao(DaoConfig config) {
        super(config);
    }
    
    public SourceDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'wu_source' (" + //
                "'SOURCE_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: source_id
                "'SUBJECT_ID' INTEGER," + // 1: subject_id
                "'CONTENT_IMAGE' TEXT NOT NULL ," + // 2: content_image
                "'CONTENT' TEXT NOT NULL ," + // 3: content
                "'ADD_TIME' TEXT NOT NULL ," + // 4: add_time
                "'MODIFY_TIME' TEXT," + // 5: modify_time
                "'LIKE_NUM' INTEGER);"); // 6: like_num
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'wu_source'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Source entity) {
        stmt.clearBindings();
 
        Long source_id = entity.getSource_id();
        if (source_id != null) {
            stmt.bindLong(1, source_id);
        }
 
        Long subject_id = entity.getSubject_id();
        if (subject_id != null) {
            stmt.bindLong(2, subject_id);
        }
        stmt.bindString(3, entity.getContent_image());
        stmt.bindString(4, entity.getContent());
        stmt.bindString(5, entity.getAdd_time());
 
        String modify_time = entity.getModify_time();
        if (modify_time != null) {
            stmt.bindString(6, modify_time);
        }
 
        Integer like_num = entity.getLike_num();
        if (like_num != null) {
            stmt.bindLong(7, like_num);
        }
    }

    @Override
    protected void attachEntity(Source entity) {
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
    public Source readEntity(Cursor cursor, int offset) {
        Source entity = new Source( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // source_id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // subject_id
            cursor.getString(offset + 2), // content_image
            cursor.getString(offset + 3), // content
            cursor.getString(offset + 4), // add_time
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // modify_time
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6) // like_num
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Source entity, int offset) {
        entity.setSource_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSubject_id(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setContent_image(cursor.getString(offset + 2));
        entity.setContent(cursor.getString(offset + 3));
        entity.setAdd_time(cursor.getString(offset + 4));
        entity.setModify_time(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setLike_num(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Source entity, long rowId) {
        entity.setSource_id(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Source entity) {
        if(entity != null) {
            return entity.getSource_id();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "sources" to-many relationship of Sbject. */
    public List<Source> _querySbject_Sources(Long subject_id) {
        synchronized (this) {
            if (sbject_SourcesQuery == null) {
                QueryBuilder<Source> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Subject_id.eq(null));
                queryBuilder.orderRaw("ADD_TIME ASC");
                sbject_SourcesQuery = queryBuilder.build();
            }
        }
        Query<Source> query = sbject_SourcesQuery.forCurrentThread();
        query.setParameter(0, subject_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getSbjectDao().getAllColumns());
            builder.append(" FROM wu_source T");
            builder.append(" LEFT JOIN wu_subject T0 ON T.'SUBJECT_ID'=T0.'SUBJECT_ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Source loadCurrentDeep(Cursor cursor, boolean lock) {
        Source entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Sbject sbject = loadCurrentOther(daoSession.getSbjectDao(), cursor, offset);
        entity.setSbject(sbject);

        return entity;    
    }

    public Source loadDeep(Long key) {
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
    public List<Source> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Source> list = new ArrayList<Source>(count);
        
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
    
    protected List<Source> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Source> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
