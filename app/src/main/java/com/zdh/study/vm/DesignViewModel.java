package com.zdh.study.vm;

import android.app.Application;

import androidx.annotation.NonNull;

import com.zdh.study.ui.design.build.Director;
import com.zdh.study.ui.design.build.MoonComputerBuilder;
import com.zdh.study.ui.design.facade.ZhangWuJi;
import com.zdh.study.ui.design.factory.HpComputer;
import com.zdh.study.ui.design.factory.LenovoComputer;
import com.zdh.study.ui.design.factory.simple.ComputerFactory;
import com.zdh.study.ui.design.factory.simple.GDComputerFactory;
import com.zdh.study.ui.design.instance.Singleton;
import com.zdh.study.ui.design.instance.Singleton1;
import com.zdh.study.ui.design.instance.Singleton2;
import com.zdh.study.ui.design.observer.SubscriptionSubject;
import com.zdh.study.ui.design.observer.WeiXinUser;
import com.zdh.study.ui.design.ornament.HongQiGong;
import com.zdh.study.ui.design.ornament.OuYangFeng;
import com.zdh.study.ui.design.ornament.YangGuo;
import com.zdh.study.ui.design.proxy.DynamicPurchasing;
import com.zdh.study.ui.design.proxy.IShop;
import com.zdh.study.ui.design.proxy.Purchaser;
import com.zdh.study.ui.design.proxy.Zhangdh;
import com.zdh.study.ui.design.strategy.CommonRivalStrategy;
import com.zdh.study.ui.design.strategy.StrategyContext;
import com.zdh.study.ui.design.strategy.StrongRivalStrategy;
import com.zdh.study.ui.design.strategy.WeakRivalStrategy;

import java.lang.reflect.Proxy;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class DesignViewModel extends BaseViewModel {
    public DesignViewModel(@NonNull Application application) {
        super(application);
    }

    public BindingCommand jumpInstanceCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });

    /*
    * @author mousse
    * create time 2023/3/21 10:00
    * description:建造者模式有以下角色
    * 定义：将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
    * Director:导演类，负责安排已有模块的顺序，然后通知builder创建
    * Builder:抽象类，规范产品的创建，一般由子类实现
    * ConcreteBuilder:具体建造者，实现抽象builder类定义的所有方法，返回一个组建好的对象
    * Product:产品类
    */
    public BindingCommand buildCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            MoonComputerBuilder moonComputerBuilder = new MoonComputerBuilder();
            Director director = new Director(moonComputerBuilder);
            director.CreateComputer("i5","晓龙","天机");
        }
    });
    public BindingCommand factoryCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //简单工厂模式
            ComputerFactory.createComputer("hp").start();
            ComputerFactory.createComputer("lenovo").start();
            ComputerFactory.createComputer("asus").start();
            //工厂方法模式
            GDComputerFactory gdComputerFactory = new GDComputerFactory();
            LenovoComputer lenovoComputer = gdComputerFactory.createComputer(LenovoComputer.class);
            lenovoComputer.start();
            HpComputer hpComputer = gdComputerFactory.createComputer(HpComputer.class);
            hpComputer.start();
        }
    });


    /*
    * @author mousse
    * create time 2023/3/21 10:16
    * description:代理模式
    * 定义：为其他对象提供一种代理以控制对这个对象的访问，有以下角色
    * Subject:抽象主题类，声明真实主题与代理的共同接口方法
    * RealSubject:真实主题类，代理类所代表的真实主题，客户端可以通过代理类间接地调用真实主题类的方法
    * Proxy:代理，持有对真实主题的引用，在其所实现的接口方法中，调用真实主题类相应的接口方法
    */
    public BindingCommand proxyCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //静态代理：在代码运行前就已经存在类代理类的class编译文件
            Zhangdh zhangdh = new Zhangdh();
            Purchaser purchaser = new Purchaser(zhangdh);
            purchaser.buy();
            //动态代理
            //创建被代理类
            IShop zdh = new Zhangdh();
            //创建动态代理
            DynamicPurchasing dynamicPurchasing = new DynamicPurchasing(zdh);
            //创建zdh的ClassLoad
            ClassLoader loader = zdh.getClass().getClassLoader();
            IShop iShop = (IShop) Proxy.newProxyInstance(loader, new Class[]{IShop.class}, dynamicPurchasing);
            iShop.buy();
        }
    });

    /*
    * @author mousse
    * create time 2023/3/21 11:12
    * description:装饰者模式：动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更为灵活
    * Component:抽象组件，可以是接口，或者是抽象类，即被装饰的最原始的对象这里指Swordsman
    * ConcreteComponent:组件具体实现类，被装饰的具体对象这里指YangGuo
    * Decorator:抽象装饰者，从外类来拓展Component雷达额功能，
    * ConcreteDecorator:装饰者的具体实现类 这里指欧阳锋，洪七公
    */
    public BindingCommand ornamentCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            YangGuo yangGuo = new YangGuo();
            HongQiGong hongQiGong = new HongQiGong(yangGuo);
            hongQiGong.attackMagic();
            OuYangFeng ouYangFeng = new OuYangFeng(yangGuo);
            ouYangFeng.attackMagic();
        }
    });

    /*
    * @author mousse
    * create time 2023/3/21 11:38
    * description:外观模式/门面模式
    * 要求一个子系统的外部与内部的通讯必须通过一个统一的对象进行，此模式提供一个高层的接口，是的子系统更易于应用
    * facade:外观类，知道哪些子系统负责处理请求，将客户端的请求代理给适当的子系统对象，这里指张无忌
    * subsystem:子系统类，可以有以恶或者多个子系统类，h实现子系统的功能，处理外观类指派的任务，子系统类不包含外观类的应用，这里指经脉，内功，招式
    */
    public BindingCommand facadeCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ZhangWuJi zhangWuJi = new ZhangWuJi();
            zhangWuJi.QianKun();
            zhangWuJi.QiShangQuan();
        }
    });

    /*
    * @author mousse
    * create time 2023/3/21 13:20
    * description:策略设计模式:定义一系列算法，把每种算法封装起来。并使他们可以相互替换，策略模式使算法可独立于使用它的客户而独立变化
    * StrategyContext：上下文角色，用来操作策略模式的上下文环境，起到承上启下的作用，屏蔽高层模块对策略、算法的访问
    * Strategy:抽象策略角色，策略，算法的抽象，通常为接口
    * ConcreteStrategy:具体的策略实现
    */
    public BindingCommand strategyCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            StrategyContext strategyContext;
            strategyContext = new StrategyContext(new WeakRivalStrategy());
            strategyContext.fighting();

            strategyContext = new StrategyContext(new CommonRivalStrategy());
            strategyContext.fighting();

            strategyContext = new StrategyContext(new StrongRivalStrategy());
            strategyContext.fighting();

        }
    });


    public BindingCommand observerCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

            SubscriptionSubject subscriptionSubject = new SubscriptionSubject();
            WeiXinUser xinUser1 = new WeiXinUser("君陌");
            WeiXinUser xinUser2 = new WeiXinUser("宁缺");
            WeiXinUser xinUser3 = new WeiXinUser("林雾");
            subscriptionSubject.attach(xinUser1);
            subscriptionSubject.attach(xinUser2);
            subscriptionSubject.attach(xinUser3);
            subscriptionSubject.notify("夫子登天了");
        }
    });
}
