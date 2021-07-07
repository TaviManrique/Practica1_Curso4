package com.manriquetavi.miscontactos;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_USER_MEDIA)
    Call<ContactoResponse> getRecentMedia();
}
