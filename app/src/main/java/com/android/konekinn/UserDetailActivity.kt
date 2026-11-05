package com.android.konekinn

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.konekinn.databinding.ActivityUserDetailBinding
import com.android.konekinn.model.UserDetail
import com.android.konekinn.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ambil id
        val userId = intent.getIntExtra("USER_ID", -1)

        // panggil api dari id
        val client = ApiClient.getInstance()
        val response = client.getUserById(userId)

        response.enqueue(object : Callback<UserDetail> {

            override fun onResponse(
                call: Call<UserDetail>,
                response: Response<UserDetail>
            ) {

                if (response.isSuccessful && response.body() != null) {

                    val user = response.body()!!.data

                    binding.tvId.text = "ID: ${user.id}"
                    binding.tvName.text = "Name: ${user.employeeName}"
                    binding.tvAge.text = "Age: ${user.employeeAge}"
                    binding.tvSalary.text = "Salary: ${user.employeeSalary}"

                } else {

                    Toast.makeText(
                        this@UserDetailActivity,
                        "Data tidak ditemukan",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(
                call: Call<UserDetail>,
                t: Throwable
            ) {

                Toast.makeText(
                    this@UserDetailActivity,
                    "Error: ${t.message}",
                    Toast.LENGTH_LONG
                ).show()

                t.printStackTrace()
            }
        })
    }
}
