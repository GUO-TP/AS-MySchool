package com.adapter;

import java.util.List;





import com.been.Singer;
import com.myschool.R;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class MyAListAdapter extends BaseAdapter {

	List<Singer> list;

	Context context;

	int length ;

	public MyAListAdapter(List<Singer> lists,Context context){
		this.list=lists;
        //它代表MainActivity
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

		//从内存的角度考虑
		if(view==null){
			//把一个布局转为View，
			view= ((Activity)context).getLayoutInflater().inflate(R.layout.list_view_tab, null);
		}


		//2,从view里面获得ImageView组件
		ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
		//3,从view里面获得TextView组件
		TextView name =(TextView)view.findViewById(R.id.name);
		//4,从view里面获得TextView组件
		TextView introduce =(TextView)view.findViewById(R.id.introduce);



		//5，准备数据
		Singer singer =list.get(index);

		//6，从singer对象获得数据
		int ImageId= singer.getImageId();
		String nameInfor =singer.getName();
		String introduceInfor=singer.getIntroduce();

		//7，向组件添加数据
		imageView.setImageResource(ImageId);
		name.setText(nameInfor);
		introduce.setText(introduceInfor);

		return view;
	}

}
