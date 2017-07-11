package com.example.chiachen.loginpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.List;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

	@BindViews({R.id.info_list, R.id.info_token})
	List<View> mBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}

	@OnClick({R.id.info_token, R.id.info_list})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.info_token: {
				NetworkWrapper.getToken("ken","hello");
				Log.e(MainActivity.class.getSimpleName(), "info_token");
				break;
			}

			case R.id.info_list: {
				Log.e(MainActivity.class.getSimpleName(), "info_list");
				break;
			}
		}
	}
}
