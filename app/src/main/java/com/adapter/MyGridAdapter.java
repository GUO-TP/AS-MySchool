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
		//������MainActivity
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
		
		// ����������ʾ���������
		ViewHolder viewHolder=null;
		
		//���ڴ�ĽǶȿ���
		if(view==null){
			//��һ������תΪView��
			view= ((Activity)context).getLayoutInflater().inflate(R.layout.activity_gridmain, null);	
			//  imageView=(ImageView)view.findViewById(R.id.grid_imageView);
			  // name=(TextView)view.findViewById(R.id.grid_name);
			viewHolder = new ViewHolder();			
			//��viewHolder���浽view��������
			view.setTag(viewHolder);
			
			//**************  ����View��ʱ��ֻ��Ҫ��һ����������ã���������ñ��浽viewHolder��������
			
			//2,��view������ImageView���
			viewHolder.imageView = (ImageView)view.findViewById(R.id.grid_imageView);
			//3,��view������TextView���
			viewHolder.name =(TextView)view.findViewById(R.id.grid_name);						
		}
			else{
			viewHolder=(ViewHolder)view.getTag();
		}
	
		//5��׼������
		Goods singer =list.get(index);
//		Slider slider = sliders.get(index);
//		String url = slider.getPicUrl();
//		String urlo = slider.getId();
//		
//		//6����singer����������
		int ImageId= singer.getImageId();
		String nameInfor =singer.getName();
		
		//7��������������
		viewHolder.imageView.setImageResource(ImageId);
		viewHolder.name.setText(nameInfor);
//		if (viewMap.get(url) == null) {
//
//			// 1,������ͼ
//			final ImageView imagerView = new ImageView(context);
//			// 2,����ͼƬ����������ŵ���ʽ�������ǰѷŽ�ȥ��ͼƬ�Ŵ�����һ����
//			imagerView.setScaleType(ImageView.ScaleType.FIT_XY);
//			
//			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//					Constant.width, Constant.height / 4);
//			imagerView.setLayoutParams(params);

			// 2,�ѵ�ǰ����ͼ��ӵ�����
//			viewMap.put(url, imagerView);
//			// 3,����ͼƬ
//			imageLoader.loadImag(new OnBitmapListener() {
//
//				@Override
//				public void getBitmap(Bitmap bitmap) {
//					// 4,���سɹ�
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
	
	//  ��View��������������ñ��浽����
	class ViewHolder{
		ImageView  imageView;
		TextView name;
	}
	

}
