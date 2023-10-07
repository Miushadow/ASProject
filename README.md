# [移动端架构师成长体系课](https://class.imooc.com/sale/mobilearchitect)

本仓库为主项目仓库，仓库代码会跟随课程更新进行同步更新。

### 目录

- [项目结构介绍](#项目结构介绍)
- [如何运行](#如何运行)
- [课程增值电子书](https://doc.devio.org/as/)

### 项目结构介绍

```
AS
│   README.md
│  
└───ASProj 主项目
│   
└───hi-ui ui组件库
│   
└───hi-library library组件库
│
└───hi-config 配置中心SDK
│
└───flutter_module flutter_module模块
│
└───rn_module RN工程模块
│
└───hi-demo 架构师demo中心
```

### 如何运行

1. 本地创建AS文件夹
2. 将[ASProj](https://git.imooc.com/class-85/ASProj.git)、[hi-ui](https://git.imooc.com/class-85/hi-ui.git)、[hi-library](https://git.imooc.com/class-85/hi-library.git)、[hi-config](https://git.imooc.com/class-85/hi-config.git)、[flutter_module](https://git.imooc.com/class-85/flutter_module.git)、[rn_module](https://git.imooc.com/class-85/rn_module.git) clone到AS目录下，如上述的项目结构
    - AS打开flutter_module下的`pubspec.yaml`然后执行`flutter pub get`
    - 命令行切换到rn_module目录，然后执行：
	    - npm install
	    - npm start
3. 在local.properties中添加
    1. bintray.user=xxx
    2. bintray.apikey=xxx
    3. 其中xxx换成你自己的bintray账号
4. 用[Android Studio 4.1](https://developer.android.com/studio/preview)及以上版本打开项目运行


### FAQ
#### Unable to load class 'javax.xml.bind.JAXBException'.

1. 打开 Android Studio的Project Structure -> SDK Location，然后选择 Gradle Settings，选择Gradle JDK 为1.8（如果没有JDK 1.8需要手动安装）
2. 更多可参考（关于Project Structure设置的介绍）：https://stackoverflow.com/questions/51960049/android-build-error-unable-to-load-javax-xml-bind-jaxbexception
