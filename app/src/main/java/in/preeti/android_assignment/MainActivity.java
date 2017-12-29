package in.preeti.android_assignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mrecyclerview;
    private RecyclerView.LayoutManager mlayoutmanager;
    private RequestQueue mrequestqueue;
    private ArrayList<JsonData> marraylist;
    private CustomAdapter mcustomadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getJsonData();
    }



    private void init() {
        mrecyclerview= (RecyclerView) findViewById(R.id.recyclerview);
        mlayoutmanager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        mrecyclerview.setLayoutManager(mlayoutmanager);
        mrecyclerview.setHasFixedSize(true);
        mrequestqueue= Volley.newRequestQueue(MainActivity.this);

    }

    private void getJsonData() {

        String url="http://androidblog.esy.es/jsonData.php";

        marraylist=new ArrayList<>();

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length();i++){

                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        JsonData jsondata=new JsonData();
                        jsondata.setMid(jsonObject.getString("id"));
                        jsondata.setMname(jsonObject.getString("name"));
                        jsondata.setMphonenumber(jsonObject.getString("phone_number"));
                        jsondata.setMsubject(jsonObject.getString("subject"));
                        marraylist.add(jsondata);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    mcustomadapter=new CustomAdapter(MainActivity.this,marraylist);
                    mrecyclerview.setAdapter(mcustomadapter);

                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                error.printStackTrace();

            }
        });

        mrequestqueue.add(jsonArrayRequest);


    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        super.onBackPressed();
    }
}



