# PressScanCode
一个可实现长按扫描 View 上的二维码的工具库。webView 也可以。
集成后您仅需三行代码就可以实现解析。


![](./tips.gif)

## 支持
- 任意屏幕上可见的View

## 用法

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
 - usage
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
