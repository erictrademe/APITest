package com.example.ericzhong.apitest;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

/**
 * Created by Eric Zhong on 2016/11/20.
 */

@Module
public class Injector {

//    @Provides
//    public OkHttpClient provideLoggingCapableHttpClient() {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//
//        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
//
//        return new OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .build();
//    }


    @Provides
    public static Retrofit provideRetrofit (String baseUrl)
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();

        return new Retrofit.Builder()
                .baseUrl( baseUrl )
                .client(okHttpClient)
                .addConverterFactory( GsonConverterFactory.create() )
                .build();
    }
    @Provides
    public static OkHttpClient provideOkHttpClient ()
    {
        return new OkHttpClient.Builder()
                .addInterceptor( provideHttpLoggingInterceptor() )
                .build();
    }
    @Provides
    public static HttpLoggingInterceptor provideHttpLoggingInterceptor ()
    {
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor( new HttpLoggingInterceptor.Logger()
                {
                    @Override
                    public void log (String message)
                    {
                        Timber.d( message );
                    }
                } );
        httpLoggingInterceptor.setLevel( BuildConfig.DEBUG ? BODY : NONE );
        return httpLoggingInterceptor;
    }
    @Provides
    public static APIServices provideCityService ()
    {
        return provideRetrofit(Constants.BASE_URL ).create( APIServices.class );
    }
}
