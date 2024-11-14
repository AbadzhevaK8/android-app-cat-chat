package com.abadzheva.catchat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.abadzheva.catchat.databinding.FragmentInboxBinding

class InboxFragment : Fragment(R.layout.fragment_inbox) {
    private val binding by viewBinding(FragmentInboxBinding::bind)

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
    }
}
