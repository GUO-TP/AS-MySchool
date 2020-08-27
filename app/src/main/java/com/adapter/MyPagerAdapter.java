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

	// 1,把当前显示的视图给ViewPager
	@Override
	public Object instantiateItem(View container, final int position) {
		// 1,从滑动的效果返回的position值找到对应的数据
		Slider slider = sliders.get(position);
		//News slider = sliders.get(position);
		// Advertisement slider=sliders.get(position);
		// 2,从对应的数据获得图片地址
		final String url = slider.getPicUrl();
		//final String url = slider.getPhoto();
		// 3,根据url地址去获得显示的视图
		if (viewMap.get(url) == null) {
			// 1,创建视图
			final ImageView imagerView = new ImageView(context);
			// 2,设置图片在组件里面存放的形式，这里是把放进去的图片放大的组件一样大
			imagerView.setScaleType(ImageView.ScaleType.FIT_XY);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					Constant.width, Constant.height / 4);
			imagerView.setLayoutParams(params);
			// 2,把当前的视图添加到容器
			viewMap.put(url, imagerView);
			// 3,下载图片
			imageLoader.loadImag(new OnBitmapListener() {
				@Override
				public void getBitmap(Bitmap bitmap) {
					// 4,下载成功
					imagerView.setImageBitmap(bitmap);
					// 点击监听测试
					View view = viewMap.get(url);
					onTouchViewPager(view, position);
				}

	private void onTouchViewPager(View view, final int position) {
					// 给图片注册触摸事件监听器
//					view.setOnTouchListener(new OnTouchListener() {
//
//						private long downTime;
//						private int downX;
//
//						@Override
//						public boolean onTouch(View v, MotionEvent event) {
//							switch (event.getAction()) {
//							case MotionEvent.ACTION_DOWN:// 按下去时，记录按下的坐标和时间，用于判断是否是点击事件
//								//handler.removeCallbacksAndMessages(null);// 手指按下时，取消所有事件，即轮播图不在滚动了
//								downX = (int) event.getX();
//								downTime = System.currentTimeMillis();
//								
//								break;
//							case MotionEvent.ACTION_UP:// 抬起手指时，判断落下抬起的时间差和坐标，符合以下条件为点击
//								// Toast.makeText(context, "手指抬起了", 0).show();
//								if (System.currentTimeMillis() - downTime < 1000
//										&& Math.abs(downX - event.getX()) < 30) {// ★考虑到手按下和抬起时的坐标不可能完全重合，这里给出30的坐标偏差
//									// 点击事件被触发
//									Toast.makeText(
//											context,
//											"这里就不弹出对应页面了，您打开的是第" + position
//													+ "张图片", 0).show();
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
//								// ★写这个的目的为了让用户在手指滑动完图片后，能够让轮播图继续自动滚动
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
//		// 5.接收并处理run方法发来的消息
//		public void handleMessage(android.os.Message msg) {
//			// 6.viewpager设置新的当前页
//			// viewpager.setCurrentItem(currentPosition);
//			// 7.继续执行startRoll方法，成为一个循环
//			// startRoll();
//		}
//	};
}
