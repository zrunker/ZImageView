# ZImageView
ImageView缩放图，双击放大，在点击缩小，同时支持手势放大与缩小。支持点击事件和长按事件监听。同时提供圆角图片管理类，可以设置ImageView圆角显示。

引入资源：

1、在build.gradle文件中添加以下代码：
```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
	compile 'com.github.zrunker:ZImageView:v1.0'
}
```
2、在maven文件中添加以下代码：
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
	<groupId>com.github.zrunker</groupId>
	<artifactId>ZImageView</artifactId>
	<version>v1.0</version>
</dependency>
```

### 一、CircleImgViewUtil圆形图片管理类。

```
// 圆角图
ImageView imageView = findViewById(R.id.image);
CircleImgViewUtil circleImgViewUtil = new CircleImgViewUtil(this);

circleImgViewUtil.setImageResource(imageView, R.drawable.ibooker_144);
//        circleImgViewUtil.setImageBitmap(imageView, Bitmap);
//        circleImgViewUtil.setImageDrawable(imageView, Drawable);
//        circleImgViewUtil.setImageIcon(imageView, Icon);
//        circleImgViewUtil.setImageURI(imageView, Uri);
```
通过CircleImgViewUtil给ImageView变量赋值，就能实现圆形图。

### 二、ScaleImageView缩放图

引入布局文件：
```
<cc.ibooker.zimageviewlib.ScaleImageView
        android:id="@+id/scaleImageView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/ibooker" />
```

Activity中使用：
```
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
```
