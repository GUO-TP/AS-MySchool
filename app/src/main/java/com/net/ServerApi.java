package com.net;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class ServerApi {
	RequestQueue mQueue;

	public ServerApi(Context context) {
		// 1,获得 RequestQueue对象
		mQueue = Volley.newRequestQueue(context);
	}

	public void getData(String url,final OnMyResponse onMyResponse ,final Class<?> cl) {
		// 1,获得StringRequest对象  (1)请求的地址  （2）成功获得数据返回 （3）失败获得数据返回
	StringRequest m_StringRequest = new StringRequest(url,new Listener<String>() {
							@Override
							public void onResponse(String infor) {
								// 1,创建Gson对象
								Gson gson = new Gson();
								// 2,调用方法，解析json格式数据，转为对象
												
								Object ob = gson.fromJson(infor, cl);
								onMyResponse.onResponse(ob);
								
							}

						}, new ErrorListener() {

							@Override
							public void onErrorResponse(VolleyError arg0) {

							}
						});

				mQueue.add(m_StringRequest);
	}
}
