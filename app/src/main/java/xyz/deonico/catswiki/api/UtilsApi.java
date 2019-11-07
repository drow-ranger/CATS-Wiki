package xyz.deonico.catswiki.api;

public class UtilsApi {
    private static final String BASE_URL_API = "http://10.10.101.30:3000/api/";

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
