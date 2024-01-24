# Compose Component

[![Download](https://img.shields.io/badge/download-App-blue.svg)](https://raw.githubusercontent.com/jenly1314/compose-component/master/app/release/app-release.apk)
[![MavenCentral](https://img.shields.io/maven-central/v/com.github.jenly1314/compose-component)](https://repo1.maven.org/maven2/com/github/jenly1314/compose-component)
[![JitPack](https://jitpack.io/v/jenly1314/compose-component.svg)](https://jitpack.io/#jenly1314/compose-component)
[![CircleCI](https://circleci.com/gh/jenly1314/compose-component.svg?style=svg)](https://circleci.com/gh/jenly1314/compose-component)
[![API](https://img.shields.io/badge/API-21%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/mit-license.php)
[![Blog](https://img.shields.io/badge/blog-Jenly-9933CC.svg)](https://jenly1314.github.io/)
[![QQGroup](https://img.shields.io/badge/QQGroup-20867961-blue.svg)](http://shang.qq.com/wpa/qunwpa?idkey=8fcc6a2f88552ea44b1.1.982c94fd124f7bb3ec227e2a400dbbfaad3dc2f5ad)

compose-component 是一个Jetpack Compose的组件库；主要提供了一些小组件，便于快速使用。

## Gif 展示

![Image](art/compose-component.gif)

> 你也可以直接下载 [演示App](https://raw.githubusercontent.com/jenly1314/compose-component/master/app/release/app-release.apk) 体验效果

## 引入

### Gradle:

1. 在Project的 **build.gradle** 或 **setting.gradle** 中添加远程仓库

    ```gradle
    repositories {
        //...
        mavenCentral()
    }
    ```

2. 在Module的 **build.gradle** 里面添加引入依赖项

    ```gradle
    implementation 'com.github.jenly1314:compose-component:1.1.0'
    ```

## 使用说明

**compose** 组件的使用大都比较直观，一般只需看一下 Composable 函数对应的参数说明基本就会使用了。

> 如果通过参数还是没太看懂怎么用的，你也可以通过直接看下面各个组件对应的代码示例来加深理解。

### 组件说明

这里列一下目前 **compose-component** 所包含的一些组件，方便快速查找。

| 组件名称                     | 组件说明        | 组件使用示例                                                                                                     | 组件示例效果图                                             |
|:-------------------------|:------------|:-----------------------------------------------------------------------------------------------------------|:----------------------------------------------------|
| CircularChartIndicator   | 圆形图表指示器     | [代码示例](app/src/main/java/com/king/compose/component/app/component/chart/CircularChartIndicatorSample.kt)   | [示例图](art/CircularChartIndicatorSamplePreview.png)  |
| HorizontalChartIndicator | 水平图表指示器     | [代码示例](app/src/main/java/com/king/compose/component/app/component/chart/HorizontalChartIndicatorSample.kt) | [示例图](art/HorizontalCharIndicatorSamplePreview.png) |
| VerticalChartIndicator   | 垂直图表指示器     | [代码示例](app/src/main/java/com/king/compose/component/app/component/chart/VerticalChartIndicatorSample.kt)   | [示例图](art/VerticalChartIndicatorSamplePreview.png)  |
| TextField                | 文本输入框（正则限制） | [代码示例](app/src/main/java/com/king/compose/component/app/component/text/TextFieldSample.kt)                 | [示例图](art/TextFieldSamplePreview.png)               |
| SideBar                  | 字母索引侧边栏     | [代码示例](app/src/main/java/com/king/compose/component/app/component/bar/SideBarSample.kt)                    | [示例图](art/SideBarSamplePreview.png)                 |
| AnimatedDialog           | 动画对话框       | [代码示例](app/src/main/java/com/king/compose/component/app/component/dialog/AnimatedDialogSample.kt)          | [示例图](art/AnimatedDialogSamplePreview.gif)          |

> 后续会根据需求场景，不定期补充各种小组件。

更多使用详情，请查看[app](app)中的源码使用示例或直接查看 [API帮助文档](https://jitpack.io/com/github/jenly1314/compose-component/latest/javadoc/)

## 相关推荐

#### [CodeTextField](https://github.com/jenly1314/CodeTextField)一个使用 Compose 实现的验证码输入框。
#### [UltraSwipeRefresh](https://github.com/jenly1314/UltraSwipeRefresh)一个可带来极致体验的 **Compose** 刷新组件；支持下拉刷新和上拉加载，可完美替代官方的 **SwipeRefresh**；并且支持的功能更多，可扩展性更强。

## 版本记录

#### v1.1.0：2024-1-21

* 新增`AnimatedDialog`（动画对话框：主要是在`Dialog`的基础之上增加了可见性过渡动画，并解决`Dialog`的宽度显示问题）

#### v1.0.0：2023-9-3

* compose-component初始版本

## 赞赏

如果您喜欢compose-component，或感觉compose-component帮助到了您，可以点右上角“Star”支持一下，您的支持就是我的动力，谢谢 :smiley:
<p>您也可以扫描下面的二维码，请作者喝杯咖啡 :coffee:

<div>
   <img src="https://jenly1314.github.io/image/page/rewardcode.png">
</div>

## 关于我

| 我的博客                                                                                | GitHub                                                                                  | Gitee                                                                                  | CSDN                                                                                 | 博客园                                                                            |
|:------------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------|
| <a title="我的博客" href="https://jenly1314.github.io" target="_blank">Jenly's Blog</a> | <a title="GitHub开源项目" href="https://github.com/jenly1314" target="_blank">jenly1314</a> | <a title="Gitee开源项目" href="https://gitee.com/jenly1314" target="_blank">jenly1314</a>  | <a title="CSDN博客" href="http://blog.csdn.net/jenly121" target="_blank">jenly121</a>  | <a title="博客园" href="https://www.cnblogs.com/jenly" target="_blank">jenly</a>  |

## 联系我

| 微信公众号    | Gmail邮箱                                                                          | QQ邮箱                                                                              | QQ群                                                                                                                       | QQ群                                                                                                                       |
|:---------|:---------------------------------------------------------------------------------|:----------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------|
| Jenly666 | <a title="给我发邮件" href="mailto:jenly1314@gmail.com" target="_blank">jenly1314</a> | <a title="给我发邮件" href="mailto:jenly1314@vip.qq.com" target="_blank">jenly1314</a> | <a title="点击加入QQ群" href="https://qm.qq.com/cgi-bin/qm/qr?k=6_RukjAhwjAdDHEk2G7nph-o8fBFFzZz" target="_blank">20867961</a> | <a title="点击加入QQ群" href="https://qm.qq.com/cgi-bin/qm/qr?k=Z9pobM8bzAW7tM_8xC31W8IcbIl0A-zT" target="_blank">64020761</a> |

<div>
   <img src="https://jenly1314.github.io/image/page/footer.png">
</div>