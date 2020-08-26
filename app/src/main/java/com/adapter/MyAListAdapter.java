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
        //������MainActivity
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

		//���ڴ�ĽǶȿ���
		if(view==null){
			//��һ������תΪView��
			view= ((Activity)context).getLayoutInflater().inflate(R.layout.list_view_tab, null);
		}


		//2,��view������ImageView���
		ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
		//3,��view������TextView���
		TextView name =(TextView)view.findViewById(R.id.name);
		//4,��view������TextView���
		TextView introduce =(TextView)view.findViewById(R.id.introduce);



		//5��׼������
		Singer singer =list.get(index);

		//6����singer����������
		int ImageId= singer.getImageId();
		String nameInfor =singer.getName();
		String introduceInfor=singer.getIntroduce();

		//7��������������
		imageView.setImageResource(ImageId);
		name.setText(nameInfor);
		introduce.setText(introduceInfor);

		return view;
	}

}
