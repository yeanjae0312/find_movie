package com.movie.find_movie;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.movie.find_movie.chatting.MoabogiActivity;
/*
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

*/

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    //private FusedLocationProviderClient mFusedLocationClient;

   //  private FusedLocationProviderClient mFusedLocationClient;
    private static final int RC_LOCATION = 1;
    protected Location mLastLocation;

    MarkerOptions markerOptions;
    MarkerOptions markerOptions1;
    MarkerOptions markerOptions2;
    MarkerOptions markerOptions3;
    MarkerOptions markerOptions4;
    MarkerOptions markerOptions5;
    MarkerOptions markerOptions6;
    MarkerOptions markerOptions7;
    MarkerOptions markerOptions8;
    MarkerOptions markerOptions9;
    MarkerOptions markerOptions10;
    MarkerOptions markerOptions11;
    MarkerOptions markerOptions12;
    MarkerOptions markerOptions13;
    MarkerOptions markerOptions14;
    MarkerOptions markerOptions15;
    MarkerOptions markerOptions16;
    MarkerOptions markerOptions17;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        //mFusedLocationClient= LocationServices.getFusedLocationProviderClient(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
/*
    @AfterPermissionGranted(RC_LOCATION)
    public void getLastLocation() {
        String[] perms = {android.Manifest.permission.ACCESS_FINE_LOCATION};
        if(EasyPermissions.hasPermissions(this, perms)) {
            mFusedLocationClient.getLastLocation().addOnCompleteListener(this, new OnCompleteListener<Location>() {
                public void onComplete(@NonNull Task<Location> task) {
                    if(task.isSuccessful() && task.getResult() != null) {
                        mLastLocation = task.getResult();
                    }
                }
            });
        }
    }
*/

    /*
  if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
        mMap.setMyLocationEnabled(true);
    } else {
        // Show rationale and request permission.
    }

    protected synchronized void bildGoogleApiClient(){
        if(mGoogleApiClient == null){
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this,this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {
                // Permission was denied. Display an error message.
            }
        }
        */
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in duksung and move the camera
       /*
        LatLng duksung = new LatLng(37.651799, 127.015743 );
        LatLng cgv = new LatLng(37.651798, 127.015742 );

        mMap.addMarker(new MarkerOptions().position(duksung).title("Marker in duksung"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(duksung,20));
*/
        LatLng duksung = new LatLng(37.651799, 127.015743 );
        LatLng suyu = new LatLng(37.651799, 127.015343   );
        LatLng suyucgv = new LatLng(37.642319, 127.029821 );
        LatLng changdongmegabox = new LatLng(37.654600, 127.038738 );
        LatLng suyulotte = new LatLng(37.635787, 127.023789  );
        LatLng miacgv = new LatLng(37.612055, 127.030738 );
        LatLng nowonlotte = new LatLng(37.654801, 127.061067  );
        LatLng sungsincgv = new LatLng(37.592643,127.01702  );
        LatLng gungyecgv = new LatLng(37.6398053,127.06865300000004  );
        LatLng hagyecgv = new LatLng(37.6387775,127.06473679999999  );
        LatLng daehackrowcgv = new LatLng(37.583362, 126.999840);
        LatLng sangbongmegabox = new LatLng(37.593068, 127.074655  );
        LatLng sangbongcgv = new LatLng(37.597541, 127.092336 );
        LatLng chunglotte = new LatLng(37.580474, 127.047959 );
        LatLng janglotte = new LatLng(37.571811, 127.072272 );
        LatLng hwanglotte = new LatLng(37.571224, 127.021628 );
        LatLng dongmegabox = new LatLng(37.566806, 127.007353 );
        LatLng pikacgv = new LatLng(37.570972, 126.991213 );




        markerOptions = new MarkerOptions();
        markerOptions1 = new MarkerOptions();
        markerOptions2 = new MarkerOptions();
        markerOptions3 = new MarkerOptions();
        markerOptions4 = new MarkerOptions();
        markerOptions5 = new MarkerOptions();
        markerOptions6 = new MarkerOptions();
        markerOptions7 = new MarkerOptions();
        markerOptions8 = new MarkerOptions();
        markerOptions9 = new MarkerOptions();
        markerOptions10 = new MarkerOptions();
        markerOptions11 = new MarkerOptions();
        markerOptions12 = new MarkerOptions();
        markerOptions13 = new MarkerOptions();
        markerOptions14 = new MarkerOptions();
        markerOptions15 = new MarkerOptions();
        markerOptions16 = new MarkerOptions();
        markerOptions17 = new MarkerOptions();


        markerOptions.position(duksung)
                .title("내 위치" )
                .snippet("덕성여자대학교");

        markerOptions1.position(suyu)
                .title("너 위치" )
                .snippet("덕성여자대학교")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .alpha(0.8f);

        markerOptions2.position(suyucgv)
                .title("수유 cgv" )
                .snippet("탐정:리턴즈 11:20")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cgvicon2))
                .alpha(0.8f);

        markerOptions3.position(changdongmegabox)
                .title("창동 메가박스" )
                .snippet("아일라 11:45")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.megaboxicon2))
                .alpha(0.8f);

        markerOptions4.position(suyulotte)
                .title("수유 롯데시네마" )
                .snippet("아이 필 프리티 11:15")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lotteicon2))
                .alpha(0.8f);

        markerOptions5.position(miacgv)
                .title("미아 cgv" )
                .snippet("탐정:리턴즈 11:20")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cgvicon2))
                .alpha(0.8f);

        markerOptions6.position(nowonlotte)
                .title("노원 롯데시네마" )
                .snippet("더 펜션 11:15")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lotteicon2))
                .alpha(0.8f);

        markerOptions7.position(sungsincgv)
                .title("성신여대입구 cgv" )
                .snippet("독전 11:25")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cgvicon2))
                .alpha(0.8f);

        markerOptions8.position(gungyecgv)
                .title("중계 cgv" )
                .snippet("쥬라기월드:폴른킹덤 11:40")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cgvicon2))
                .alpha(0.8f);

        markerOptions9.position(hagyecgv)
                .title("하계 cgv" )
                .snippet("쥬라기월드:폴른킹덤 12:30")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cgvicon2))
                .alpha(0.8f);

        markerOptions10.position(daehackrowcgv)
                .title("대학로 cgv" )
                .snippet("아일라 11:25")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cgvicon2))
                .alpha(0.8f);

        markerOptions11.position(sangbongmegabox)
                .title("상봉 메가박스" )
                .snippet("어벤져스 5:50")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.megaboxicon2))
                .alpha(0.8f);

        markerOptions12.position(sangbongcgv)
                .title("상봉 cgv" )
                .snippet("탐정:리턴즈 11:50")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cgvicon2))
                .alpha(0.8f);

        markerOptions13.position(chunglotte)
                .title("청량리 롯데시네마" )
                .snippet("아이 필 프리티 11:35")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lotteicon2))
                .alpha(0.8f);

        markerOptions14.position(janglotte)
                .title("장안 롯데시네마" )
                .snippet("오션스8 11:35")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lotteicon2))
                .alpha(0.8f);

        markerOptions15.position(hwanglotte)
                .title("황학 롯데시네마" )
                .snippet("여중생A 11:20")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lotteicon2))
                .alpha(0.8f);

        markerOptions16.position(dongmegabox)
                .title("동대문 megabox" )
                .snippet("아직 끝나지 않았다 11:20")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.megaboxicon2))
                .alpha(0.8f);

        markerOptions17.position(pikacgv)
                .title("피카디리1958 cgv" )
                .snippet("탐정:리턴즈 11:50")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cgvicon2))
                .alpha(0.8f);

        mMap.addMarker(markerOptions);
        mMap.addMarker(markerOptions1);
        mMap.addMarker(markerOptions2);
        mMap.addMarker(markerOptions3);
        mMap.addMarker(markerOptions4);
        mMap.addMarker(markerOptions5);
        mMap.addMarker(markerOptions6);
        mMap.addMarker(markerOptions7);
        mMap.addMarker(markerOptions8);
        mMap.addMarker(markerOptions9);
        mMap.addMarker(markerOptions10);
        mMap.addMarker(markerOptions11);
        mMap.addMarker(markerOptions12);
        mMap.addMarker(markerOptions13);
        mMap.addMarker(markerOptions14);
        mMap.addMarker(markerOptions15);
        mMap.addMarker(markerOptions16);
        mMap.addMarker(markerOptions17);


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(duksung,15));



/*
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);


                return false;
            }
        });*/




        // Add a marker in duksung and move the camera
        // final LatLng duksung = new LatLng(37.651799, 127.015743);
/*
        Button button = (Button)findViewById(R.id.button3D);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(duksung)      // Sets the center of the map to Mountain View
                        .zoom(17)                   // Sets the zoom
                        .bearing(90)                // Sets the orientation of the camera to east
                        .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                        .build();                   // Creates a CameraPosition from the builder
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
*/


        mMap.setOnMarkerClickListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Intent intent = new Intent(getApplication(),MoabogiActivity.class);
        startActivity(intent);
        // Toast.makeText(this, marker.getTitle()+ "\n" + marker.getPosition(), Toast.LENGTH_SHORT).show();

        return false;
    }
}
