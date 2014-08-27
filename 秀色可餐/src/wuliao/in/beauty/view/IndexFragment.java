package wuliao.in.beauty.view;

import java.util.ArrayList;
import java.util.List;

import wuliao.in.beauty.R;
import wuliao.in.beauty.domain.OneModel;
import android.database.DataSetObserver;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class IndexFragment extends Fragment {
	public static IndexFragment newInstance(String str){
		IndexFragment fragment=new IndexFragment();
		Bundle bundle=new Bundle();
		bundle.putString("key", str);
		fragment.setArguments(bundle);
		return fragment;
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Bundle bundle=getArguments();
		String str=(String) bundle.get("key");
		View view;
		if("one".equals(str)){
			view = inflater.inflate(R.layout.one, container, false);
			ListView lvOne=(ListView) view.findViewById(R.id.lv_one);
			List<OneModel> ones=new ArrayList<OneModel>();
			ones.add(new OneModel("/mnt/sdcard/1.jpg", "ÆïÐÐÎ÷²Ø~~~happy"));
			ones.add(new OneModel("/mnt/sdcard/2.jpg", "²½ÐÐÉÏº£~~~happy"));
			ones.add(new OneModel("/mnt/sdcard/3.jpg", "Æ¯ÁÁÃÃÖ½~~~happy"));
			ones.add(new OneModel("/mnt/sdcard/4.jpg", "¹þ¹þ¹þ¹þ~~~happy"));
			ones.add(new OneModel("/mnt/sdcard/5.jpg", "¹þ¹þ¹þ¹þ~~~happy"));
			ones.add(new OneModel("/mnt/sdcard/6.jpg", "¹þ¹þ¹þ¹þ~~~happy"));
			lvOne.setAdapter(new MyAdapterOne(ones));
			
		}else if("two".equals(str)){
			view = inflater.inflate(R.layout.two, container, false);
		}else{
			view = inflater.inflate(R.layout.three, container, false);
		}
		return view;
	}
	private class MyAdapterOne extends BaseAdapter{
		private List<OneModel> ones;
		public MyAdapterOne(List<OneModel> ones){
			this.ones=ones;
		}
		@Override
		public int getCount() {
			return ones.size();
		}
		@Override
		public Object getItem(int position) {
			return ones.get(position);
		}
		@Override
		public long getItemId(int position) {
			return position;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view=LayoutInflater.from(getActivity()).inflate(R.layout.item_one, null);
			ImageView image=(ImageView) view.findViewById(R.id.image_view);
			TextView title=(TextView) view.findViewById(R.id.text_title);
			title.setText(ones.get(position).getTitle());
			image.setImageBitmap(BitmapFactory.decodeFile(ones.get(position).getImgPath()));
			return view;
		}
		
	}
}
