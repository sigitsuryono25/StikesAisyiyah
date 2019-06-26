package id.co.maminfaruq.stikesaisyiyah.adapter.menu

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.co.maminfaruq.stikesaisyiyah.R
import id.co.maminfaruq.stikesaisyiyah.model.DataMenu
import id.co.maminfaruq.stikesaisyiyah.ui.menu.berita.BeritaActivity
import id.co.maminfaruq.stikesaisyiyah.ui.menu.fasilitas.FasilitasActivity
import id.co.maminfaruq.stikesaisyiyah.ui.menu.jadwal.JadwalActivity
import id.co.maminfaruq.stikesaisyiyah.ui.menu.p3m.P3mActivity
import id.co.maminfaruq.stikesaisyiyah.ui.menu.pmb.PmbActivity
import id.co.maminfaruq.stikesaisyiyah.ui.menu.profil.ProfileActivity
import id.co.maminfaruq.stikesaisyiyah.ui.menu.program.ProgramActivity
import id.co.maminfaruq.stikesaisyiyah.ui.menu.siakad.SiakadActivity
import id.co.maminfaruq.stikesaisyiyah.ui.menu.sister.SisterActivity
import kotlinx.android.synthetic.main.item_menu.view.*

class MenuAdapter(val context: Context, val items: List<DataMenu>) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_menu, p0, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(items[p1],p1)
    }

    class ViewHolder(val view: View,val c : Context) : RecyclerView.ViewHolder(view) {

        val textTitle = view.tv_judul_menu
        val gambar = view.img_menu

        fun bindItems(dataMenu: DataMenu, post : Int){
            textTitle.text = dataMenu.judul
            Glide.with(itemView.context).load(dataMenu.gambar).into(gambar)

            view.setOnClickListener {
               when (post){
                   0 -> c.startActivity(Intent(c, ProfileActivity::class.java))
                   1 -> c.startActivity(Intent(c, ProgramActivity::class.java))
                   2 -> c.startActivity(Intent(c, PmbActivity::class.java))
                   3 -> c.startActivity(Intent(c, FasilitasActivity::class.java))
                   4 -> c.startActivity(Intent(c, SiakadActivity::class.java))
                   5 -> c.startActivity(Intent(c, BeritaActivity::class.java))
                   6 -> c.startActivity(Intent(c, JadwalActivity::class.java))
                   7 -> c.startActivity(Intent(c, SisterActivity::class.java))
                   8 -> c.startActivity(Intent(c, P3mActivity::class.java))
               }
            }
        }
    }
}