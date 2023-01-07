package zmt.z.gcatest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zmt.z.gcatest.Api.ApiRequest;
import zmt.z.gcatest.Api.ApiUtil;
import zmt.z.gcatest.model.Currencies;
import zmt.z.gcatest.model.Rates;

public class MainActivity extends AppCompatActivity {

    ApiRequest apiRequest;
    DatabaseHandler databaseHandler;
    ArrayList<Rates> arrayList;
    RecyclerView recyclerview;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);

        databaseHandler=new DatabaseHandler(this);
        Boolean Permission = (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        if (!Permission) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 5);
        }
        Boolean hasPermission = (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        if (!hasPermission) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
        }

        apiRequest= ApiUtil.getApiRequest();
        apiRequest.getCurrencies().enqueue(new Callback<Currencies>() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onResponse(Call<Currencies> call, Response<Currencies> response) {
                if(response.isSuccessful()){
                    arrayList=new ArrayList<>();
                    arrayList.add(response.body().getRates());
                    databaseHandler.addData(arrayList);
                    adapter=new Adapter(MainActivity.this,arrayList);
                    recyclerview.setAdapter(adapter);
                    //Toast.makeText(MainActivity.this, response.body().getInfo(), Toast.LENGTH_SHORT).show();
                }else
                Toast.makeText(MainActivity.this,response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Currencies> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Offline!", Toast.LENGTH_SHORT).show();
            }
        });
        //kasmdfa;lk
    }
}
