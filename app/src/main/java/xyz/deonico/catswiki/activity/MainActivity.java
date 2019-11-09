package xyz.deonico.catswiki.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xyz.deonico.catswiki.R;
import xyz.deonico.catswiki.adapter.BreedAdapter;
import xyz.deonico.catswiki.api.BaseApiService;
import xyz.deonico.catswiki.api.UtilsApi;
import xyz.deonico.catswiki.model.ResponseBreed;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;
    @BindView(R.id.rvRepos)
    RecyclerView rvRepos;
    @BindView(R.id.ivProfile)
    ImageView ivProfile;

    BaseApiService mApiService;
    BreedAdapter mRepoAdapter;

    List<ResponseBreed> repoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        mApiService = UtilsApi.getAPIService();

        mRepoAdapter = new BreedAdapter(this, repoList, null);
        rvRepos.setLayoutManager(new LinearLayoutManager(this));
        rvRepos.setItemAnimator(new DefaultItemAnimator());
        rvRepos.setHasFixedSize(true);
        rvRepos.setAdapter(mRepoAdapter);

        requestBreedList();
    }

    private void requestBreedList() {
        pbLoading.setVisibility(View.VISIBLE);

        mApiService.requestResponseList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ResponseBreed>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ResponseBreed> responseRepos) {
                        for (int i = 0; i < responseRepos.size(); i++) {
                            int id = responseRepos.get(i).getId();
                            String name = responseRepos.get(i).getName();
                            String description = responseRepos.get(i).getDescription();
                            String createdAt = responseRepos.get(i).getCreatedAt();
                            String photo_main = responseRepos.get(i).getPhotoMain();

                            repoList.add(new ResponseBreed(id, name, description, createdAt, photo_main));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        pbLoading.setVisibility(View.GONE);
                        mRepoAdapter = new BreedAdapter(MainActivity.this, repoList, null);
                        rvRepos.setAdapter(mRepoAdapter);

                        mRepoAdapter.setOnClickListener(new BreedAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                startActivity(new Intent(MainActivity.this, DetailActivity.class).putExtra("id", repoList.get(position).getId()).putExtra("name", repoList.get(position).getName()));
                            }
                        });
                        mRepoAdapter.notifyDataSetChanged();
                    }
                });
    }
}
