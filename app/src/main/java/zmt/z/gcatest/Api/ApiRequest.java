package zmt.z.gcatest.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import zmt.z.gcatest.model.Currencies;

public interface ApiRequest {

    @GET("latest")
    Call<Currencies> getCurrencies();

}
