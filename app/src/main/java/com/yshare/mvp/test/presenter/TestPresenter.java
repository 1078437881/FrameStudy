package com.yshare.mvp.test.presenter;

import com.yshare.baselib.mvpbase.baselmpl.BasePresenterImpl;
import com.yshare.baselib.retroft.ExceptionHelper;
import com.yshare.model.Api;
import com.yshare.mvp.test.bean.StoriesBean;
import com.yshare.mvp.test.bean.TestBean;
import com.yshare.mvp.test.contact.TestContact;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/11.
 */

public class TestPresenter extends BasePresenterImpl<TestContact.view> implements TestContact.presenter{
    public TestPresenter(TestContact.view view) {
        super(view);
    }

    /**
     * 获取数据
     */
    @Override
    public void getData(){
        Api.getInstance().test()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>(){

                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        addDisposable(disposable);
                        view.showLadingDialog("");
                    }
                })
                .map(new Function<TestBean, List<StoriesBean>>() {
                    @Override
                    public List<StoriesBean> apply(@NonNull TestBean testBean) throws Exception {
                        return testBean.getStories();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<StoriesBean>>() {
                    @Override
                    public void accept(@NonNull List<StoriesBean> storiesBeans) throws Exception {
                        view.dismissLoadingDialog();
                        view.setData(storiesBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.dismissLoadingDialog();
                        ExceptionHelper.handleExcepiton(throwable);
                    }
                });
    }
}
