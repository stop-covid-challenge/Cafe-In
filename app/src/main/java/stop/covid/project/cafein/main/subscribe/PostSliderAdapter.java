package stop.covid.project.cafein.main.subscribe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import stop.covid.project.cafein.R;

public class PostSliderAdapter extends RecyclerView.Adapter<PostSliderAdapter.MyViewHolder> {
    private Context context;
    private String[] sliderImage;

    public PostSliderAdapter(Context context, String[] sliderImage){
        this.context = context;
        this.sliderImage = sliderImage;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_slider, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindSliderImage(sliderImage[position]);
    }

    @Override
    public int getItemCount() {
        return sliderImage.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;

        public MyViewHolder(View itemView){
            super(itemView);
            mImageView = itemView.findViewById(R.id.postSlider);
        }

        public void bindSliderImage(String imageURL){
            Glide.with(context)
                    .load(imageURL)
                    .into(mImageView);
        }
    }
}
