package xyz.deonico.catswiki.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import xyz.deonico.catswiki.model.ResponseBreed;
import xyz.deonico.catswiki.model.ResponseBreedSpecific;

public interface BaseApiService {
    @GET("breed")
    Observable<List<ResponseBreed>> requestResponseList();

    @GET("breed/{id}")
    Call<ResponseBreedSpecific> requestResponseId(@Path("id") int id);
}
