package com.adapter;

import java.util.HashMap;
import java.util.List;

import com.been.News;
import com.been.RadioList;
import com.loader.ImageLoader;
import com.loader.OnBitmapListener;
import com.myschool.MainActivity;
import com.myschool.R;
import com.myschool.ShowActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class MyAListAdapter2 extends BaseAdapter {

	List<RadioList> list;
	//List<News> list;

	Context context;
	ImageLoader imageLoader = new ImageLoader();

	HashMap<String, ImageView> viewMap = new HashMap<String, ImageView>();
	int length ;
	//public MyAListAdapter2(List<News> lists,Context context){
	public MyAListAdapter2(List<RadioList> lists,Context context){
		this.list=lists;
		this.context=context;
		length=list.size();
	}

	@Override
	public int getCount() {

		return length;
	}

	@Override
	public Object getItem(int arg0) {

		return arg0;
	}

	@Override
	public long getItemId(int arg0) {

		return arg0;
	}

	@Override
	public View getView(int index, View view, ViewGroup arg2) {

		if(view==null){
			view= ((Activity)context).getLayoutInflater().inflate(R.layout.list_view_tab, null);
		}
//		News newsList =list.get(index);
//		String url = newsList.getPhoto();
//		String nameInfor = newsList.getTitle();
//		String introduceInfor= newsList.getPage();
		RadioList radioList =list.get(index);
		String url = radioList.getPicUrl();
		String nameInfor =radioList.getFtitle();
		String introduceInfor=radioList.getRadioid();


		final ImageView imageView = (ImageView)view.findViewById(R.id.imageView);

		TextView name =(TextView)view.findViewById(R.id.name);

		TextView introduce =(TextView)view.findViewById(R.id.introduce);

		imageLoader.loadImag(new OnBitmapListener() {

			@Override
			public void getBitmap(Bitmap bitmap) {
				imageView.setImageBitmap(bitmap);

			}
		}, url, context.getCacheDir());

		name.setText(nameInfor);
		introduce.setText(introduceInfor);

		//onTouchViewPager(view, index);

		return view;
	}

//	private void onTouchViewPager(View view, final int index) {
//		// TODO Auto-generated method stub
//		view.setOnTouchListener(new OnTouchListener() {
//
//			private long downTime;
//			private int downX;
//
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				switch (event.getAction()) {
//				case MotionEvent.ACTION_DOWN:// 按下去时，记录按下的坐标和时间，用于判断是否是点击事件
//					//handler.removeCallbacksAndMessages(null);// 手指按下时，取消所有事件，即轮播图不在滚动了
//					downX = (int) event.getX();
//					downTime = System.currentTimeMillis();
//					break;
//				case MotionEvent.ACTION_UP:// 抬起手指时，判断落下抬起的时间差和坐标，符合以下条件为点击
//					// Toast.makeText(context, "手指抬起了", 0).show();
//					if (System.currentTimeMillis() - downTime < 1000
//							&& Math.abs(downX - event.getX()) < 30) {// ★考虑到手按下和抬起时的坐标不可能完全重合，这里给出30的坐标偏差
//						// 点击事件被触发
//						Toast.makeText(
//								context,
//								"这里就不弹出对应页面了，您点击的是第" + index
//										+ "个listview", 0).show();
////						 Intent intent = new Intent();
////						 intent.setClass(context, ShowActivity.class);
////						 intent.putExtra("id", index);
////
////						startActivity(intent);
//					}
//					// startRoll();
//					break;
//				case MotionEvent.ACTION_CANCEL:
//					// ★写这个的目的为了让用户在手指滑动完图片后，能够让轮播图继续自动滚动
//					// startRoll();
//					break;
//				}
//				return true;
//			}
//		});
//	}

}
