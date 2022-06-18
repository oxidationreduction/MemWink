# MemWink

## 介绍
MemWink是一款基于Java Swing开发的记忆工具软件，应用艾宾浩斯遗忘曲线原理，依据人类记忆特征帮助用户科学地记忆信息。
软件引导用户将复杂的知识体系拆分成碎片化的知识元，并将其存储在虚拟卡片中，按照知识元的记忆阶段的记忆状况不断提醒用户进行记忆，
使用户逐步加强并形成对单个知识元的长期记忆，最终通过知识元的组合实现大型知识体系的建构。

更多项目详细信息，请访问[Gitee仓库](https://gitee.com/dreamBuilding/mem-wink)或

## 软件架构
### 环境依赖

> Java 17

### 主要目录说明

> AppIcon.iconsets : 应用程序图标

> image : 应用程序所需图片

> screenshot: 截图

> src/main/java/com.MemWink：源代码
>> Data：数据管理系统
>>> CardBag：卡片和卡包

>>> History：用户使用历史数据

>>> DataManager.java：数据管理中心

>> UI：用户界面管理程序

>>> component：界面基本组件

>>> dialog：对话框

>>> frame：程序窗口框架

>>> panel：功能面板

>>> UIManager.java：用户界面管理中心

>> util：程序工具

>>> constant：程序运行时要用的常量

>>> MemWinkUtil.java：可执行静态工具集合

> usrData：用户数据文件

>> cardbags：卡包数据文件

>> history：历史记录数据文件

>> example.csv：示例卡包源文件

## 安装包

#### Mac版(Intel)：

## 使用说明

### 卡包
- 卡包列表

<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/blob/dev/screenshot/卡包列表.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/blob/dev/screenshot/卡包列表.png">
  </a>
</p>

MemWink的默认首页，打开后首先进入的是卡包浏览器，所有的卡包呈圆角矩形，排列在页面的网格中

点击右下角的加号可以新建卡包，用户可以在弹出的窗口中指定卡包名、每天学习新卡的数量和卡包的颜色。
卡包的颜色不但可以体现在卡包浏览器中代表卡包的圆角矩形的颜色上，还将体现在卡片详情页中卡片的颜色上。

- 卡片浏览器

点击卡包后将进入卡包所属的卡片浏览器，左边是卡片的显示窗格，卡片排列在网格中；右边是筛选器，可以筛选不同记忆阶段、不同类别的卡片。

右上角是设置按钮，用户可以在此对卡包进行多种操作。

右下角是加卡按钮，用户可以通过手动输入或csv批量导入方式向卡包内添加卡片。

- 卡片详情页

可以展示卡片内容、记忆阶段和记忆历史等，同时支持更改排版。

- 卡片复习页

与"卡片详情页"相似，默认遮挡背面，用户可以尝试回忆卡片内容，之后再检查是否记住。

### 统计

统计用户的使用历史数据，以图表的形式展现。

### 帮助按钮

点击帮助按钮后，将导入一个示例卡包，用户可以在这个卡包中练习使用软件。

## 开发人员

