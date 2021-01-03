package com.mehmet.hr190018_mehmet_acisu_final.network;
import com.mehmet.hr190018_mehmet_acisu_final.model.FutbolcuModel;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {


    @GET("EnIyiFutbolcular.json")
    Observable<List<FutbolcuModel>> futbolculariGetir();
}
