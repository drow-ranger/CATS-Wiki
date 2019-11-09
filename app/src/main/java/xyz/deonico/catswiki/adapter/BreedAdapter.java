package xyz.deonico.catswiki.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.deonico.catswiki.R;
import xyz.deonico.catswiki.model.ResponseBreed;

public class BreedAdapter extends
        RecyclerView.Adapter<BreedAdapter.ViewHolder> {

    private static final String TAG = ResponseBreed.class.getSimpleName();

    private OnItemClickListener mListener;
    private Context context;
    private List<ResponseBreed> list;
    private AdapterCallback mAdapterCallback;

    public BreedAdapter(Context context, List<ResponseBreed> list,
                       AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.mAdapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo,
                parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResponseBreed item = list.get(position);

        String base_image_url = "http://10.10.101.30:3000/img/breed/";
        DateTime dateTime  = DateTime.parse(item.getCreatedAt(), DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));

        int id = item.getId();
        String name = item.getName();
        String description = item.getDescription();
        String createdAt = dateTime.toString("dd/MMM/yy hh:mm:ss aa");
        String photo_main = item.getPhotoMain();

        Picasso.get().
                load(base_image_url+photo_main).
                error(R.drawable.catnotfound).
                into(holder.ivPhoto);
        holder.tvName.setText(name);
        holder.tvDescription.setText(description);
        holder.tvCreatedAt.setText(createdAt);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        int size = this.list.size();
        this.list.clear();
        notifyItemRangeRemoved(0, size);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvDescription)
        TextView tvDescription;
        @BindView(R.id.tvCreatedAt)
        TextView tvCreatedAt;
        @BindView(R.id.ivPhoto)
        ImageView ivPhoto;

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            ivPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public interface AdapterCallback {
        void onRowClicked(int position);
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
