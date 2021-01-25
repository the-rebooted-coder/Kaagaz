package com.aaxena.kaagaz;

import android.app.DownloadManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.pedromassango.doubleclick.DoubleClick;
import com.pedromassango.doubleclick.DoubleClickListener;

import static android.content.Context.DOWNLOAD_SERVICE;
import static android.content.Context.MODE_PRIVATE;
import static android.graphics.Color.RED;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab5 extends Fragment implements View.OnClickListener{
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    long queueid;
    DownloadManager dm;
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab3.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab5 newInstance(String param1, String param2) {
        Tab5 fragment = new Tab5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    View view5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view5 = inflater.inflate(R.layout.fragment_tab5, container, false);
        ImageView imageViewa = view5.findViewById(R.id.imageView);
        Glide.with(this).load(R.drawable.big1).centerCrop().into(imageViewa);
        Button upButton = view5.findViewById(R.id.geometry);
        LottieAnimationView loading_five;
        loading_five = view5.findViewById(R.id.setting_delay_five);
        upButton.setOnClickListener(new DoubleClick(new DoubleClickListener() {
            @Override
            public void onSingleClick(View view) {
                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                Toast.makeText(getContext(),"Tap twice to apply Island",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClick(View view) {

                dm = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(""));

                /*
                //FireNotif
                makeNotif();
                Button upButton = view5.findViewById(R.id.island);
                upButton.setVisibility(View.INVISIBLE);
                loading_five.setVisibility(View.VISIBLE);
                loading_five.playAnimation();
                Vibrator vibrator = (Vibrator)getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(28);
                SharedPreferences preferences = getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(TEXT,"geometry");
                editor.commit();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();

                 */
            }
        }));
        return view5;
    }

    @Override
    public void onClick(View v) {
    }
    private void makeNotif() {
        String ro_build = Build.MANUFACTURER;
        if ("xiaomi".equalsIgnoreCase(ro_build)) {
            shootNotif();
        } else if ("oppo".equalsIgnoreCase(ro_build)) {
            shootNotif();
        } else if ("vivo".equalsIgnoreCase(ro_build)) {
            shootNotif();
        } else if ("Letv".equalsIgnoreCase(ro_build)) {
            shootNotif();
        } else if ("Realme".equalsIgnoreCase(ro_build)) {
            shootNotifRealme();
        }
    }

    private void shootNotifRealme() {
        createMemoryChannel();
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.notification_mast_head);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.getContext(), "memory")
                .setSmallIcon(R.drawable.ic_half_moon)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.notification_mast_head_realme))
                .setContentTitle("Lock Kaagaz to memory")
                .setAutoCancel(true)
                .setColor(RED)
                .setColorized(true)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(myBitmap).bigLargeIcon(null))
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.getContext());
        notificationManager.notify(180, builder.build());
    }


    private void shootNotif() {
        createMemoryChannel();
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.notification_mast_head);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.getContext(), "memory")
                .setSmallIcon(R.drawable.ic_half_moon)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.notification_mast_head))
                .setContentTitle("Lock Kaagaz to memory")
                .setAutoCancel(true)
                .setColor(RED)
                .setColorized(true)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(myBitmap).bigLargeIcon(null))
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.getContext());
        notificationManager.notify(180, builder.build());
    }

    private void createMemoryChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Memory Info";
            String description = "Channel to give information about how to prevent app from getting killed";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("memory", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = this.getContext().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
