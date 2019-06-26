#手写简单版IOC


## IOC简介
***用过Spring框架的大家都知道，Spring的首要核心就是IOC容器，通过IOC容器来实例化和管理每个bean,对系统和应用之前解耦，
不需要开发人员过多的去关心每个bean去自己例化对象和管理对象直接相互依赖关系。这样大大的简化了Java企业级开发。***

##手写IOC流程
这次手写IOC主要是基于注解的形式来展现IOC是怎么实现，启动IOC容器并实例化Bean和获取对应的Bean
### IOC是怎么实现
    1.这次主要是基于注解形式，那么首先写创建两个自定义注解@Component这个注解表示使用IOC容器来管理这个类,@Bean的注解表示是一个Bean
    2.定义bean核心操作的类BeanFactory这这个类定义了怎么获取bean的最基本操作,
    3.BeanContainer通过名字就可以知道这个类主要是存放bean的容器
    4.AbstractBeanFactory 初步实现了从BeanContainer容器里获取bean的操作
    5.AnnotationBeanFactory 实现了扫描对应的自定义注解，实例化bean并存到IOC容器里
    类关系图如下：
![Image text](https://github.com/wpf008/Ioc/blob/master/image/IOC.png)
### 启动IOC容器&实例化Bean
    IOC的启动流程 new AnnotationBeanFactory(Class primarySources)-->得到工程的根包名-->扫描根包里所以的类通过判断获取到使用了@Component注解修饰的类和被@Bean注解修饰的方法名
    -->通过反射实例化对应bean-->存放到IOC容器里（如果bean已存在则报'The bean has defined' Exception）
    这样整个IOC的启动流程和实例化bean就已经完成
### 获取对应的Bean
    见源码test目录下的测试用例(可以直接运行的)







