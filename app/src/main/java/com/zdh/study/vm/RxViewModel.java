package com.zdh.study.vm;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.zdh.study.ui.rxjava.Swordsman;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;
import me.goldze.mvvmhabit.base.BaseViewModel;

public class RxViewModel extends BaseViewModel {
    public static final String host = "http://www.baidu.com";

    public RxViewModel(@NonNull Application application) {
        super(application);
    }


    public void setOperator() {

    }

    /*
    * @author mousse
    * create time 2023/3/22 10:04
    * description:
    * subscribeOn:指定Observable在那个线程运行，耗时操作的话在新开一个子线程运行
    * observableOn:用来指定observer所运行的线程-一般会指定在主线程，这样就可以刷新UI
    * subscribeOn(Schedulers.newThread()):表示observable运行在新开的线程
    * observeOn(AndroidSchedulers.mainThread()):表示observable运行在主线程
    */
    private void subscribeOn(){

        Observable<Integer> obs = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "subscribe: " + Thread.currentThread().getName());
                emitter.onNext(1);
                emitter.onComplete();
            }
        });
        obs.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + Thread.currentThread().getName());
            }
        });
    }

    private void doOperator() {
        //doOnEach:为observable注册一个回调：Observable每发射一项数据，就会调用一次回调函数，包括onNext onError on complete
        //doOnNext:只有执行onNext的时候会被调用
        //doOnSubscribe:当观察者订阅Observable会被调用
        //doOnError:当Observable异常终止时被调用
        Observable.just(1, 2)
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "accept: " + integer);
                    }
                }).subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "accept: onNext" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "accept: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                        Log.e(TAG, "accept: onComplete");
                    }
                });
    }

    private void delay() {
        Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                long currentTime = System.currentTimeMillis() / 1000;
                emitter.onNext(currentTime);
            }
        }).delay(2, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.e(TAG, "accept: " + (System.currentTimeMillis() / 1000 - aLong));
            }
        });

    }

    private void combineLatest() {
        //组合操作符
        Observable<Integer> ob1 = Observable.just(1, 2, 3);
        Observable<String> ob2 = Observable.just("A", "B", "C");
        Observable.combineLatest(ob1, ob2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept: " + s);
            }
        });

    }

    @SuppressLint("CheckResult")
    private void concat() {
        //将多个observable发射的数据按照顺序发射，前一个没有完成，不会发送后一个
        Observable<Integer> ob1 = Observable.just(3, 4, 5).subscribeOn(Schedulers.io());
        Observable<Integer> ob2 = Observable.just(5, 8, 0);
        Observable.concat(ob2, ob1).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + integer);
            }
        });

    }

    @SuppressLint("CheckResult")
    private void throttleFirst() {
        //定期发送这个时间段的，observable发射的第一个数据
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; i < 10; i++) {
                    emitter.onNext(i);
                    Thread.sleep(100);
                }
            }
        }).throttleFirst(300, TimeUnit.MICROSECONDS).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + integer);
            }
        });

    }

    private void ignoreElements() {
        //ignoreElements 忽略所有Observable产生的结果 把onComplete和onError通知给订阅者
        Observable.just(1, 2, 3, 4).ignoreElements().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: ");
            }

            @Override
            public void onComplete() {

                Log.e(TAG, "onComplete: ");
            }

            @Override
            public void onError(Throwable e) {

                Log.e(TAG, "onError: ");
            }
        });
    }


    @SuppressLint("CheckResult")
    private void take() {
        //take:取前2的数据
        Observable.just(1, 2, 3, 4, 4, 5, 6, 2, 5, 6).distinct().take(2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + integer);
            }
        });

    }

    @SuppressLint("CheckResult")
    private void skip() {
        //skip:跳过角标2前面的数据
        Observable.just(1, 2, 3, 4, 4, 5, 6, 2, 5, 6).distinct().skip(2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + integer);
            }
        });
    }

    @SuppressLint("CheckResult")
    private void distinct() {
        //distinct去重
        Observable.just(1, 2, 3, 4, 4, 5, 6, 2, 5, 6).distinct().subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + integer);
            }
        });
    }

    @SuppressLint("CheckResult")
    private void elementAt() {
        //elementAt返回指定位置的数据
        Observable.just(1, 2, 3, 4, 5, 6).elementAt(2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + integer);
            }
        });
    }

    @SuppressLint("CheckResult")
    private void buffer() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .buffer(3)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        for (Integer i : integers) {
                            Log.e(TAG, "accept() returned: " + i);
                        }
                        Log.e(TAG, "accept: ------------------------------------");
                    }
                });
    }


    @SuppressLint("CheckResult")
    private void filter() {
        //filter操作符：按照条件过滤： integer > 3
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer > 3;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + integer);
            }
        });

    }

    @SuppressLint("CheckResult")
    private void interval() {
        //interval操作符：创建一个按固定时间间隔发射整数序列的Observable 相当于定时器
        Observable.interval(3, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.e("TAG", "accept: " + aLong.intValue());
            }
        });
    }

    @SuppressLint("CheckResult")
    private void range() {
        //range操作符，创建发射指定范围的整数序列的Observable，可以拿来替代for循环，
        Observable.range(0, 5).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + integer.intValue());
            }
        });
    }

    @SuppressLint("CheckResult")
    private void repeat() {
        //创建一个n次重复的发射特定数据的Observable
        Observable.range(0, 3).repeat(2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: " + integer.intValue());
            }
        });
    }

    @SuppressLint("CheckResult")
    private void groupBy() {
        //groupBy操作符：根据SS  A S分组
        Swordsman s1 = new Swordsman("韦一笑", "SS");
        Swordsman s2 = new Swordsman("周芷若", "A");
        Swordsman s3 = new Swordsman("赵敏", "S");
        Swordsman s4 = new Swordsman("宋青书", "S");
        Swordsman s5 = new Swordsman("张无忌", "SS");
        Swordsman s6 = new Swordsman("陈友谅", "A");
        Swordsman s7 = new Swordsman("成昆", "A");
        Swordsman s8 = new Swordsman("张三丰", "SS");
        Observable<GroupedObservable<String, Swordsman>> groupedObservableObservable = Observable.just(s1, s2, s3, s4, s5, s6, s7, s8)
                .groupBy(new Function<Swordsman, String>() {
                    @Override
                    public String apply(Swordsman swordsman) throws Exception {
                        return swordsman.getLev();
                    }
                });
        Observable.concat(groupedObservableObservable).subscribe(new Consumer<Swordsman>() {
            @SuppressLint("CheckResult")
            @Override
            public void accept(Swordsman swordsman) throws Exception {
                Log.e(TAG, "accept: groupBy:" + swordsman.getName() + "," + swordsman.getLev());
            }
        });
    }

    @SuppressLint("CheckResult")
    public void map() {
        List<String> mList = new ArrayList<>();
        mList.add("test1");
        mList.add("test2");
        mList.add("test3");
        mList.add("test4");
        Observable.fromIterable(mList).flatMap(new Function<String, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(String s) throws Exception {
                return Observable.just(host + s);
            }
        }).cast(String.class).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept:flatMap: " + s);
            }
        });
    }
}
