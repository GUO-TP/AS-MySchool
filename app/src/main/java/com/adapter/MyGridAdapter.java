package com.adapter;



import java.util.HashMap;
import java.util.List;



import com.been.Goods;
import com.been.Slider;
import com.loader.ImageLoader;
import com.loader.OnBitmapListener;
import com.myschool.R;
import com.fs.widget.Constant;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyGridAdapter extends BaseAdapter {
List<Goods> list;
	
	Context context;
	
	
	int length ;
//	ImageView  imageView;
//	TextView name;
//	List<Slider> sliders;
//
//	ImageLoader imageLoader = new ImageLoader();
//
//	HashMap<String, ImageView> viewMap = new HashMap<String, ImageView>();
	
	public  MyGridAdapter(List<Goods> list,Context context){
		//this.sliders=sliders;
		//length=sliders.size();
		//它代表MainActivity
		this.list=list;
		this.context=context;
		length=list.size();
	}

	@Override
	public int getCount() {
		return list.size();
		//return sliders.size();
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
		
		// 用来保存显示组件的引用
		ViewHolder viewHolder=null;
		
		//从内存的角度考虑
		if(view==null){
			//把一个布局转为View，
			view= ((Activity)context).getLayoutInflater().inflate(R.layout.activity_gridmain, null);	
			//  imageView=(ImageView)view.findViewById(R.id.grid_imageView);
			  // name=(TextView)view.findViewById(R.id.grid_name);
			viewHolder = new ViewHolder();			
			//把viewHolder保存到view对象里面
			view.setTag(viewHolder);
			
			//**************  创建View的时候，只需要找一次组件的引用，把这个引用保存到viewHolder对象里面
			
			//2,从view里面获得ImageView组件
			viewHolder.imageView = (ImageView)view.findViewById(R.id.grid_imageView);
			//3,从view里面获得TextView组件
			viewHolder.name =(TextView)view.findViewById(R.id.grid_name);						
		}
			else{
			viewHolder=(ViewHolder)view.getTag();
		}
	
		//5，准备数据
		Goods singer =list.get(index);
//		Slider slider = sliders.get(index);
//		String url = slider.getPicUrl();
//		String urlo = slider.getId();
//		
//		//6，从singer对象获得数据
		int ImageId= singer.getImageId();
		String nameInfor =singer.getName();
		
		//7，向组件添加数据
		viewHolder.imageView.setImageResource(ImageId);
		viewHolder.name.setText(nameInfor);
//		if (viewMap.get(url) == null) {
//
//			// 1,创建视图
//			final ImageView imagerView = new ImageView(context);
//			// 2,设置图片在组件里面存放的形式，这里是把放进去的图片放大的组件一样大
//			imagerView.setScaleType(ImageView.ScaleType.FIT_XY);
//			
//			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//					Constant.width, Constant.height / 4);
//			imagerView.setLayoutParams(params);

			// 2,把当前的视图添加到容器
//			viewMap.put(url, imagerView);
//			// 3,下载图片
//			imageLoader.loadImag(new OnBitmapListener() {
//
//				@Override
//				public void getBitmap(Bitmap bitmap) {
//					// 4,下载成功
//					imagerView.setImageBitmap(bitmap);
//					
//				}
//			}, url, context.getCacheDir());
//
//		}
//        
//		((ViewGroup)view).addView(viewMap.get(url), 0);
//		
//		return viewMap.get(url);
		
		return view;
	}
	
	//  把View里面获得组件的引用保存到这里
	class ViewHolder{
		ImageView  imageView;
		TextView name;
	}
	

}
