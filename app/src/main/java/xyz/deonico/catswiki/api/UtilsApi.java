package xyz.deonico.catswiki.api;

public class UtilsApi {
    private static final String BASE_URL_API = "https://catapi.deonico.xyz/api/";

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
