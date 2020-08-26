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
		// 1,��� RequestQueue����
		mQueue = Volley.newRequestQueue(context);
	}

	public void getData(String url,final OnMyResponse onMyResponse ,final Class<?> cl) {
		// 1,���StringRequest����  (1)����ĵ�ַ  ��2���ɹ�������ݷ��� ��3��ʧ�ܻ�����ݷ���
	StringRequest m_StringRequest = new StringRequest(url,new Listener<String>() {
							@Override
							public void onResponse(String infor) {
								// 1,����Gson����
								Gson gson = new Gson();
								// 2,���÷���������json��ʽ���ݣ�תΪ����
												
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
