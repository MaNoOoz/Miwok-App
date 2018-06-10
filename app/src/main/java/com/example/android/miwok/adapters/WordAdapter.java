package com.example.android.miwok.adapters;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.android.miwok.R;
import com.example.android.miwok.Word;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by MaNoOoz on 2/22/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;
    //// TODO: 6/10/2018 Delete Later
//    private Context context;

 //   private static final String LOG_TAG = WordAdapter.class.getSimpleName();

//    ArrayList<Word> listofwords = new ArrayList<>();
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param ListOfWords is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Activity context, ArrayList<Word> ListOfWords, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, ListOfWords);
        mColorResourceId = colorResourceId;
//        this.listofwords = ListOfWords;

    }

    /**
     * Provides a view for an WordAdapter (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param mView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override

    public View getView(int position, View mView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = mView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            miwokTextView.setText(Objects.requireNonNull(currentWord).getMiwokTranslation());
        }

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        if (currentWord != null) {
            defaultTextView.setText(currentWord.getDefaultTranslation());
        }

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord != null) {
            if(currentWord.hasImage()) {
                //// TODO: 6/10/2018 Delete Later
//                GlideApp
//                        .with(getContext())
////                        .load(listofwords.get(position))
//                        .load(currentWord.getImageResourceId()).thumbnail(0.5f)
//                        .override(500,400)
////                        .centerCrop()
//                        .placeholder(R.drawable.family_daughter)
//                        .into((imageView));

                // If an image is available, display the provided image based on the resource ID
                imageView.setImageResource(currentWord.getImageResourceId());

                // Make sure the view is visible
                imageView.setVisibility(View.VISIBLE);
            }
            else {
                // Otherwise hide the ImageView (set visibility to GONE)
                imageView.setVisibility(View.GONE);
            }
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}

