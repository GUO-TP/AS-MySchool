package com.fs.widget;


import com.myschool.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TabMenuView extends RelativeLayout implements View.OnClickListener {

	Context context;

	/**
	 * 主页按钮
	 */
	LinearLayout zhuYeLayout;
	TextView zhuYeImage;

	/**
	 * 分类
	 */
	LinearLayout fenLeiLayout;
	TextView fenLeiImage;

	/**
	 * 发现
	 */
	LinearLayout faXianLayout;
	TextView faXianImage;

	/**
	 * 购物车
	 */
	LinearLayout gouWuCheLayout;
	TextView gouWuCheImage;

	/**
	 * 发现
	 */
	LinearLayout woDeLayout;
	TextView woDeImage;

	public TabMenuView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	public TabMenuView(Context context) {
		super(context);
		this.context = context;
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		// 1,把布局文件转为视图
		View.inflate(context, R.layout.tab_menu_view, this);

		getWidget();
	}

	private void getWidget() {
		// 1,获得推荐按钮的布局文件（设置监听），文本字，文本下面的线颜色
		zhuYeLayout = (LinearLayout) this
				.findViewById(R.id.tab_view_btn_zhuye);
		zhuYeLayout.setOnClickListener(this);
		zhuYeImage = (TextView) this
				.findViewById(R.id.tab_view_btn_zhuye_image);
		// zhuYeWords =
		// (TextView)this.findViewById(R.id.tab_view_btn_zhuye_words);

		// 2,获得排行榜按钮的布局文件（设置监听），文本字，文本下面的线颜色
		fenLeiLayout = (LinearLayout) this
				.findViewById(R.id.tab_view_btn_fenlei);
		fenLeiLayout.setOnClickListener(this);
		fenLeiImage = (TextView) this
				.findViewById(R.id.tab_view_btn_fenlei_image);
		// fenLeiWords =
		// (TextView)this.findViewById(R.id.tab_view_btn_fenlei_words);

		// 2,获得搜索按钮的布局文件（设置监听），文本字，文本下面的线颜色
//	//	faXianLayout = (RelativeLayout) this
//	//			.findViewById(R.id.tab_view_btn_faxian);
//	//	faXianLayout.setOnClickListener(this);
//	//	faXianImage = (TextView) this
//	//			.findViewById(R.id.tab_view_btn_faxian_image);
		// faXianWords =
		// (TextView)this.findViewById(R.id.tab_view_btn_faxian_words);

		// 2,获得搜索按钮的布局文件（设置监听），文本字，文本下面的线颜色
//	//	gouWuCheLayout = (RelativeLayout) this
//	//			.findViewById(R.id.tab_view_btn_gouwuche);
//	//	gouWuCheLayout.setOnClickListener(this);
//	//	gouWuCheImage = (TextView) this
//	//			.findViewById(R.id.tab_view_btn_gouwuche_image);
		// gouWuCheWords =
		// (TextView)this.findViewById(R.id.tab_view_btn_gouwuche_words);

		// 2,获得搜索按钮的布局文件（设置监听），文本字，文本下面的线颜色
		woDeLayout = (LinearLayout) this.findViewById(R.id.tab_view_btn_wode);
		woDeLayout.setOnClickListener(this);
		woDeImage = (TextView) this.findViewById(R.id.tab_view_btn_wode_image);
		// woDeWords =
		// (TextView)this.findViewById(R.id.tab_view_btn_wode_words);

	}

	final int STATE_SHOUYE = 0;
	final int STATE_FENLEI = STATE_SHOUYE + 1;
	final int STATE_FAXIAN = STATE_FENLEI + 1;
	final int STATE_GOUWUCHE = STATE_FAXIAN + 1;
	final int STATE_WODE = STATE_GOUWUCHE + 1;

	int state = STATE_SHOUYE;

	private void changeState() {
		switch (state) {
		case STATE_SHOUYE:
			// 1,把推荐按钮还原
			zhuYeImage.setBackgroundResource(R.drawable.home_nomal);
			// zhuYeImage.setTextColor(Color.BLACK);
			// zhuYeWords.setBackgroundColor(Color.WHITE);
			break;
		case STATE_FENLEI:
			// 1,把排行榜按钮还原
			fenLeiImage.setBackgroundResource(R.drawable.type_nomal);
			// fenLeiWords.setBackgroundColor(Color.WHITE);
			break;
		case STATE_FAXIAN:
			// 1,把搜索按钮还原

			faXianImage.setBackgroundResource(R.drawable.find_nomal);
			// faXianWords.setBackgroundColor(Color.WHITE);
			break;

		case STATE_GOUWUCHE:
			// 1,把搜索按钮还原
			gouWuCheImage.setBackgroundResource(R.drawable.car_nomal);
			// gouWuCheWords.setBackgroundColor(Color.WHITE);
			break;

		case STATE_WODE:
			// 1,把搜索按钮还原
			woDeImage.setBackgroundResource(R.drawable.mine_nomal);
			// woDeWords.setBackgroundColor(Color.WHITE);
			break;
		}
	}

	@Override
	public void onClick(View view) {
		int id = view.getId();

		switch (id) {
		case R.id.tab_view_btn_zhuye:

			zhuYeImage.setBackgroundResource(R.drawable.home_selected);
			// zhuYeWords.setBackgroundColor(Color.GREEN);

			// 2,改变之前的按钮
			changeState();
			// 3,更改状态值
			state = STATE_SHOUYE;
			listener.OnShouYeClick();

			break;

		case R.id.tab_view_btn_fenlei:
			fenLeiImage.setBackgroundResource(R.drawable.type_selected);
			// fenLeiWords.setBackgroundColor(Color.GREEN);

			// 2,改变之前的按钮
			changeState();
			// 3,更改状态值
			state = STATE_FENLEI;

			listener.OnFenLeiClick();
			break;

//		case R.id.tab_view_btn_faxian:
//			faXianImage.setBackgroundResource(R.drawable.find_selected);
//			// faXianWords.setBackgroundColor(Color.GREEN);
//			// 2,改变之前的按钮
//			changeState();
//			// 3,更改状态值
//			state = STATE_FAXIAN;
//			listener.OnFaXianClick();
//			break;
//
//		case R.id.tab_view_btn_gouwuche:
//			gouWuCheImage.setBackgroundResource(R.drawable.car_selected);
//			// gouWuCheWords.setBackgroundColor(Color.GREEN);
//			// 2,改变之前的按钮
//			changeState();
//			// 3,更改状态值
//			state = STATE_GOUWUCHE;
//			listener.OnGouWuCheClick();
//			break;

		case R.id.tab_view_btn_wode:
			woDeImage.setBackgroundResource(R.drawable.mine_selected);
			// woDeWords.setBackgroundColor(Color.GREEN);
			// 2,改变之前的按钮
			changeState();
			// 3,更改状态值
			state = STATE_WODE;
			listener.OnWoDeClick();
			;
			break;

		}

	}

	OnMyClickListener listener;

	public void setOnMyClickListener(OnMyClickListener listener) {
		this.listener = listener;
	}

}
