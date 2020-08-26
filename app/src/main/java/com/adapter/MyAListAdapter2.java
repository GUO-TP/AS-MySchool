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
//				case MotionEvent.ACTION_DOWN:// ����ȥʱ����¼���µ������ʱ�䣬�����ж��Ƿ��ǵ���¼�
//					//handler.removeCallbacksAndMessages(null);// ��ָ����ʱ��ȡ�������¼������ֲ�ͼ���ڹ�����
//					downX = (int) event.getX();
//					downTime = System.currentTimeMillis();
//					break;
//				case MotionEvent.ACTION_UP:// ̧����ָʱ���ж�����̧���ʱ�������꣬������������Ϊ���
//					// Toast.makeText(context, "��ָ̧����", 0).show();
//					if (System.currentTimeMillis() - downTime < 1000
//							&& Math.abs(downX - event.getX()) < 30) {// �￼�ǵ��ְ��º�̧��ʱ�����겻������ȫ�غϣ��������30������ƫ��
//						// ����¼�������
//						Toast.makeText(
//								context,
//								"����Ͳ�������Ӧҳ���ˣ���������ǵ�" + index
//										+ "��listview", 0).show();
////						 Intent intent = new Intent();
////						 intent.setClass(context, ShowActivity.class);
////						 intent.putExtra("id", index);
////
////						startActivity(intent);
//					}
//					// startRoll();
//					break;
//				case MotionEvent.ACTION_CANCEL:
//					// ��д�����Ŀ��Ϊ�����û�����ָ������ͼƬ���ܹ����ֲ�ͼ�����Զ�����
//					// startRoll();
//					break;
//				}
//				return true;
//			}
//		});
//	}

}
