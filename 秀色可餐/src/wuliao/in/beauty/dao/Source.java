package wuliao.in.beauty.dao;

import wuliao.in.beauty.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table wu_source.
 */
public class Source {

    private Long source_id;
    private Long subject_id;
    /** Not-null value. */
    private String content_image;
    /** Not-null value. */
    private String content;
    /** Not-null value. */
    private String add_time;
    private String modify_time;
    private Integer like_num;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient SourceDao myDao;

    private Sbject sbject;
    private Long sbject__resolvedKey;


    public Source() {
    }

    public Source(Long source_id) {
        this.source_id = source_id;
    }

    public Source(Long source_id, Long subject_id, String content_image, String content, String add_time, String modify_time, Integer like_num) {
        this.source_id = source_id;
        this.subject_id = subject_id;
        this.content_image = content_image;
        this.content = content;
        this.add_time = add_time;
        this.modify_time = modify_time;
        this.like_num = like_num;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSourceDao() : null;
    }

    public Long getSource_id() {
        return source_id;
    }

    public void setSource_id(Long source_id) {
        this.source_id = source_id;
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    /** Not-null value. */
    public String getContent_image() {
        return content_image;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContent_image(String content_image) {
        this.content_image = content_image;
    }

    /** Not-null value. */
    public String getContent() {
        return content;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContent(String content) {
        this.content = content;
    }

    /** Not-null value. */
    public String getAdd_time() {
        return add_time;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public Integer getLike_num() {
        return like_num;
    }

    public void setLike_num(Integer like_num) {
        this.like_num = like_num;
    }

    /** To-one relationship, resolved on first access. */
    public Sbject getSbject() {
        Long __key = this.subject_id;
        if (sbject__resolvedKey == null || !sbject__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SbjectDao targetDao = daoSession.getSbjectDao();
            Sbject sbjectNew = targetDao.load(__key);
            synchronized (this) {
                sbject = sbjectNew;
            	sbject__resolvedKey = __key;
            }
        }
        return sbject;
    }

    public void setSbject(Sbject sbject) {
        synchronized (this) {
            this.sbject = sbject;
            subject_id = sbject == null ? null : sbject.getSubject_id();
            sbject__resolvedKey = subject_id;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
