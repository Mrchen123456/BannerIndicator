package com.example.administrator.bannerindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.administrator.bannerindicator.util.DisplayUtil;
import com.example.administrator.bannerindicator.widget.BannerIndicator;
import com.example.administrator.bannerindicator.widget.BannerIndicator.BannerClickListener;

import java.util.ArrayList;

/**
 * Created by ouyangshen on 2016/10/21.
 */
public class BannerIndicatorActivity extends AppCompatActivity implements BannerClickListener {
	private static final String TAG = "BannerIndicatorActivity";

	private TextView tv_pager;
	private BannerIndicator mBanner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_banner_indicator);
		tv_pager = (TextView) findViewById(R.id.tv_pager);

		mBanner = (BannerIndicator) findViewById(R.id.banner_indicator);
		LayoutParams params = (LayoutParams) mBanner.getLayoutParams();
		params.height = (int) (DisplayUtil.getSreenWidth(this) * 250f/ 640f);
		mBanner.setLayoutParams(params);
		
		ArrayList<Integer> bannerArray = new ArrayList<Integer>();
		bannerArray.add(Integer.valueOf(R.drawable.banner_1));
		bannerArray.add(Integer.valueOf(R.drawable.banner_2));
		bannerArray.add(Integer.valueOf(R.drawable.banner_3));
		bannerArray.add(Integer.valueOf(R.drawable.banner_4));
		bannerArray.add(Integer.valueOf(R.drawable.banner_5));
		mBanner.setImage(bannerArray);
		mBanner.setOnBannerListener(this);
	}                             

	@Override
	public void onBannerClick(int position) {
		String desc = String.format("您点击了第%d张图片", position+1);
		tv_pager.setText(desc);
	}

}
