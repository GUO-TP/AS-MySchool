package com.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {

	/**
	 * 用来缓存图片的容器
	 */
	private Map<String, WeakReference<Bitmap>> map1 = new HashMap<String, WeakReference<Bitmap>>();

	/**
	 *
	 * @param onBitmapListener
	 *            显示图片的组件
	 * @param url
	 *            图片的地址
	 * @param file1
	 *            手机缓存文件
	 */
	public void loadImag(OnBitmapListener onBitmapListener, String url, File file1) {
		// 1,从容器里面获得位图
		WeakReference<Bitmap> WeakReference = map1.get(url);
		// 2,声明对象
		Bitmap bitmap = null;
		// 3,如果弱引用存在
		if (WeakReference != null) {
			// 4,从弱引用里取得位图
			bitmap = WeakReference.get();
		}
		// 5,如果位图存在
		if (bitmap != null) {
			// 6,把数据给调用者
			onBitmapListener.getBitmap(bitmap);
		}
		// 7,如果位图不存在
		else {
			try {
				// 8,通过url地址获得文件的名字
				String name = url.substring(url.lastIndexOf("/") + 1);// "http://img2.imgtn.bdimg.com/it/u=3452729668,1362003854&fm=21&gp=0.jpg"
				// 9,根据文件名字和缓存文件获得文件
				File file2 = new File(file1, name); // /data/data/test.act/cache/u=3452729668,1362003854&fm=21&gp=0.jpg
				// 10,如果文件存在
				if (file2.exists()) {
					// 11,把文件转为位图
					bitmap = BitmapFactory.decodeStream(new FileInputStream(
							file2));
				}
				// 12,如果位图存在
				if (bitmap != null) {// 如果从file中取到了
					// 13,把位图给显示的组件
					onBitmapListener.getBitmap(bitmap);
					// 14,把位图存放在容器
					map1.put(url, new WeakReference<Bitmap>(bitmap));
				}
				// 15,如果文件中没有取,则从网络中取
				else {
					// 16,异步的加载
					ImageTask imageTask = new ImageTask();
					imageTask.execute(onBitmapListener, url, file1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public class ImageTask extends AsyncTask<Object, Object, Bitmap> {
		OnBitmapListener onBitmapListener = null;
		String name = null;
		File file;
		String url;

		@Override
		protected Bitmap doInBackground(Object... objects) {
			onBitmapListener = (OnBitmapListener) objects[0];
			url = (String) objects[1];
			name = url.substring(url.lastIndexOf("/") + 1);// u=3452729668,1362003854&fm=21&gp=0.jpg
			file = (File) objects[2];
			Bitmap bitmap = null;
			try {
				//4,获得URL对象
				URL cr_url = new URL(url);
				//5,获得流
				InputStream bitmap_data = cr_url.openStream();
				//6,获得位图
				bitmap = BitmapFactory.decodeStream(bitmap_data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}

		@Override
		protected void onPostExecute(Bitmap bitmap) {
			if (bitmap != null) {
				// 1,把下载的位图给显示的组件
				onBitmapListener.getBitmap(bitmap);
				// 2,把位图存放在容器
				map1.put(url, new WeakReference<Bitmap>(bitmap));
				// 3,把位图保存在文件
				setBitmapToFile(file, name, bitmap);
			}
		}
	}

	private void setBitmapToFile(File file, String name, Bitmap bitmap) {
		try {
			// 1,根据缓存文件和名字创建文件
			file = new File(file, name);
			// 2,如果文件不存在
			if (!file.exists()) {
				// 3,创建文件
				file.createNewFile();
			}
			// 4,通过文件创建输入流
			FileOutputStream fos = new FileOutputStream(file);
			// 5,把位图写到文件里面
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);// 本项目只适合后缀名为.jpg的网络图片
			fos.flush();
			if (fos != null) {
				fos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
