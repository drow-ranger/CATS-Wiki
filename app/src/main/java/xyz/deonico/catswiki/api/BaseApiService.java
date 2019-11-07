package xyz.deonico.catswiki.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import xyz.deonico.catswiki.model.ResponseBreed;

public interface BaseApiService {
    @GET("breed")
    Observable<List<ResponseBreed>> requestResponse();
}
