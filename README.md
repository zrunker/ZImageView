# ZImageView
ImageView缩放图，双击放大，再次点击缩小，支持手势放大与缩小，自由移动。支持点击事件和长按事件监听，支持ViewPager一起使用事件分发。同时提供圆角图片管理类，可以设置ImageView圆角显示，支持视图裁剪等功能。

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

### 二、View视图裁剪

```
// View圆形裁剪
ImageView imageView.setImageResource(R.drawable.ibooker_144);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        ViewOutlineProviderUtil viewOutlineProviderUtil = new ViewOutlineProviderUtil();
        viewOutlineProviderUtil.setOval(imageView, 0, 0, 0, 0);
}
```

### 三、ScaleImageView缩放图

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
