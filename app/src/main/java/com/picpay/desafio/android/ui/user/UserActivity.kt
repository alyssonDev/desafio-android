package com.picpay.desafio.android.ui.user

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.ui.user.adapter.UserListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserActivity : AppCompatActivity(R.layout.user_activity) {

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }
    private val progressBar: ProgressBar by lazy { findViewById<ProgressBar>(R.id.user_list_progress_bar) }
    private val adapter: UserListAdapter by lazy { UserListAdapter() }
    private val viewModel: UserViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        setupObserver()
    }

    private fun setupRecyclerView() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        progressBar.visibility = View.VISIBLE
    }

    private fun setupObserver() {
        viewModel.state.observe(this) {
            when (it) {
                is UserViewState.UserSuccess -> handleSuccess(it.users)
                is UserViewState.UserError -> handleError()
            }
        }
    }

    private fun handleError() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()
    }

    private fun handleSuccess(users: List<User>) {
        adapter.users = users
        progressBar.visibility = View.GONE
    }
}
