package com.example.a22520718_lab4_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode, btnBlinkXml, btnBlinkCode,
            btnZoomInXml, btnZoomInCode, btnZoomOutXml, btnZoomOutCode, btnRotateXml,
            btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml, btnBounceCode, btnCombineXml, btnCombineCode;

    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }

    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }

    private void handleClickAnimationCode(Button btn, final Animation animation) {
    // Handle onclickListenner to start animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }

    private Animation initFadeInAnimation()
    {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initFadeOutAnimation() {
        AlphaAnimation animation = new AlphaAnimation(1f, 0f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initBlinkAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(500);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        return animation;
    }
    private Animation initZoomInAnimation() {
        ScaleAnimation zoomIn = new ScaleAnimation(
                0f, 1f,
                0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        zoomIn.setDuration(2000);
        zoomIn.setFillAfter(true);
        return zoomIn;
    }
    private Animation initZoomOutAnimation() {
        ScaleAnimation zoomOut = new ScaleAnimation(
                1f, 0f,
                1f, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        zoomOut.setDuration(2000);
        zoomOut.setFillAfter(true);
        return zoomOut;
    }
    private Animation initRotateAnimation() {
        RotateAnimation rotate = new RotateAnimation(
                0f, 1080f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotate.setDuration(3000);
        rotate.setFillAfter(true);
        rotate.setRepeatCount(0);
        rotate.setInterpolator(new LinearInterpolator());
        return rotate;
    }





    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();

        //load the animation
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_fade_in);
        final Animation animation1= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_blink);
        final Animation animation2= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_bounce);
        final Animation animation3= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_fade_out);
        final Animation animation4= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_move);
        final Animation animation5= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate);
        final Animation animation6= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_slide_up);
        final Animation animation7= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_zoom_in);
        final Animation animation8= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_zoom_out);
        final Animation animation9= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_combine);


        //set animation listener
        animation.setAnimationListener(animationListener);

        //Handle onclickListener to start animation
        btnFadeInXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
        btnBlinkXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation1);
            }
        });
        btnBounceXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation2);
            }
        });
        btnCombineXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation9);
            }
        });
        btnFadeOutXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation3);
            }
        });
        btnMoveXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation4);
            }
        });
        btnRotateXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation5);
            }
        });
        btnSlideUpXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation6);
            }
        });
        btnZoomInXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation7);
            }
        });
        btnZoomOutXml.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation8);
            }
        });

        //handleClickAnimationCode
        handleClickAnimationCode(btnFadeInCode, initFadeInAnimation());
        handleClickAnimationCode(btnFadeOutCode, initFadeOutAnimation());
        handleClickAnimationCode(btnBlinkCode, initBlinkAnimation());
        handleClickAnimationCode(btnZoomInCode, initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode, initZoomOutAnimation());
        handleClickAnimationCode(btnRotateCode, initRotateAnimation());

        //su kien nhan vao logo
        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển sang Main2Activity
                Intent iNewActivity = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(iNewActivity);

                // Gọi hiệu ứng chuyển đổi
                overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);
            }
        });



    }




}