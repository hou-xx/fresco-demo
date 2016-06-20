package com.hxx.frecsodemo;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.activity_main)
    ConstraintLayout activityMain;
    private String urlDog = "http://img5.imgtn.bdimg.com/it/u=2026257126,3002325057&fm=21&gp=0.jpg";
    private String urlGif = "http://img5.imgtn.bdimg.com/it/u=2462868875,1126990464&fm=21&gp=0.jpg";
    private String urlAndroid = "http://img2.imgtn.bdimg.com/it/u=1650857368,712447780&fm=21&gp=0.jpg";
    private String urlLast = "http://img2.imgtn.bdimg.com/it/u=2741541328,448227058&fm=21&gp=0.jpgF";

    @Bind(R.id.image_leftTop)
    SimpleDraweeView imageLeftTop;
    @Bind(R.id.image_leftBottom)
    SimpleDraweeView imageLeftBottom;
    @Bind(R.id.image_rightTop)
    SimpleDraweeView imageRightTop;
    @Bind(R.id.image_rightBottom)
    SimpleDraweeView imageRightBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initImage();
    }

    /**
     * 为SimpleDraweeView绑定图片地址
     */
    private void initImage() {
        //设置gif图自动播放
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder().setUri(urlGif)
                .setAutoPlayAnimations(true).build();
        imageLeftTop.setImageURI(Uri.parse(urlDog));
        imageLeftBottom.setController(controller);
        imageRightTop.setImageURI(Uri.parse(urlAndroid));
        imageRightBottom.setImageURI(Uri.parse(urlLast));
    }

    /**
     * 对textview点击监听，控制gif图播放
     */
    @OnClick(R.id.text)
    public void onClick() {
        Animatable animatableRT = imageRightTop.getController().getAnimatable();
        Animatable animatableRB = imageRightBottom.getController().getAnimatable();
        if (animatableRT != null) {
            if (animatableRT.isRunning()) {
                animatableRT.stop();
                text.setText("播放动画");
            } else {
                animatableRT.start();
                text.setText("停止动画");
            }
        }
        if (animatableRB != null) {
            if (animatableRB.isRunning())
                animatableRB.stop();
            else animatableRB.start();
        }
    }
}
