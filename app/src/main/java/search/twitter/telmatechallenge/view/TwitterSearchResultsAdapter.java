package search.twitter.telmatechallenge.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import search.twitter.telmatechallenge.R;
import search.twitter.telmatechallenge.model.data.TweetsSearchQuery;

public class TwitterSearchResultsAdapter extends RecyclerView.Adapter<TwitterSearchResultsAdapter.SearchResultViewHolder> {
    Context context;
    ArrayList<TweetsSearchQuery> tweetsSearchQueries = new ArrayList<>();

    public TwitterSearchResultsAdapter(Context context, ArrayList<TweetsSearchQuery> tweetsSearchQueries) {
        this.context = context;
        this.tweetsSearchQueries = tweetsSearchQueries;
        //   preFetchImages();
    }

    @Override
    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_item, parent, false);
        return new SearchResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchResultViewHolder holder, int position) {
        TweetsSearchQuery tweets = tweetsSearchQueries.get(position);
        String imageUrl = "";
        if (!TextUtils.isEmpty(tweets.getUser().getProfileImageUrlHttps())) {
            imageUrl = tweets.getUser().getProfileImageUrlHttps();
        } else if (!TextUtils.isEmpty(tweets.getUser().getProfileImageUrl())) {
            imageUrl = tweets.getUser().getProfileImageUrl();
        } else if (!TextUtils.isEmpty(tweets.getUser().getProfileBackgroundImageUrlHttps())) {
            imageUrl = tweets.getUser().getProfileBackgroundImageUrlHttps();
        } else if (!TextUtils.isEmpty(tweets.getUser().getProfileBackgroundImageUrl())) {
            imageUrl = tweets.getUser().getProfileBackgroundImageUrl();
        }
        holder.titleTxt.setText(tweets.getUser().getName());
        holder.descriptionTxt.setText(tweets.getUser().getDescription());
        holder.urlTxt.setText(Long.toString(tweets.getRetweetCount()));
        holder.idTxt.setText(tweets.getUser().getScreenName());
        holder.ownerLoginTxt.setText(tweets.getUser().getTimeZone());
        holder.nameTxt.setText(tweets.getText());
        holder.languageTxt.setText(tweets.getUser().getLang());

        Picasso.with(context).load(tweets.getUser().getProfileImageUrl()).networkPolicy(NetworkPolicy.OFFLINE).into(holder.avatarView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });
        holder.updatedAtTxt.setText(tweets.getUser().getScreenName());
        holder.createdAtTxt.setText(tweets.getUser().getCreatedAt());
        holder.pushedAtTxt.setText(tweets.getUser().getLocation());
    }

    @Override
    public int getItemCount() {
        return tweetsSearchQueries.size();
    }

    public class SearchResultViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.title_txt)
        TextView titleTxt;
        @InjectView(R.id.description_txt)
        TextView descriptionTxt;
        @InjectView(R.id.url_txt)
        TextView urlTxt;
        @InjectView(R.id.header_view)
        LinearLayout headerLayout;
        // body view
        TextView idTxt;
        TextView nameTxt;
        TextView ownerLoginTxt;
        TextView languageTxt;
        ImageView avatarView;
        LinearLayout bodyView;
        // footer view
        TextView updatedAtTxt;
        TextView createdAtTxt;
        TextView pushedAtTxt;

        public SearchResultViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            titleTxt = ButterKnife.findById(itemView, R.id.title_txt);
            descriptionTxt = ButterKnife.findById(itemView, R.id.description_txt);
            urlTxt = ButterKnife.findById(itemView, R.id.url_txt);
            headerLayout = ButterKnife.findById(itemView, R.id.header_view);

            idTxt = ButterKnife.findById(itemView, R.id.id_txt);
            nameTxt = ButterKnife.findById(itemView, R.id.name_txt);

            ownerLoginTxt = ButterKnife.findById(itemView, R.id.owner_login_txt);
            languageTxt = ButterKnife.findById(itemView, R.id.language_txt);

            updatedAtTxt = ButterKnife.findById(itemView, R.id.updated_at_txt);
            createdAtTxt = ButterKnife.findById(itemView, R.id.created_at_txt);

            pushedAtTxt = ButterKnife.findById(itemView, R.id.pushed_at_txt);
            avatarView = ButterKnife.findById(itemView, R.id.avatar);
            bodyView = ButterKnife.findById(itemView, R.id.body_view);

        }

    }


}
