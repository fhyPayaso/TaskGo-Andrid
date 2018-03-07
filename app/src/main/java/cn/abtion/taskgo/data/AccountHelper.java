package cn.abtion.taskgo.data;

import cn.abtion.taskgo.base.data.DataCallBack;
import cn.abtion.taskgo.mvp.model.account.LoginRequestModel;
import cn.abtion.taskgo.network.ResponseCallBack;
import cn.abtion.taskgo.network.response.ApiResponse;
import cn.abtion.taskgo.network.retrofit.RetrofitFactory;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @author fhyPayaso
 * @since 2018/1/21 on 上午2:16
 * fhyPayaso@qq.com
 */
public class AccountHelper {


    /**
     * 登录请求
     */
    @SuppressWarnings("unchecked")
    public static void login(final LoginRequestModel request, final DataCallBack.SuccessCallback callback) {


        RetrofitFactory.getRetrofitService().login(request).enqueue(new ResponseCallBack<ApiResponse>() {
            @Override
            public void onDataResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                callback.onDataLoaded(null);
            }

            @Override
            public void onDataFailure(Call<ApiResponse> call, Throwable t) {

            }

            @Override
            public void dismissDialog() {

            }
        });


//        RetrofitFactory
//                .getRetrofitService()
//                .rxLogin(request)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new BaseObserver() {
//                    @Override
//                    public void onDataSuccess(ApiResponse response) {
//                        callback.onDataLoaded(null);
//                    }
//                });

    }
}
