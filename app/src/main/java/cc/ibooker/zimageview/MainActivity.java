package cc.ibooker.zimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import cc.ibooker.zimageviewlib.CircleImgViewUtil;
import cc.ibooker.zimageviewlib.ScaleImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 圆角图
        ImageView imageView = findViewById(R.id.image);
        CircleImgViewUtil circleImgViewUtil = new CircleImgViewUtil(this);
        circleImgViewUtil.setImageResource(imageView, R.drawable.ibooker_144);

        // 缩放图
        ScaleImageView scaleImageView = findViewById(R.id.scaleImageView);
        scaleImageView.setOnMyClickListener(new ScaleImageView.OnMyClickListener() {
            @Override
            public void onMyClick(View v) {
                // 单击事件监听
                Toast.makeText(MainActivity.this, "单击事件", Toast.LENGTH_SHORT).show();
            }
        });
        scaleImageView.setOnMyLongClickListener(new ScaleImageView.OnMyLongClickListener() {
            @Override
            public void onMyLongClick(View v) {
                // 长按事件监听
                Toast.makeText(MainActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
