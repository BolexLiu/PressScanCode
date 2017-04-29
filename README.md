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

 android Version support:
 - minSdkVersion 14
 - maxSdkVersion 25+
