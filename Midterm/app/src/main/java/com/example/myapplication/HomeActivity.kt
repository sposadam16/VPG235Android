package com.example.myapplication

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var input: EditText
    lateinit var list: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)
        input = findViewById(R.id.taskInput)
        list = findViewById(R.id.taskList)
    }

    override fun onResume() {
        super.onResume()
        // Show tasks for the current account after returning from login or profile.
        input.setText("")
        input.error = null
        showTasks()
    }

    fun openAccount(v: View) {
        if (currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    fun addTask(v: View) {
        val user = currentUser ?: return
        val title = input.text.toString().trim()
        if (title.isEmpty()) {
            input.error = "Enter a task"
            return
        }
        for (letter in title) {
            if (!letter.isLetterOrDigit() && letter !in " -:,.!?()'") {
                input.error = "Use letters, numbers, spaces or basic punctuation"
                return
            }
        }
        for (task in user.tasks) {
            if (task.title.equals(title, ignoreCase = true)) {
                input.error = "This task is already on your list"
                return
            }
        }
        user.tasks.add(Task(title))
        input.setText("")
        showTasks()
    }

    private fun showTasks() {
        list.removeAllViews()
        val heading = findViewById<TextView>(R.id.taskTitle)
        val editor = findViewById<View>(R.id.taskEditor)
        val user = currentUser
        if (user == null) {
            heading.text = "Tap Me to sign in and see your tasks."
            editor.visibility = View.GONE
            return
        }
        heading.text = "Tasks for " + user.name
        editor.visibility = View.VISIBLE

        for (task in user.tasks) {
            val row = layoutInflater.inflate(R.layout.task_row, list, false)
            val check = row.findViewById<CheckBox>(R.id.taskCheck)
            check.text = task.title
            check.isChecked = task.done
            if (task.done) {
                check.paintFlags = check.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
            check.setOnClickListener {
                task.done = check.isChecked
                showTasks()
            }
            val delete = row.findViewById<ImageButton>(R.id.deleteTask)
            delete.contentDescription = "Delete " + task.title
            delete.setOnClickListener {
                user.tasks.remove(task)
                showTasks()
            }
            list.addView(row)
        }
    }
}