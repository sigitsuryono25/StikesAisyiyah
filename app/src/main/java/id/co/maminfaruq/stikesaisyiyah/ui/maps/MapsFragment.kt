package id.co.maminfaruq.stikesaisyiyah.ui.maps


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import id.co.maminfaruq.stikesaisyiyah.R
import kotlinx.android.synthetic.main.fragment_maps.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MapsFragment : Fragment() , OnMapReadyCallback{

    var map : GoogleMap? = null
    var supportMapFragment : SupportMapFragment? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        supportMapFragment = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        supportMapFragment?.getMapAsync(this)

    }

    override fun onMapReady(p0: GoogleMap?) {
        map = p0
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-7.680166,110.591480),12f))
        map?.addMarker(MarkerOptions().position(LatLng(-7.680166,110.591480)).title("STIKE Aisiyah"))?.showInfoWindow()
    }


}
