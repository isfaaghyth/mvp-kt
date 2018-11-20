package isfaaghyth.app.mvpkt.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import isfaaghyth.app.mvpkt.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class Network {

    private val REQUEST_TIME_OUT: Long = 30

    fun builder(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        val gsonBuilder = GsonBuilder()
            //convert a conventional json entity names into java object
            //example: isfa_ganteng -> isfaGanteng
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.GITHUB_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

}