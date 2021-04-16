package com.aaxena.kaagaz;

import android.app.DownloadManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.pedromassango.doubleclick.DoubleClick;
import com.pedromassango.doubleclick.DoubleClickListener;
import com.squareup.picasso.Picasso;

import static android.content.Context.DOWNLOAD_SERVICE;
import static android.content.Context.MODE_PRIVATE;
import static android.graphics.Color.RED;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab4 extends Fragment implements View.OnClickListener{
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab4() {
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
    public static Tab4 newInstance(String param1, String param2) {
        Tab4 fragment = new Tab4();
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
    View view4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view4 = inflater.inflate(R.layout.fragment_tab4, container, false);
        Button upButton = view4.findViewById(R.id.kaagaz);
        ImageView kaagazWallpaper;
        kaagazWallpaper = view4.findViewById(R.id.imageViewKaagaz);
        Picasso.get().load("https://i.ibb.co/Yy9rmTg/abs-1.png").into(kaagazWallpaper);
        LottieAnimationView loading_four;
        loading_four = view4.findViewById(R.id.setting_delay_four);
        if (isFirstTime()) {
            // Dialog Box
            AlertDialog.Builder ImageDialog = new AlertDialog.Builder(getContext())
                    .setCancelable(false);
            ImageDialog.setTitle("Kaagaz Wallpapers are here!")
                    .setMessage("The Kaagaz wallpapers are simple abstract and geometric wallpapers that change throughout the day.\n\nDeveloped by Kaagaz!");
            ImageDialog.setNegativeButton("Fantastic!", (arg0, arg1) -> {
            });
            ImageDialog.show();
        }
        upButton.setOnClickListener(new DoubleClick(new DoubleClickListener() {
            @Override
            public void onSingleClick(View view) {
                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                Toast.makeText(getContext(),"Tap twice to apply Kaagaz",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClick(View view) {
                //FireNotif
                if (checkPermission()) {
                    downloadFirstFile();
                    downloadSecondFile();
                    downloadThirdFile();
                    downloadFourthFile();
                    downloadFifthFile();
                    downloadSixthFile();
                    downloadSeventhFile();
                    downloadEighthFile();
                    downloadNineFile();
                    downloadTenFile();
                    downloadElevenFile();
                    downloadTweleveFile();
                }
                else {
                    Toast.makeText(getContext(),"Storage Permission Denied, Cannot Download Kaagaz Dynamic Wallpaper Pack",Toast.LENGTH_LONG).show();
                }
                /*
                makeNotif();
                Button upButton = view4.findViewById(R.id.kaagaz);
                upButton.setVisibility(View.INVISIBLE);
                loading_four.setVisibility(View.VISIBLE);
                loading_four.playAnimation();
                Vibrator vibrator = (Vibrator)getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(28);
                SharedPreferences preferences = getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(TEXT,"kaagaz");
                editor.commit();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();

                 */
            }
        }));
        return view4;
    }

    public void downloadFirstFile() {
        Uri uri = Uri.parse("https://i.ibb.co/Yy9rmTg/abs-1.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Dynamic Wallpapers Pack Downloaded");
        request.setDescription("Kaagaz Originals");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"one"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadSecondFile() {
        Uri uri = Uri.parse("https://i.ibb.co/vXJdrNY/abs-2.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"two"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadThirdFile() {
        Uri uri = Uri.parse("https://i.ibb.co/PrP32Kh/abs-3.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"three"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadFourthFile() {
        Uri uri = Uri.parse("https://i.ibb.co/b60t37Q/abs-4.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"four"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadFifthFile() {
        Uri uri = Uri.parse("https://i.ibb.co/5BY0TWf/abs-5.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"five"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadSixthFile() {
        Uri uri = Uri.parse("https://i.ibb.co/CBdG1kp/abs-6.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"six"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadSeventhFile() {
        Uri uri = Uri.parse("https://i.ibb.co/q7YbLx4/abs-7.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"seven"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadEighthFile() {
        Uri uri = Uri.parse("https://i.ibb.co/BGxHgdX/abs-8.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"eight"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadNineFile() {
        Uri uri = Uri.parse("https://i.ibb.co/bXLdqG6/abs-9.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"nine"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadTenFile() {
        Uri uri = Uri.parse("https://i.ibb.co/xmdSSKh/abs-10.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"ten"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadElevenFile() {
        Uri uri = Uri.parse("https://i.ibb.co/H2zH7Jv/abs-11.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"eleven"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
    public void downloadTweleveFile() {
        Uri uri = Uri.parse("https://i.ibb.co/Scz5TQy/abs-12.png");
        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI| DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Kaagaz Wallpaper Downloaded");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM,"/Kaagaz/"+"/KaagazOriginals/"+"twelve"+".png");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }



    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
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
    private boolean isFirstTime() {
        SharedPreferences preferences = this.getActivity().getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBeforeKaagaz", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBeforeKaagaz", true);
            editor.commit();
        }
        return !ranBefore;
    }
}
