package dev.francisco.googlemaps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dev.francisco.googlemaps.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Modulo de uso com mais propriedades

        // Add a marker in Sydney and move the camera
        val melbourneLocation = LatLng(-37.813, 144.962)
        val melbourne = mMap.addMarker(
            MarkerOptions()
                .position(melbourneLocation)
                .title("Melbourne")
                .snippet("Population: 4,137,400")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.placeholder)))


     // Modulo de uso com menos propriedades

        //val porto = LatLng(41.157944,-8.629105)

       // mMap.addMarker(MarkerOptions().position(porto).title("Cidade do porto"))
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(porto))

        //mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
    }
}