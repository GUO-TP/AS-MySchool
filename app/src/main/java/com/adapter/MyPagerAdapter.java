package com.adapter;

import java.util.HashMap;
import java.util.List;

import com.been.Advertisement;
import com.been.News;
import com.been.Slider;
import com.loader.ImageLoader;
import com.loader.OnBitmapListener;
import com.myschool.MainActivity;
import com.myschool.R;
import com.myschool.ShowActivity;
import com.fs.widget.Constant;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MyPagerAdapter extends PagerAdapter {

	ImageLoader imageLoader = new ImageLoader();

	HashMap<String, ImageView> viewMap = new HashMap<String, ImageView>();
	//List<News> sliders;
	List<Slider> sliders;
	// List<Advertisement> sliders;
	Context context;

	// public MyPagerAdapter(List<Advertisement> sliders, Context context) {
	//public MyPagerAdapter(List<News> sliders, Context context) {
	public MyPagerAdapter(List<Slider> sliders, Context context) {
		this.sliders = sliders;
		this.context = context;
	}

	// public MyPagerAdapter(List<Advertisement> slider, Context context2) {
	// // TODO Auto-generated constructor stub
	// this.sliders = slider;
	// this.context = context2;
	// }

	@Override
	public int getCount() {
		return sliders.size();
	}

	// 1,�ѵ�ǰ��ʾ����ͼ��ViewPager
	@Override
	public Object instantiateItem(View container, final int position) {
		// 1,�ӻ�����Ч�����ص�positionֵ�ҵ���Ӧ������
		Slider slider = sliders.get(position);
		//News slider = sliders.get(position);
		// Advertisement slider=sliders.get(position);
		// 2,�Ӷ�Ӧ�����ݻ��ͼƬ��ַ
		final String url = slider.getPicUrl();
		//final String url = slider.getPhoto();
		// 3,����url��ַȥ�����ʾ����ͼ
		if (viewMap.get(url) == null) {
			// 1,������ͼ
			final ImageView imagerView = new ImageView(context);
			// 2,����ͼƬ����������ŵ���ʽ�������ǰѷŽ�ȥ��ͼƬ�Ŵ�����һ����
			imagerView.setScaleType(ImageView.ScaleType.FIT_XY);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					Constant.width, Constant.height / 4);
			imagerView.setLayoutParams(params);
			// 2,�ѵ�ǰ����ͼ��ӵ�����
			viewMap.put(url, imagerView);
			// 3,����ͼƬ
			imageLoader.loadImag(new OnBitmapListener() {
				@Override
				public void getBitmap(Bitmap bitmap) {
					// 4,���سɹ�
					imagerView.setImageBitmap(bitmap);
					// �����������
					View view = viewMap.get(url);
					onTouchViewPager(view, position);
				}

	private void onTouchViewPager(View view, final int position) {
					// ��ͼƬע�ᴥ���¼�������
//					view.setOnTouchListener(new OnTouchListener() {
//
//						private long downTime;
//						private int downX;
//
//						@Override
//						public boolean onTouch(View v, MotionEvent event) {
//							switch (event.getAction()) {
//							case MotionEvent.ACTION_DOWN:// ����ȥʱ����¼���µ������ʱ�䣬�����ж��Ƿ��ǵ���¼�
//								//handler.removeCallbacksAndMessages(null);// ��ָ����ʱ��ȡ�������¼������ֲ�ͼ���ڹ�����
//								downX = (int) event.getX();
//								downTime = System.currentTimeMillis();
//								
//								break;
//							case MotionEvent.ACTION_UP:// ̧����ָʱ���ж�����̧���ʱ�������꣬������������Ϊ���
//								// Toast.makeText(context, "��ָ̧����", 0).show();
//								if (System.currentTimeMillis() - downTime < 1000
//										&& Math.abs(downX - event.getX()) < 30) {// �￼�ǵ��ְ��º�̧��ʱ�����겻������ȫ�غϣ��������30������ƫ��
//									// ����¼�������
//									Toast.makeText(
//											context,
//											"����Ͳ�������Ӧҳ���ˣ����򿪵��ǵ�" + position
//													+ "��ͼƬ", 0).show();
////									 Intent intent = new Intent(MainActivity.class, ShowActivity.class);
////									 intent.putExtra("id", position);
//								
//			                            
//									
//								}
//								// startRoll();
//								break;
//							case MotionEvent.ACTION_CANCEL:
////								 Intent intent = new Intent();
////								 intent.setClass(context, ShowActivity.class);
////								 intent.putExtra("id", position);
//							//	startActivity(intent); 
//						
//			                
//								// ��д�����Ŀ��Ϊ�����û�����ָ������ͼƬ���ܹ����ֲ�ͼ�����Զ�����
//								// startRoll();
//								break;
//							}
//							return true;
//						}
//
//					
//					});

				}
			}, url, context.getCacheDir());

		}

		((ViewGroup) container).addView(viewMap.get(url), 0);
		return viewMap.get(url);

	}

	// public void callBack(int position) {
	// Intent intent = new Intent(MainActivity.this, TeaDetailsActivity.class);
	// intent.putExtra("id", adList.get(position).getId());
	// startActivity(intent);
	// }
	@Override
	public void destroyItem(View container, int position, Object object) {
		Slider slider = sliders.get(position);
		//News slider = sliders.get(position);
		// Advertisement slider = sliders.get(position);
		String url = slider.getPicUrl();
		//String url = slider.getPhoto();

		((ViewPager) container).removeView(viewMap.get(url));
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

//	private Handler handler = new Handler() {
//		// 5.���ղ�����run������������Ϣ
//		public void handleMessage(android.os.Message msg) {
//			// 6.viewpager�����µĵ�ǰҳ
//			// viewpager.setCurrentItem(currentPosition);
//			// 7.����ִ��startRoll��������Ϊһ��ѭ��
//			// startRoll();
//		}
//	};
}
