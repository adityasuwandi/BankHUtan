package com.example.adityasuwandi.bankhutan.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.example.adityasuwandi.bankhutan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {

    public static Fragment newInstance() {
        Fragment frag = new ArticleFragment();
        return frag;
    }

//    private List<ArticleData> articleDatas;
//    private ArticleFragmentAdapter articleFragmentAdapter;
//    private Random random;
//    private RecyclerView recyclerView;
//    final private int INF = 9999;
//
//    private String article_title[]={"Perpustakaan Arsip Daerah","Perpustakaan Kota",
//            "Perpustakaan Provinsi","Perpustakaan Nasional","Perpustakaan Universitas"};
//
//    private String article[]={"Jakarta","Surabaya","Yogyakarta","Bandung","Semarang","Serang"};
//
    public ArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_article, container, false);

    }


//    @Override
//    public void onActivityCreated(Bundle SavedInstanceState) {
//        super.onActivityCreated(SavedInstanceState);
//
//
//        articleDatas = new ArrayList<>();
//        random = new Random();
//
//        recyclerView = getView().findViewById(R.id.recycler_view_article);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        articleFragmentAdapter = new ArticleFragmentAdapter(recyclerView,articleDatas,getActivity());
//        recyclerView.setAdapter(articleFragmentAdapter);
//
//
//        for (int i = 0; i < 10; i++) {
//            ArticleData articleData= new ArticleData();
//            articleData.setTitle(articleTitleGenerator());
//            articleData.setArticle(articleGenerator());
//            articleDatas.add(articleData);
//        }
//
//        articleFragmentAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore() {
//                if (articleDatas.size() <= INF) { //limitation
//                    articleDatas.add(null);
//                    articleFragmentAdapter.notifyItemInserted(articleDatas.size() - 1);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            articleDatas.remove(articleDatas.size() - 1);
//                            articleFragmentAdapter.notifyItemRemoved(articleDatas.size());
//
//                            //Generating more data
//                            int index = articleDatas.size();
//                            int end = index + 10;
//                            for (int i = index; i < end; i++) {
//                                ArticleData articleData= new ArticleData();
//                                articleData.setTitle(articleTitleGenerator());
//                                articleData.setArticle(articleGenerator());
//                                articleDatas.add(articleData);
//                            }
//                            articleFragmentAdapter.notifyDataSetChanged();
//                            articleFragmentAdapter.setLoaded();
//                        }
//                    }, 5000);
//                } else {
//                    Toast.makeText(getActivity(), "Loading data completed", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//
////changed
//
//
//    }
//
//    private String articleTitleGenerator(){
//
//        int randomnumber = random.nextInt(5);
//
//        return article_title[randomnumber];
//    }
//
//    private String articleGenerator(){
//
//        int randomnumber = random.nextInt(6);
//
//        return article[randomnumber];
//    }
}
