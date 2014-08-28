package wuliao.in.beauty.ui;

import wuliao.in.beauty.dao.DaoMaster;
import wuliao.in.beauty.dao.DaoMaster.OpenHelper;
import wuliao.in.beauty.dao.DaoSession;
import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	private static DaoMaster daoMaster;
	private static DaoSession daoSession;
	/**
	 * 取得DaoMaster
	 * @param context
	 * @return
	 */
	public static DaoMaster getDaoMaster(Context context)
	{
	    if (daoMaster == null)
	    {
	        OpenHelper helper = new DaoMaster.DevOpenHelper(context, "wuliao.db", null);
	        daoMaster = new DaoMaster(helper.getWritableDatabase());
	    }
	    return daoMaster;
	}
	/**
	 * 取得DaoSession
	 *
	 * @param context
	 * @return
	 */
	public static DaoSession getDaoSession(Context context)
	{
	    if (daoSession == null)
	    {
	        if (daoMaster == null)
	        {
	            daoMaster = getDaoMaster(context);
	        }
	        daoSession = daoMaster.newSession();
	    }
	    return daoSession;
	}


}
