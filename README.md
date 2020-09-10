# ConstraintView  

_**Constraint for view in android app**_
  
  ---
[![](https://jitpack.io/v/hoangvuanhdevelopervn/sdimen.svg)](https://jitpack.io/#hoangvuanhdevelopervn/ConstraintView/1.0)  
[![GitHub license](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/ogiba/StyleableShareDialog/blob/master/LICENSE)  
[![Android](https://img.shields.io/badge/platform-android-green.svg)](https://developer.android.com/index.html)  
  
- A tool that helps you set the width and height of a view according to the aspect ratio of the screen or the aspect ratio of another view
  
- It proves very useful when you have to develop your application for many devices with different screen ratios. I always use this in my app. Now I public and hope this help for many Android developers.
  
  
  
![dp example](https://firebasestorage.googleapis.com/v0/b/tudiendanhngon-ba6bc.appspot.com/o/Image%2FLinhTinh%2FScreenshot_2020-09-10-19-50-59-889_com.hvasoftware.constraintview%5B1%5D.jpg?alt=media&token=e58a299d-bffd-4be9-992d-8603a407f163)  
  
  
  
-  You can see height of red view equal a half of screen
-  And width and height of green view equal a half of red view
  
  
# Gradle Dependency  
  
### Repository  
  
The Gradle dependency is available via [Constraintview](https://jitpack.io/#hoangvuanhdevelopervn/ConstraintView/1.0).  
  
To use JitPack repository you need to add to your root build.gradle line that it at the end of repositories:  
  
```gradle  
allprojects {  
   repositories { 
       //...        
       maven { url 'https://jitpack.io' }  
    }
 }
```  

And as next step add dependency to project:  
  
```gradle  
dependencies  {   
    //...
    implementation 'com.github.hoangvuanhdevelopervn:ConstraintView:1.0'

 }  
```  
  
  
  # Example
  
  
- Creating a view 
  
```xml  
<?xml version="1.0" encoding="utf-8"?>  
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"  
 xmlns:tools="http://schemas.android.com/tools"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent"  
  android:orientation="vertical"  
  tools:context=".ConstraintActivity">  
  
 <LinearLayout  android:id="@+id/viewRed"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:background="#EF5350"  
  android:gravity="center"  
  android:orientation="vertical"  
  android:visibility="visible">  
  
 <TextView  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:fontFamily="sans-serif-medium"  
  android:text="RED VIEW"  
  android:textColor="#ffffff"  
  android:textSize="16sp"  />  
 </LinearLayout>  
 
 <LinearLayout  android:id="@+id/viewGreen"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:background="#66BB6A"  
  android:gravity="center"  
  android:orientation="vertical">  
  
 <TextView  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:fontFamily="sans-serif-medium"  
  android:text="GREED VIEW"  
  android:textColor="#ffffff"  
  android:textSize="16sp"  />  
  
 </LinearLayout>  
 
 <LinearLayout  android:id="@+id/viewOrange"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:background="#FF7043"  
  android:gravity="center"  
  android:orientation="vertical">  
  
 <TextView  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:fontFamily="sans-serif-medium"  
  android:text="ORANGE VIEW"  
  android:textColor="#ffffff"  
  android:textSize="16sp"  />  
 </LinearLayout>  
 
</LinearLayout>  
```  
  
  
---  
 - Code in Kotlin  

```kotlin  

        // set width of view equal width of screen
        ConstraintView(this).setWidthRatioWithScreen(viewRed, 1, 0)

        // set height of view = 1/2 screen height
        ConstraintView(this).setHeightRatioWithScreen(viewRed, 2, 0)


        // width of view green will be equal 80% width of view red
        ConstraintView(this).setWidthRatioWithView(viewRed, viewGreen, 0.8, 0.0)

        // height of view green will be equal 20% height of view red
        ConstraintView(this).setHeightRatioWithView(viewRed, viewGreen, 0.2, 0.0)



        // width of view green will be equal 75% width of view red
        // width of view green will be equal 40% width of view red
        ConstraintView(this).getWidthAndHeightOfView(viewRed, object : IViewSizeCallback {
            override fun onSize(width: Int, height: Int) {
                ConstraintView(this@ConstraintActivity).setWidthAndHeightForView(
                    viewOrange,
                    width * 0.75,
                    height * 0.4
                )
            }
        })


        // width of view blue will be equal 85% width of screen
        // height of view green will be equal 40% height of screen
        ConstraintView(this@ConstraintActivity).setWidthAndHeightForView(
            viewBlue,
            ConstraintView(this).widthScreenPx() * 0.85,
            ConstraintView(this).heightScreenPx() * 0.4
        )
        

 ```


# Attention

- Use it carefully! It's can be constraint by one view in layout: All view will constraint with red view or screen. If green view constrain with red view, Orange view can't constraint with green view.
  