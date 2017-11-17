package com.example.adityasuwandi.bankhutan.fragments;


import android.app.DownloadManager;
import android.net.http.RequestQueue;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.Response;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.adityasuwandi.bankhutan.R;
import com.google.firebase.database.ValueEventListener;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogTree extends android.app.Fragment {
    private TextView mTreeName ;
    private TextView mTreeDesc ;
    private Button investButton;
    private String access_token="9ORTlBhqtnufgaA6IVs11xQCQ9t4",url="https://blinke-stage.apigee.net/imx/sms",message = "Congratulation! You just made an investation on Sengon Tree"
            ,msisdn="6285877798708";
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("IDPohon/0001/Deskripsi");

    public CatalogTree(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.catalog_tree, container, false);
        mTreeName = (TextView) view.findViewById(R.id.treename);
        mTreeDesc = (TextView) view.findViewById(R.id.treedesc);
        investButton = (Button) view.findViewById(R.id.invest_button);

        mConditionRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mTreeDesc.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        // Inflate the layout for this fragment
        return view;

    }

    @Override
    public void onActivityCreated(Bundle SavedInstanceState){
        super.onActivityCreated(SavedInstanceState);
        investButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                com.android.volley.RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                JSONObject jsonObject = new JSONObject();
                try {
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new com.android.volley.Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            Toast.makeText(getActivity(),"IT WORKS I DUNNO WHY", Toast.LENGTH_LONG);
                        }
                    }, new com.android.volley.Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity(),"HOLLY FUCKING SHIT", Toast.LENGTH_LONG);
                        }
                    }) {
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            final Map<String, String> headers = new HashMap<>();
                            headers.put("Content-Type","application/json");
                            headers.put("Authorization", "Bearer "+access_token);
                            return headers;
                        }
                    };
                    jsonObject.put("message", message);
                    jsonObject.put("msisdn", msisdn);
                    requestQueue.add(jsonObjectRequest);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

//    public class AsyncData extends AsyncTask<String, Void, String>{
//
//        @Override
//        protected String doInBackground(String... params){
//            HttpParams httpParams = new BasicHttpParams();
//            HttpConnectionParams.setConnectionTimeout(httpParams,5000);
//            HttpConnectionParams.setSoTimeout(httpParams,5000);
//
//            HttpClient httpClient = new DefaultHttpClient(httpParams);
//            HttpPost httpPost = new HttpPost(params[0]);
//            String jsonresult = "";
//
//            try{
//
//                List<NameValuePair> nameValuePairs = new ArrayList<>(2);
//                //List<NameValuePair> headers = new ArrayList<>(2);
//                nameValuePairs.add(new BasicNameValuePair("message",params[2]));
//                nameValuePairs.add(new BasicNameValuePair("msisdn",params[3]));
//                //headers.add(new BasicNameValuePair("Content-Type","application/json"));
//                //headers.add(new BasicNameValuePair("Authorization","Bearer "+params[1]));
//                httpPost.setHeader("Content-Type","application/json");
//                httpPost.setHeader("Authorization","Bearer "+params[1]);
//                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
//
//                HttpResponse httpResponse = httpClient.execute(httpPost);
//                jsonresult = inputStreamToString(httpResponse.getEntity().getContent()).toString();
//
//            }
//            catch (ClientProtocolException e) {
//                e.printStackTrace();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            //System.out.println(jsonresult);
//            return jsonresult;
//        }
//
//        @Override
//        public void onPreExecute(){super.onPreExecute();}
//
//        @Override
//        public void onPostExecute(String result){
//            super.onPostExecute(result);
//            System.out.println("Resulted Value: " + result);
//            boolean jsonResult = returnParsedJsonObject(result);
//            if(jsonResult){
//                Toast.makeText(getActivity(),"Investation Success",Toast.LENGTH_LONG);
//            }
//        }
//
//        private StringBuilder inputStreamToString(InputStream is) {
//            String rLine;
//            StringBuilder answer = new StringBuilder();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            try {
//                while ((rLine = br.readLine()) != null) {
//                    answer.append(rLine);
//                }
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            return answer;
//        }
//    }
//
//    private boolean returnParsedJsonObject(String result) {
//
//        JSONObject resultObject;
//        boolean returnedResult = false;
//        try {
//            resultObject = new JSONObject(result);
//            returnedResult = resultObject.getBoolean("success");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return returnedResult;
//    }

}
