package com.github.jokar.multilanguages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.github.jokar.multilanguages.utils.LocalManageUtil;

public class SettingActivity extends BaseActivity {
    private TextView mUserSelect;

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mUserSelect = findViewById(R.id.tv_user_select);
        mUserSelect.setText(getString(R.string.user_select_language,
                LocalManageUtil.getSelectLanguage(this)));
        //
        setClick();
    }

    public static void enter(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

    private void selectLanguage(int select) {
        LocalManageUtil.saveSelectLanguage(this, select);
        MainActivity.reStart(this);
    }

    private void setClick() {
        //璺熼殢绯荤粺
        findViewById(R.id.btn_auto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectLanguage(0);
            }
        });
        //绠€浣撲腑鏂?        findViewById(R.id.btn_cn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectLanguage(1);
            }
        });
        //绻佷綋涓枃
        findViewById(R.id.btn_traditional).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectLanguage(2);
            }
        });
        //english
        findViewById(R.id.btn_en).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectLanguage(3);
            }
        });
    }
}

