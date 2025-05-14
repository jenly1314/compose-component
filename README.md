# Compose Component

[![MavenCentral](https://img.shields.io/maven-central/v/com.github.jenly1314/compose-component?logo=sonatype)](https://repo1.maven.org/maven2/com/github/jenly1314/compose-component)
[![JitPack](https://img.shields.io/jitpack/v/github/jenly1314/compose-component?logo=jitpack)](https://jitpack.io/#jenly1314/compose-component)
[![CI](https://img.shields.io/github/actions/workflow/status/jenly1314/compose-component/build.yml?logo=github)](https://github.com/jenly1314/compose-component/actions/workflows/build.yml)
[![Download](https://img.shields.io/badge/download-APK-brightgreen?logo=github)](https://raw.githubusercontent.com/jenly1314/compose-component/master/app/release/app-release.apk)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen?logo=android)](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)
[![License](https://img.shields.io/github/license/jenly1314/compose-component?logo=open-source-initiative)](https://opensource.org/licenses/mit)


compose-component 是一个Jetpack Compose的组件库；主要提供了一些小组件，便于快速使用。

## 效果展示

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

2. 在Module的 **build.gradle** 中添加依赖项

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

更多使用详情，请查看[app](app)中的源码使用示例或直接查看 [API帮助文档](https://jenly1314.github.io/compose-component/api/)

## 相关推荐
- [UltraSwipeRefresh](https://github.com/jenly1314/UltraSwipeRefresh)一个可带来极致体验的 Compose 刷新组件；支持下拉刷新和上拉加载，可完美替代官方的 **SwipeRefresh** ；并且支持的功能更多，可扩展性更强。
- [CodeTextField](https://github.com/jenly1314/CodeTextField)一个使用 Compose 实现的验证码输入框。
- [SplitEditText](https://github.com/jenly1314/SplitEditText)一个灵活的分割编辑框。常常应用于验证码输入、密码输入、等场景。
- [SpinCounterView](https://github.com/jenly1314/SpinCounterView) 一个类似码表变化的旋转计数器动画控件。
- [CounterView](https://github.com/jenly1314/CounterView) 一个数字变化效果的计数器视图控件。
- [RadarView](https://github.com/jenly1314/RadarView) 一个雷达扫描动画后，然后展示得分效果的控件。
- [SuperTextView](https://github.com/jenly1314/SuperTextView) 一个在TextView的基础上扩展了几种动画效果的控件。
- [LoadingView](https://github.com/jenly1314/LoadingView) 一个圆弧加载过渡动画，圆弧个数，大小，弧度，渐变颜色，完全可配。
- [WaveView](https://github.com/jenly1314/WaveView) 一个水波纹动画控件视图，支持波纹数，波纹振幅，波纹颜色，波纹速度，波纹方向等属性完全可配。
- [GiftSurfaceView](https://github.com/jenly1314/GiftSurfaceView) 一个适用于直播间送礼物拼图案的动画控件。
- [FlutteringLayout](https://github.com/jenly1314/FlutteringLayout) 一个适用于直播间点赞桃心飘动效果的控件。
- [DragPolygonView](https://github.com/jenly1314/DragPolygonView) 一个支持可拖动多边形，支持通过拖拽多边形的角改变其形状的任意多边形控件。
- [CircleProgressView](https://github.com/jenly1314/CircleProgressView) 一个圆形的进度动画控件，动画效果纵享丝滑。
- [ArcSeekBar](https://github.com/jenly1314/ArcSeekBar) 一个弧形的拖动条进度控件，配置参数完全可定制化。
- [DrawBoard](https://github.com/jenly1314/DrawBoard) 一个自定义View实现的画板；方便对图片进行编辑和各种涂鸦相关操作。
- [ImageViewer](https://github.com/jenly1314/ImageViewer) 一个图片查看器，一般用来查看图片详情或查看大图时使用。

<!-- end -->

## 版本日志

#### v1.1.0：2024-1-21
* 新增`AnimatedDialog`（动画对话框：主要是在`Dialog`的基础之上增加了可见性过渡动画，并解决`Dialog`的宽度显示问题）

#### [查看更多版本日志](CHANGELOG.md)

---

![footer](https://jenly1314.github.io/page/footer.svg)
