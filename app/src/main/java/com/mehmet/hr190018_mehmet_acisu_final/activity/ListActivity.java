package com.mehmet.hr190018_mehmet_acisu_final.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mehmet.hr190018_mehmet_acisu_final.model.FutbolcuModel;
import com.mehmet.hr190018_mehmet_acisu_final.R;
import com.mehmet.hr190018_mehmet_acisu_final.network.Service;
import com.mehmet.hr190018_mehmet_acisu_final.adaptor.FutbolcuAdaptor;
import com.mehmet.hr190018_mehmet_acisu_final.util.Constants;
import com.mehmet.hr190018_mehmet_acisu_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        FutbolculariGetir();
    }
    private  void  init()
    {
        FutbolculariGetir();
    }

    void  FutbolculariGetir()
    {

        new Service().getServiceApi().futbolculariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FutbolcuModel>>() {

                    List<FutbolcuModel> futbolcular=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<FutbolcuModel> futbolcuList) {
                        futbolcular=futbolcuList;
                    }

                    @Override
                    public void onError(Throwable e) {


                    }

                    @Override
                    public void onComplete()
                    {
                        if(futbolcular.size()>0) {

                            initRecycleView(futbolcular);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<FutbolcuModel> futbolcuList)
    {
        recyclerView =findViewById(R.id.rcvFutbolcular);
        FutbolcuAdaptor futbolcuAdaptor =new FutbolcuAdaptor(futbolcuList, getApplicationContext(), new FutbolcuAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                FutbolcuModel tiklananFutbolcu = futbolcuList.get(position);
                openNextActivity(tiklananFutbolcu);
                dialogGetir();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(futbolcuAdaptor);
    }

    private void openNextActivity(FutbolcuModel tiklananFutbolcu){
        Intent secondActivityIntent=new Intent(getApplicationContext(), FutbolcuDetayActivity.class);
        String tiklananFutbolcuString = ObjectUtil.futbolcuToJsonString(tiklananFutbolcu);
        secondActivityIntent.putExtra(Constants.TIKLANAN_FUTBOLCU_BASLIK,tiklananFutbolcuString);
        startActivity(secondActivityIntent);

    }
    private void dialogGetir(){
        ProgressDialog progressDialog = new ProgressDialog(ListActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.progress_dialog_message));
        progressDialog.show();
    }

    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
        builder.setTitle(getResources().getString(R.string.back_pressed_alert_title));
        builder.setMessage(getResources().getString(R.string.back_pressed_alert_message));
        builder.setCancelable(true);
        builder.setNegativeButton((getResources().getString(R.string.back_pressed_alert_negative_button)), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton((getResources().getString(R.string.back_pressed_alert_positive_button)), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
