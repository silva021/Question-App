package com.silva021.questionapp.ui.schoolsubjects.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silva021.questionapp.databinding.SchoolSubjectsListItemBinding
import com.silva021.questionapp.data.model.SchoolSubjectResponse
import com.silva021.questionapp.databinding.SchoolSubjectsCategoryItemBinding
import com.silva021.questionapp.domain.model.SchoolSubject
import com.silva021.questionapp.domain.model.SchoolSubjectCategory
import com.silva021.questionapp.ui.schoolsubjects.list.adapter.SchoolSubjectsAdapter

class SchoolSubjectsCategoryAdapter(
    private val schoolSubjectCategory: List<SchoolSubjectCategory>,
    private val onClickListener: (SchoolSubjectCategory) -> Unit
) : RecyclerView.Adapter<SchoolSubjectsCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolSubjectsCategoryAdapter.ViewHolder {
        val itemBinding = SchoolSubjectsCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(schoolSubjectCategory[position])
    }

    override fun getItemCount() = schoolSubjectCategory.size

    inner class ViewHolder(
        private val binding: SchoolSubjectsCategoryItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(schoolSubject: SchoolSubjectCategory) {
            binding.txtName.text = schoolSubject.name

            binding.root.setOnClickListener {
                onClickListener(schoolSubject)
            }
        }
    }
}
