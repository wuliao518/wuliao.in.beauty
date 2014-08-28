package wuliao.in.beauty.ui;


import java.util.ArrayList;

import wuliao.in.beauty.R;
import wuliao.in.beauty.adapter.MyFragmentPagerAdapter;
import wuliao.in.beauty.dao.DaoMaster;
import wuliao.in.beauty.dao.DaoSession;
import wuliao.in.beauty.dao.User;
import wuliao.in.beauty.dao.UserDao;
import wuliao.in.beauty.view.IndexFragment;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {
	private ImageView mImage;
	private ViewPager mViewPager;
	private int currIndex = 0;
	private int width,itemWidth;
	private TextView mTV1,mTV2,mTV3;
	private ArrayList<Fragment> fragments;
	private DaoMaster mDaoMaster;
	private DaoSession mDaoSession;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		initView();
	}
	private void initView() {
		WindowManager window=getWindowManager();
		Display display=window.getDefaultDisplay();
		width=display.getWidth();
		itemWidth=width/3;
		mDaoMaster=MyApplication.getDaoMaster(getApplicationContext());
		mDaoSession=MyApplication.getDaoSession(getApplicationContext());
		
		UserDao userDao=mDaoSession.getUserDao();
		User user=new User();
		user.setUser_name("wuliao");
		user.setPassword("456789");
		user.setEmail("122@qq.com");
		user.setUser_img("./images/a.jpg");
		user.setAdd_time(System.currentTimeMillis()+"");
		userDao.insert(user);
		
		
		
		
		mViewPager=(ViewPager) findViewById(R.id.viewpager);
		mViewPager.setOnPageChangeListener(new MyPageListener());
		fragments=new ArrayList<Fragment>();
		mTV1=(TextView) findViewById(R.id.tv_tab_1);
		mTV2=(TextView) findViewById(R.id.tv_tab_2);
		mTV3=(TextView) findViewById(R.id.tv_tab_3);
		mTV1.setOnClickListener(new MyOnclickListener(0));
		mTV2.setOnClickListener(new MyOnclickListener(1));
		mTV3.setOnClickListener(new MyOnclickListener(2));
		mImage=(ImageView) findViewById(R.id.iv_bottom_line);
		LayoutParams params=(LayoutParams) mImage.getLayoutParams();
		params.width=itemWidth;
		mImage.setLayoutParams(params);
		IndexFragment one=IndexFragment.newInstance("one");
		IndexFragment two=IndexFragment.newInstance("two");
		IndexFragment three=IndexFragment.newInstance("three");
		fragments.add(one);
		fragments.add(two);
		fragments.add(three);
		mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments));
		mViewPager.setCurrentItem(currIndex);
	}
	
	private class MyOnclickListener implements OnClickListener{
		int num=0;
		MyOnclickListener(int num){
			this.num=num;
		}
		@Override
		public void onClick(View v) {
			mViewPager.setCurrentItem(num);
		}
	}
	private class MyPageListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int item) {
			
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}

		@Override
		public void onPageSelected(int item) {
			Animation animation = null;
			switch (item) {
			case 0:
				mTV1.setTextColor(getResources().getColor(R.color.blue));
				mTV1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
				mTV2.setTextColor(getResources().getColor(R.color.black));
				mTV3.setTextColor(getResources().getColor(R.color.black));
				break;
			case 1:		
				mTV2.setTextColor(getResources().getColor(R.color.blue));
				mTV2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
				mTV1.setTextColor(getResources().getColor(R.color.black));
				mTV3.setTextColor(getResources().getColor(R.color.black));
				break;
			case 2:
				mTV3.setTextColor(getResources().getColor(R.color.blue));
				mTV3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
				mTV1.setTextColor(getResources().getColor(R.color.black));
				mTV2.setTextColor(getResources().getColor(R.color.black));
				break;
				
			default:
				break;
			}	
			animation = new TranslateAnimation(currIndex*itemWidth, item*itemWidth, 0, 0);
			currIndex=item;
			animation.setFillAfter(true);
            animation.setDuration(300);
            mImage.startAnimation(animation);
		}
		
		
		
	}
}
