package com.aaxena.kaagaz;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.pedromassango.doubleclick.DoubleClick;
import com.pedromassango.doubleclick.DoubleClickListener;

import static android.content.Context.MODE_PRIVATE;
import static android.graphics.Color.RED;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab3 extends Fragment implements View.OnClickListener{
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab3() {
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
    public static Tab3 newInstance(String param1, String param2) {
        Tab3 fragment = new Tab3();
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
    View view3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view3 = inflater.inflate(R.layout.fragment_tab3, container, false);
        Button upButton = view3.findViewById(R.id.moon);
        LottieAnimationView loading_three;
        loading_three = view3.findViewById(R.id.setting_delay_three);
        upButton.setOnClickListener(new DoubleClick(new DoubleClickListener() {
            @Override
            public void onSingleClick(View view) {
                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                Toast.makeText(getContext(),"Tap twice to apply Lunar Phase",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClick(View view) {
                //FireNotif
                makeNotif();
                Button upButton = view3.findViewById(R.id.moon);
                upButton.setVisibility(View.INVISIBLE);
                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(28);
                SharedPreferences preferences = getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(TEXT,"moon");
                editor.commit();
                if (isFirstTime()) {
                    // Dialog Box
                    new AlertDialog.Builder(getActivity())
                            .setTitle("About Lunar Phase")
                            .setMessage(R.string.celestial_onetime)
                            .setPositiveButton("Okay", (dialog, which) -> {
                                loading_three.setVisibility(View.VISIBLE);
                                loading_three.playAnimation();
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            })
                            .create().show();
                }
                else{
                    loading_three.setVisibility(View.VISIBLE);
                    loading_three.playAnimation();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        }));

        return view3;
    }

    @Override
    public void onClick(View v) {
    }

    private void makeNotif() {
        String ro_build = android.os.Build.MANUFACTURER;
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
    private boolean isFirstTime() {
        SharedPreferences preferences = this.getActivity().getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }
}
