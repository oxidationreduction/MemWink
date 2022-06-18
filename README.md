# MemWink

## 介绍
MemWink是一款基于Java Swing开发的记忆工具软件，应用艾宾浩斯遗忘曲线原理，依据人类记忆特征帮助用户科学地记忆信息。
软件引导用户将复杂的知识体系拆分成碎片化的知识元，并将其存储在虚拟卡片中，按照知识元的记忆阶段的记忆状况不断提醒用户进行记忆，使用户逐步加强并形成对单个知识元的长期记忆，最终通过知识元的组合实现大型知识体系的建构。

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

### 主界面

<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/cardbags.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/cardbags.png"width="731"height="500">
  </a>
</p>

软件打开后首先进入的是卡包浏览器，这是MemWink的默认首页。

左侧是导航栏。左上角的两个按钮从上到下分别代表卡包页面和统计页面，您可以通过点击这两个按钮前往不同的页面。左下角是帮助按钮。点击这个按钮将会弹出一个对话框，提示您是否添加帮助卡包。帮助卡包也是一个普通的卡包，由开发者制作，内部含有软件提示信息，您可以通过查看并使用帮助卡包了解并熟悉软件的使用技巧。

### 卡包
- 卡包列表

<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/cardbags.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/cardbags.png"width="731"height="500">
  </a>
</p>

软件打开后或点击卡包按钮后将进入这个页面。所有的卡包呈圆角矩形，排列在页面的网格中。

<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/add_cardbag.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/add_cardbag.png"width="731"height="500">
  </a>
</p>

点击右下角的加号可以新建卡包，用户可以在弹出的窗口中指定卡包名、每天学习新卡的数量和卡包的颜色。如果您输入的数据格式有误，右下角的确认按钮将无法被点击。

<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/duplicate_cardbagname.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/duplicate_cardbagname.png"width="731"height="500">
  </a>
</p>

卡包名不可以重复。如果您输入的卡包名与已有的卡包名重复，点击确认按钮后相应的句段将标红，提示您存在重名现象。应当进行修改。

卡包的颜色不但可以体现在卡包浏览器中代表卡包的圆角矩形的颜色上，还将体现在卡片详情页中卡片的颜色上。

- 卡片列表

<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/cards.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/cards.png"width="731"height="500">
  </a>
</p>

点击卡包后将进入卡包所属的卡片浏览器，左边是卡片的显示窗格，卡片排列在网格中；右边是筛选器，点击后可以筛选不同记忆阶段、不同类别的卡片。

右上角是设置按钮，用户可以在此对卡包进行多种操作。

右下角是加卡按钮，用户可以通过手动输入或csv批量导入方式向卡包内添加卡片。

- 卡片详情页

可以展示卡片内容、记忆阶段和记忆历史等，默认遮挡背面。

<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/card_content_hide.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/card_content_hide.png"width="731"height="500">
  </a>
</p>

<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/card_content_show.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/card_content_show.png"width="731"height="500">
  </a>
</p>

还可以更改排版
<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/layout_adjust.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/layout_adjust.png"width="731"height="500">
  </a>
</p>

改变记忆阶段或卡片分类
<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/stage_change.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/stage_change.png"width="731"height="500">
  </a>
</p>
<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/categories.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/categories.png"width="731"height="500">
  </a>
</p>

修改卡片内容
<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/content_edit.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/content_edit.png"width="731"height="500">
  </a>
</p>

- 卡片复习页

与"卡片详情页"布局相似，默认遮挡背面，用户可以尝试回忆卡片内容，之后再检查是否记住。

对于记忆阶段不是“新卡”的卡片，复习页面上将显示一个倒计时模块，记忆操作应当在限时之内完成。
<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/memory.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/memory.png"width="731"height="500">
  </a>
</p>

记忆结束后将显示“记忆完成”页面，用于统计本次学习的数据。

- 设计细节说明

卡片上应当记载什么？
> 一张卡片分为正反两面，正面记载的是提示信息，反面记载的是知识点的核心内容，复习的时候您应当利用卡片正面的信息在规定时间内回忆出卡片背面的内容。

为什么复习时只有“记住了”和“没记住”两种结果？如果我有“大致印象”，应该选哪个？
> 根据互联网上的资料和作者多年的生活、学习经验，记忆知识点的时候，坚决不能将“模糊记忆”“大致印象”算为“记住了”。学习时，只要不能完整地复述整个知识点，就应当把这个知识点归为“没记住”重新学习。否则在之后对知识点的使用过程中，尤其是考试过程中，您将大概率无法准确回忆出这个知识点的内容，那么您以往对这个知识点的学习过程都将作废，毫无价值。您在使用本软件的过程中，也应当注意严格要求自己，只要不能完整而正确地回忆出卡片背面的内容，就应当选择“没记住”等待重新学习。

卡包内部的分类有什么作用？
> 一个卡包内不同的卡片，也可能属于一个知识体系的不同分支。由您按照自己的分类标准指定这些分支。卡包内部的分类相当于在卡包内开辟小卡包，实现卡包内卡片的进一步分类。

这些分类还可以再次被归类吗？比如创建多级分类把几个分类放进一个文件夹中？
> 不能。 人脑和电脑不一样， 您在电脑中可以通过创建多层级的文件夹分类管理您的文件，但人脑无法通过右键单击建立一个永久性的文件夹。卡包内的知识存储体系应当与您大脑中的知识存储体系相同。分类层级过多的时候，对于人脑来说，虽然看起来分类逻辑更加清晰，但实际上更加难以记忆。因此卡包内的分类只能有一集，这是为了提高记忆效率。

为什么排版针对的是卡包内的所有卡片？有的卡片无法适应排版该怎么办？
> 一个卡包内的所有卡片内容量应当相似，因此可以适应同一种排版。如果您发现某张卡片无法适应排版，您应当考虑更改此卡片上的内容，比如将这一张卡片拆分为张卡片，使其与其他卡片的内容量相似，以适应排版。

### 统计

统计用户的使用历史数据，以图表的形式展现。
<p align="center">
  <a href="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/statistic.png">
   <img alt="WeSync" src="https://gitee.com/dreamBuilding/mem-wink/raw/dev/screenshot/statistic.png"width="731"height="500">
  </a>
</p>

（注意：左边图标的数据不是真实使用数据，仅是用于展示显示效果的示例）

## 开发人员信息

软件开发于2022年6月，是北京航空航天大学软件学院面向对象课程的大作业，开发者参考了其经常使用的一种单词本软件《WinkNotes》，在此感谢此软件的开发者团队。


