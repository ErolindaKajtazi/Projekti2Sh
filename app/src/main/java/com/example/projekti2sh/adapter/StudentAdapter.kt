package com.example.projekti2sh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projekti2sh.R
import com.example.projekti2sh.models.Student
import com.example.projekti2sh.databinding.StudentItemBinding
import com.squareup.picasso.Picasso

class StudentAdapter(private val studentList : List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = StudentItemBinding.inflate(inflater, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.bind(student)
    }

    class StudentViewHolder(private val binding : StudentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.student = student
            binding.executePendingBindings()

//            // Use Picasso to load the image into ImageView
//            Picasso.get()
//                .load(student.imageUrl)
//                .placeholder(R.drawable.placeholder_image) // Optional: Placeholder image while loading
////                .error(R.drawable.error_image) // Optional: Image to show in case of error
//                .into(binding.imageView)
        }
    }
}