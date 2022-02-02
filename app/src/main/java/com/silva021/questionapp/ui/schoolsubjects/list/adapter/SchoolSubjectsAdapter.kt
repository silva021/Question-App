package com.silva021.questionapp.ui.schoolsubjects.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silva021.questionapp.databinding.SchoolSubjectsListItemBinding
import com.silva021.questionapp.data.model.SchoolSubjectResponse
import com.silva021.questionapp.domain.model.SchoolSubject

class SchoolSubjectsAdapter(
    private val listSchoolSubject: List<SchoolSubject>,
    private val onClickListener: (SchoolSubject) -> Unit
) : RecyclerView.Adapter<SchoolSubjectsAdapter.SchoolSubjectsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolSubjectsViewHolder {
        val itemBinding = SchoolSubjectsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SchoolSubjectsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SchoolSubjectsViewHolder, position: Int) {
        holder.bind(listSchoolSubject[position])
    }

    override fun getItemCount() = listSchoolSubject.size

    inner class SchoolSubjectsViewHolder(
        private val binding: SchoolSubjectsListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(schoolSubject: SchoolSubject) {
            binding.txtName.text = schoolSubject.name

            binding.root.setOnClickListener {
                onClickListener(schoolSubject)
            }
        }
    }
}
