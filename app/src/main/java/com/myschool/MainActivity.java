package com.myschool;

import java.util.ArrayList;



//import com.fragement.FaXianFragment;
import com.fragement.FenLeiFragment;
//import com.fragement.GouWuCheFragment;
import com.fragement.ShouYeFragment;
import com.fragement.WoDeFragment;
import com.fs.widget.Constant;
import com.fs.widget.TabMenuView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {
	TabMenuView tabMenuView;
	MyAdapter myAdapter;
	ViewPager viewPage;
	ArrayList<Fragment> pages = new ArrayList<Fragment>();
	ShouYeFragment shouYeFragment;
	FenLeiFragment fenLeiFragment;
//	FaXianFragment faXianFragment;
//	GouWuCheFragment gouWuCheFragment;
	WoDeFragment woDeFragment;
	/**
	 * ��ҳ��ť
	 */
	TextView zhuYeImage;
	/**
	 * ����
	 */
	TextView fenLeiImage;
	/**
	 * ����
	 */
	//TextView faXianImage;
	/**
	 * ���ﳵ
	 */
	//TextView gouWuCheImage;
	/**
	 * ����
	 */
	TextView woDeImage;

	// private PullToRefreshBase mPullRefreshListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//ȥ����Ϣ��
		setContentView(R.layout.activity_main);
		zhuYeImage = (TextView) this
				.findViewById(R.id.tab_view_btn_zhuye_image);
		fenLeiImage = (TextView) this
				.findViewById(R.id.tab_view_btn_fenlei_image);
//		faXianImage = (TextView) this
//				.findViewById(R.id.tab_view_btn_faxian_image);
//		gouWuCheImage = (TextView) this
//				.findViewById(R.id.tab_view_btn_gouwuche_image);
		woDeImage = (TextView) this.findViewById(R.id.tab_view_btn_wode_image);
		
		setInitData();
		getWidget();
		
	}

	/**
	 * ������Ļ�Ŀ�͸�
	 */
	private void setInitData() {
		// TODO Auto-generated method stub
		// 1,�����Դ����
		Resources resources = this.getResources();
		// 2,�����ʾ�Ĳ���
		DisplayMetrics display = resources.getDisplayMetrics();
		// 3,������Ļ�Ŀ�Ⱥ͸߶�
		Constant.width = display.widthPixels;
		Constant.height = display.heightPixels;
	}

	/**
	 * �����ص����
	 */
	private void getWidget() {
		// TODO Auto-generated method stub
		getTabMenuView();

		getViewPager();

	}

	// private void getGridView() {
	// // TODO Auto-generated method stub
	//
	// }
	private void getTabMenuView() {
		// TODO Auto-generated method stub
		tabMenuView = (TabMenuView) findViewById(R.id.homePageTabMenuView);
		tabMenuView.setOnMyClickListener(new com.fs.widget.OnMyClickListener() {
//			@Override
//			public void OnFaXianClick() {
//				// ��ʾFaXianҳ��
//				viewPage.setCurrentItem(2);
//
//				// faXianImage.setBackgroundResource(R.drawable.find_selected);
//			}

			@Override
			public void OnShouYeClick() {
				// ��ʾShouYeҳ��
				viewPage.setCurrentItem(0);
				// zhuYeImage.setBackgroundResource(R.drawable.home_selected);

			}

			@Override
			public void OnFenLeiClick() {
				// ��ʾFenLeiҳ��
				viewPage.setCurrentItem(1);
				// fenLeiImage.setBackgroundResource(R.drawable.type_selected);
			}
//
//			@Override
//			public void OnGouWuCheClick() {
//				// TODO Auto-generated method stub
//				viewPage.setCurrentItem(3);
//				// gouWuCheImage.setBackgroundResource(R.drawable.car_selected);
//			}

			@Override
			public void OnWoDeClick() {
				// TODO Auto-generated method stub
				viewPage.setCurrentItem(4);
				// woDeImage.setBackgroundResource(R.drawable.mine_selected);
			}
		});
	}

	private void getViewPager() {
		// TODO Auto-generated method stub
		// 1,����Ƽ�ҳ��
		shouYeFragment = new ShouYeFragment();
		// 2,������а�ҳ��
		fenLeiFragment = new FenLeiFragment();
		// 3,�������ҳ��
//		faXianFragment = new FaXianFragment();
//		gouWuCheFragment = new GouWuCheFragment();
		woDeFragment = new WoDeFragment();
		// 4,��fragment��ӵ�����
		pages.add(shouYeFragment);
		pages.add(fenLeiFragment);
//		pages.add(faXianFragment);
//		pages.add(gouWuCheFragment);
		pages.add(woDeFragment);
		// 5,������
		viewPage = (ViewPager) findViewById(R.id.shop_main_body);
		// 6,����������
		myAdapter = new MyAdapter(getSupportFragmentManager());
		// 7,��ʾ����
		viewPage.setAdapter(myAdapter);
		// 8,���ü���
		viewPage.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int v) {
				// Toast.makeText(MainActivity.this, "11111"+arg0,
				// Toast.LENGTH_LONG).show();
				switch (v) {
				case 0:
					zhuYeImage.setBackgroundResource(R.drawable.home_selected);

					// zhuYeImage.setBackgroundResource(R.drawable.home_nomal);
					fenLeiImage.setBackgroundResource(R.drawable.type_nomal);

					//faXianImage.setBackgroundResource(R.drawable.find_nomal);

					//gouWuCheImage.setBackgroundResource(R.drawable.car_nomal);

					woDeImage.setBackgroundResource(R.drawable.mine_nomal);
					break;
				case 1:
					fenLeiImage.setBackgroundResource(R.drawable.type_selected);
					zhuYeImage.setBackgroundResource(R.drawable.home_nomal);
					// fenLeiImage.setBackgroundResource(R.drawable.type_nomal);

					//faXianImage.setBackgroundResource(R.drawable.find_nomal);

					//gouWuCheImage.setBackgroundResource(R.drawable.car_nomal);

					woDeImage.setBackgroundResource(R.drawable.mine_nomal);
					break;
				case 2:
					//faXianImage.setBackgroundResource(R.drawable.find_selected);
					zhuYeImage.setBackgroundResource(R.drawable.home_nomal);
					fenLeiImage.setBackgroundResource(R.drawable.type_nomal);

					// faXianImage.setBackgroundResource(R.drawable.find_nomal);

					//gouWuCheImage.setBackgroundResource(R.drawable.car_nomal);

					woDeImage.setBackgroundResource(R.drawable.mine_selected);
					break;
//				case 3:
//					//gouWuCheImage.setBackgroundResource(R.drawable.car_selected);
//					zhuYeImage.setBackgroundResource(R.drawable.home_nomal);
//					fenLeiImage.setBackgroundResource(R.drawable.type_nomal);
//
//					//faXianImage.setBackgroundResource(R.drawable.find_nomal);
//
//					// gouWuCheImage.setBackgroundResource(R.drawable.car_nomal);
//
//					woDeImage.setBackgroundResource(R.drawable.mine_nomal);
//					break;
//				case 4:
//					woDeImage.setBackgroundResource(R.drawable.mine_selected);
//					zhuYeImage.setBackgroundResource(R.drawable.home_nomal);
//					fenLeiImage.setBackgroundResource(R.drawable.type_nomal);
					//faXianImage.setBackgroundResource(R.drawable.find_nomal);
					//gouWuCheImage.setBackgroundResource(R.drawable.car_nomal);
					// woDeImage.setBackgroundResource(R.drawable.mine_nomal);
					//break;
				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int v, float arg1, int arg2) {
				// Toast.makeText(MainActivity.this, "22222"+arg0,
				// Toast.LENGTH_LONG).show();
				
			}

			@Override
			public void onPageScrollStateChanged(int v) {
				
			}
		});

	}

	class MyAdapter extends FragmentPagerAdapter {
		public MyAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public Fragment getItem(int index) {
			return pages.get(index);
		}

		@Override
		public int getCount() {
			return pages.size();
		}
	}
}
