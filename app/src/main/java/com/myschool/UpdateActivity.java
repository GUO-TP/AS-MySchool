package com.myschool;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends Activity implements OnClickListener {
	Button submit;
	Button ret;
	EditText etuserid;
	EditText etusernewpwd;
	//Context context;
	Handler  postHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.update_password);//����two.xml�ļ�
		
		 postHandler = new PostHandler();
		 
		submit=(Button) findViewById(R.id.button_submit);
		ret=(Button) findViewById(R.id.button_return);
		etuserid=(EditText)findViewById(R.id.id_ediText);
		etusernewpwd=(EditText)findViewById(R.id.newpassword_ediText);
		submit.setOnClickListener(this);
		ret.setOnClickListener(this);
	}
	@Override
	public void onClick(View vi) {
		// TODO Auto-generated method stub
		int v=vi.getId();
	     switch (v) {
	     case R.id.button_submit:
	    	 if(validate())
	    	 {
	    		 new PostThread().start();
	    	 }
	    	 
	    	    break;
	     case R.id.button_return:
	    
	    	 Intent intent = new Intent();
				//������ͼ
			intent.setClass(UpdateActivity.this,MainActivity.class);
	    	
             startActivity(intent);
             finish();
	    		break;
			default:
				break;
	     
	     
	     }
		 
	}
	
	private boolean validate() {
		// TODO Auto-generated method stub
		String username=etuserid.getText().toString().trim();
		String password=etusernewpwd.getText().toString().trim();
		if(username.equals("")){
			Toast.makeText(UpdateActivity.this,"id����Ϊ��", 0).show();
			return false;
		}
     if(password.equals("")){
			
			Toast.makeText(UpdateActivity.this,"�����벻��Ϊ��", 0).show();
	return false;
		}	
		return true;
	}

	
class PostThread extends Thread {
	@Override
	public void run() {
		super.run();
		String userid=etuserid.getText().toString().trim();
		String newpassword=etusernewpwd.getText().toString().trim();
		String url="http://192.168.1.107:8080/a_stusys/Student/updateStudent.do";
		//String url="http://192.168.1.107:8080/a_stusys/Student/showStudentByNameAndPassword.do?name="+username+"&password="+password+"";
		try {
			//����һ��URI���󣬲���ָ����������url��ַ
			URI uri = URI.create(url);
			
			//����HttpClient����
			HttpClient client = new DefaultHttpClient();
			
			//����HttpPost���󣬲��ҽ�uri��װ��������������
			HttpPost post = new HttpPost(uri);
			
			//�������ϣ�������װҪ���͵��������ļ�ֵ�Զ���NameValuePair
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			//����NameValuePair������Ӽ�ֵ����Ϣ
			NameValuePair pair1 = new BasicNameValuePair("id",  userid);
			NameValuePair pair2 = new BasicNameValuePair("password", newpassword);
			//��NameValuePair������ӵ�List������
			list.add(pair1);
			list.add(pair2);
			//Ϊ�����������Entity��Entity�з�װ�����������Ϣ
			post.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
			
			//ͨ��HttpClient����������������������������
			HttpResponse response = client.execute(post);
			
			//��ȡ״̬��
			int code = response.getStatusLine().getStatusCode();
			if(code == 200) {//�ж��Ƿ���Ӧ�ɹ�
				//ȡ����Ϣʵ��
				HttpEntity entity = response.getEntity();
				
				//����Ϣʵ��תΪ�ַ���
				String data = EntityUtils.toString(entity);
				
				//���ӷ�������ȡ�����ݷ��͵�UI�߳���ʾ
				Message msg = new Message();//����Message����������װҪ���͵�����
				msg.obj = data;//�����ݷ�װ��Message�����obj������
				postHandler.sendMessage(msg);//����Message����UI�߳�
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class PostHandler extends Handler {
	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		//ȡ������
		String data = (String) msg.obj;
		
		//��ʾ����
		if(data.equals("ok"))
		{
			Toast.makeText(UpdateActivity.this,"�޸ĳɹ�", 0).show();
		}
		else
			Toast.makeText(UpdateActivity.this,"�޸�ʧ��", 0).show();
		//tv_show.setText(data);
	}
}	
	
	
	
}