package xyz.deonico.catswiki.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.deonico.catswiki.R;
import xyz.deonico.catswiki.api.BaseApiService;
import xyz.deonico.catswiki.api.UtilsApi;
import xyz.deonico.catswiki.model.ResponseBreedSpecific;

public class DetailActivity extends AppCompatActivity {

    BaseApiService mApiService;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.linearLayoutTop)
    LinearLayout linearLayoutTop;
    @BindView(R.id.ivProfile)
    ImageView ivProfile;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.rbIntelligence)
    RatingBar rbIntelligence;
    @BindView(R.id.rbAdaptability)
    RatingBar rbAdaptability;
    @BindView(R.id.rbAffectionLevel)
    RatingBar rbAffectionLevel;
    @BindView(R.id.rbChildFriendly)
    RatingBar rbChildFriendly;

    @BindView(R.id.tvIntroduction)
    TextView tvIntroduction;
    @BindView(R.id.tvDescription)
    TextView tvDescription;
    @BindView(R.id.tvTemperament)
    TextView tvTemperament;
    @BindView(R.id.tvCharacteristic)
    TextView tvCharacteristic;
    @BindView(R.id.tvOrigin)
    TextView tvOrigin;
    @BindView(R.id.tvLiveSpan)
    TextView tvLiveSpan;
    @BindView(R.id.tvWeight)
    TextView tvWeight;
    @BindView(R.id.tvWikipedia)
    TextView tvWikipedia;
    @BindView(R.id.tvCfa)
    TextView tvCfa;
    @BindView(R.id.tvVetstreet)
    TextView tvVetstreet;
    @BindView(R.id.tvVcahospitals)
    TextView tvVcahospitals;
    @BindView(R.id.ivImageCat)
    ImageView ivImageCat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        int id = getIntent().getIntExtra("id", 0);
        String name = getIntent().getStringExtra("name");
        setTitle(name);

        mApiService = UtilsApi.getAPIService();

        requestBreedDetail(id);
    }

    private void requestBreedDetail(int id) {
        mApiService.requestResponseId(id).enqueue(new Callback<ResponseBreedSpecific>() {
                @Override
                public void onResponse(Call<ResponseBreedSpecific> call, Response<ResponseBreedSpecific> response) {
                    if (response.isSuccessful()){

                        String base_image_url = "https://catapi.deonico.xyz/img/breed/";

                        String photo_main = response.body().getBreed().getPhotoMain();
                        String photo_1 = response.body().getBreed().getPhoto1();
                        String photo_2 = response.body().getBreed().getPhoto2();
                        String name = response.body().getBreed().getName();
                        String introduction = response.body().getBreed().getIntroduction();
                        String description = response.body().getBreed().getDescription();
                        String temperament = response.body().getBreed().getTemperament();
                        String characteristic = response.body().getBreed().getCharacteristic();
                        String origin = response.body().getBreed().getOrigin();
                        String live_span = response.body().getBreed().getLifeSpan();
                        String weight = response.body().getBreed().getWeight();
                        String wikipedia_url = response.body().getBreed().getWikipediaUrl();
                        String cfa_url = response.body().getBreed().getCfaUrl();
                        String vetstreet_url = response.body().getBreed().getVetstreetUrl();
                        String vcahospitals_url = response.body().getBreed().getVcahospitalsUrl();
                        int intelligence = response.body().getBreed().getIntelligence();
                        int adaptability = response.body().getBreed().getAdaptability();
                        int affectionLevel = response.body().getBreed().getAffectionLevel();
                        int childFriendly = response.body().getBreed().getChildFriendly();

                        Picasso.get().
                                load(base_image_url+photo_1).
                                error(R.drawable.gradientbackground).
                                into(new Target() {
                                    @Override
                                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                        linearLayoutTop.setBackground(new BitmapDrawable(bitmap));
                                    }

                                    @Override
                                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                                        linearLayoutTop.setBackground(new BitmapDrawable(String.valueOf(R.drawable.gradientbackground)));
                                        tvName.setText(name);
                                    }

                                    @Override
                                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                                    }
                                });

                        Picasso.get().
                                load(base_image_url+photo_main).
                                error(R.drawable.catnotfound).
                                into(ivProfile);

                        Picasso.get().
                                load(base_image_url+photo_2).
                                error(R.drawable.catnotfound).
                                into(new Target() {
                                    @Override
                                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                        ivImageCat.setImageDrawable(new BitmapDrawable(bitmap));
                                    }

                                    @Override
                                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                                        ivImageCat.setVisibility(View.GONE);
                                    }

                                    @Override
                                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                                    }
                                });

                        rbIntelligence.setRating(intelligence);
                        rbAdaptability.setRating(adaptability);
                        rbAffectionLevel.setRating(affectionLevel);
                        rbChildFriendly.setRating(childFriendly);

                        tvIntroduction.setText(introduction);
                        tvDescription.setText(description);
                        tvTemperament.setText(temperament);
                        tvCharacteristic.setText(characteristic);
                        tvOrigin.setText(origin);
                        tvLiveSpan.setText(live_span + " years");
                        tvWeight.setText(weight + " Kg");

                        tvWikipedia.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openURL(wikipedia_url);
                            }
                        });

                        tvCfa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openURL(cfa_url);
                            }
                        });

                        tvVetstreet.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openURL(vetstreet_url);
                            }
                        });

                        tvVcahospitals.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openURL(vcahospitals_url);
                            }
                        });

                    } else {
                        Toast.makeText(DetailActivity.this, "Gagal Mengambil Data Detail", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBreedSpecific> call, Throwable t) {

                }
            });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 0) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void openURL(String url) {
        if (url == ""){
            Toast.makeText(this, "Sorry.. Link is not available", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)));
        }
    }
}
