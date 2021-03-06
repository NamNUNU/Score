package com.example.anew.score;

/**
 * Created by new on 2016. 9. 19..
 */
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.anew.score.service.BTCTemplateService;

public class BackPressCloseHandler {

    private long backKeyPressedTime = 0;
    private BTCTemplateService mService;
    private Toast toast;

    private Activity activity;

    public BackPressCloseHandler(Activity context) {
        this.activity = context;
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
            toast.cancel();
        }
    }

    public void showGuide() {
        toast = Toast.makeText(activity,
                "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
        toast.show();
    }
}