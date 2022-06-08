package com.example.smashhere.bottomNavigation

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.smashhere.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.fragment_fighters.*

class Fighters : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fighters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//Programmer la Toolbar dans "onViewCreated"
        view.findViewById<Toolbar>(R.id.characters_toolbar)
    }
}
