package com.produtos.montaveis.ui.game

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.DragShadowBuilder
import android.view.View.OnDragListener
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.produtos.montaveis.R
import com.produtos.montaveis.databinding.FragmentFirstGameBinding

class FirstGameFragment : Fragment() {

    private var _binding: FragmentFirstGameBinding? = null

    private val binding get() = _binding!!

    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewAQuadrado.setOnLongClickListener {
            val aQuadrado = "A ao quadrado"
            val item = ClipData.Item(aQuadrado)
            val mimeTypes =
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val dragData = ClipData(aQuadrado, mimeTypes, item)
            val myShadow = DragShadowBuilder(it)
            it.startDragAndDrop(dragData, myShadow, it, 0)
            it.visibility = View.INVISIBLE
            true
        }
        binding.viewAbVertical.setOnLongClickListener {
            val aQuadrado = "ABVertical"
            val item = ClipData.Item(aQuadrado)
            val mimeTypes =
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val dragData = ClipData(aQuadrado, mimeTypes, item)
            val myShadow = DragShadowBuilder(it)
            it.startDragAndDrop(dragData, myShadow, it, 0)
            it.visibility = View.INVISIBLE
            true
        }
        binding.viewAbHorizontal.setOnLongClickListener {
            val aQuadrado = "AB horizontal"
            val item = ClipData.Item(aQuadrado)
            val mimeTypes =
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val dragData = ClipData(aQuadrado, mimeTypes, item)
            val myShadow = DragShadowBuilder(it)
            it.startDragAndDrop(dragData, myShadow, it, 0)
            it.visibility = View.INVISIBLE
            true
        }
        binding.viewBQuadrado.setOnLongClickListener {
            val aQuadrado = "B ao quadrado"
            val item = ClipData.Item(aQuadrado)
            val mimeTypes =
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val dragData = ClipData(aQuadrado, mimeTypes, item)
            val myShadow = DragShadowBuilder(it)
            it.startDragAndDrop(dragData, myShadow, it, 0)
            it.visibility = View.INVISIBLE
            true
        }

        val dragListener = OnDragListener { v: View, event: DragEvent ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                }
                DragEvent.ACTION_DRAG_ENTERED,
                DragEvent.ACTION_DRAG_EXITED,
                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                }
                DragEvent.ACTION_DROP -> {
                    v.invalidate()
                    val textView = event.localState as View
                    val owner = textView.parent as ViewGroup
                    owner.removeView(textView)
                    val layout = v as LinearLayout
                    layout.addView(textView)
                    textView.visibility = View.VISIBLE
                    viewModel.updateChallenge()
                }
                else -> { }
            }
            true
        }

        binding.layoutAQuadrado.setOnDragListener(dragListener)
        binding.layoutBQuadrado.setOnDragListener(dragListener)
        binding.layoutAbHorizontal.setOnDragListener(dragListener)
        binding.layoutAbVertical.setOnDragListener(dragListener)

        viewModel.challengeProgressStatus.observe(viewLifecycleOwner) {
            binding.challengeStatusBar.apply {
                progress = it.toInt()
                if (progress == 100) {
                    Thread.sleep(500)

                    requireActivity().supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<FinishGameFragment>(R.id.game_container_view)
                    }
                }
            }
        }
        requireActivity().title = "Quadrado da soma"
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}