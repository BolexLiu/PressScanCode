# PressScanCode
A View code can be achieved on the basis of the two-dimensional code. WebView can also.
After integration, you need only three lines of code can be resolved.


![](./tips.gif)

## Support View
- View on any screen

## usage

- Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
- Add the dependency
  
  ```
  	dependencies {
	        compile 'com.github.BolexLiu:PressScanCode:v1.0.0'
	}
  ```
 - Specific code usage
 ```
                /**
                  * view  You need to scan the view
                  *ScanCall Callback scan results
                  */
   ScanTools.scanCode(view, new ScanTools.ScanCall() {
                     @Override
                     public void getCode(String code) {
                         Toast.makeText(ScanSimpleActivity.this,code,Toast.LENGTH_SHORT).show();
                     }
                 });
 ```

 android Version support:
 - minSdkVersion 14
 - maxSdkVersion 25+
 
 
 # 中文
 
 # PressScanCode
一个可实现长按扫描 View 上的二维码的工具库。webView 也可以。
集成后您仅需三行代码就可以实现解析。


![](./tips.gif)

## 支持
- 任意屏幕上可见的View

## 用法

- 添加到你项目的根build.gradle脚本代码中:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
- 添加 dependency
  
  ```
  	dependencies {
	        compile 'com.github.BolexLiu:PressScanCode:v1.0.0'
	}
  ```
 - 使用方法
 ```
                /**
                  * view 你要扫描的view
                  *ScanCall 回调扫码结果
                  */
   ScanTools.scanCode(view, new ScanTools.ScanCall() {
                     @Override
                     public void getCode(String code) {
                         Toast.makeText(ScanSimpleActivity.this,code,Toast.LENGTH_SHORT).show();
                     }
                 });
 ```
 - 其它问题
 
 1.能否提供一个是否为二维码功能？

 可以自己扩展一下。在用户长按的时候先将图片扫描一遍，如果有code返回说明该view里包含里一个二维码。
 则在菜单中显示『识别二维码』。如果没有返回code那么菜单中就无此选项『识别二维码』。
 当用户点击该选项时，再将之前识别到的二维码直接解析。而不是重新扫描一遍。
 所以这个功能不应该被包含在本工具中。工具不该含业务。请自己实现。
 
 2.如果屏幕内包含两个View的情况下。
 
 嗯，这是一个问题，目前正在解决这个问题。我有测试微信的效果是，用户手指触摸在哪个区域就截图哪个区域的二维码，敬请期待。


 android 版本支持:
 - minSdkVersion 14
 - maxSdkVersion 25+
