package id.co.maminfaruq.stikesaisyiyah.ui.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

import id.co.maminfaruq.stikesaisyiyah.R
import id.co.maminfaruq.stikesaisyiyah.adapter.menu.MenuAdapter
import id.co.maminfaruq.stikesaisyiyah.model.DataMenu
import kotlinx.android.synthetic.main.fragment_menu.*
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MenuFragment : Fragment() {

    val data: MutableList<DataMenu> = mutableListOf()/*Gunanya untuk bisa mengubah ubah datanya*/
//    var carouselView: CarouselView? = null
    var sampleImages = intArrayOf(R.drawable.slide1, R.drawable.slide2, R.drawable.slide3)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    @SuppressLint("Recycle")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        carouselView?.pageCount = sampleImages.size

        // carouselView?.setImageListener(imageListener)

        setToCarousel()


        val nama = resources.getStringArray(R.array.nama_menu)
        val gambar = resources.obtainTypedArray(R.array.image_menu)

        for (i in nama.indices) {
            data.add(DataMenu(nama[i], gambar.getResourceId(i, 0)))
        }

        rv_menu.layoutManager = GridLayoutManager(context, 3)
        rv_menu.adapter = MenuAdapter(context!!, data)
    }

    private fun setToCarousel() {
        try {
            carouselView?.setImageListener { position, imageView ->

                activity?.let {
                    Glide.with(it)
                            .load(sampleImages[position])
                            .into(imageView)
                }

            }
            carouselView?.pageCount = sampleImages.size
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

//    private var imageListener: ImageListener = ImageListener { position, imageView ->
//
//
//    }


}


