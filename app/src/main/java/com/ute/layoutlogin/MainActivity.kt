package com.ute.layoutlogin

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Anh xa cac View tu XML
        val edtHoTen = findViewById<EditText>(R.id.edtHoTen)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val rgGioiTinh = findViewById<RadioGroup>(R.id.rgGioiTinh)
        val swNhanThongBao = findViewById<SwitchCompat>(R.id.swNhanThongBao)
        val btnLuu = findViewById<Button>(R.id.btnLuuThietLap)
        val tvKetQua = findViewById<TextView>(R.id.tvKetQua)

        // Su kien bam nut -> Thay doi noi dung tren TextView
        btnLuu.setOnClickListener {
            val hoTen = edtHoTen.text.toString().trim()
            val email = edtEmail.text.toString().trim()

            if (hoTen.isEmpty()) {
                edtHoTen.error = "Vui lòng nhập họ tên!"
                tvKetQua.text = "Lỗi: Họ tên không được để trống!"
                tvKetQua.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // Lay thong tin gioi tinh
            val selectedRadioId = rgGioiTinh.checkedRadioButtonId
            val selectedRadio = findViewById<RadioButton>(selectedRadioId)
            val gioiTinh = selectedRadio?.text?.toString() ?: "Chưa rõ"

            // Lay thong tin switch thong bao
            val thongBao = if (swNhanThongBao.isChecked) "Bật nhận thông báo" else "Tắt thông báo"

            // Thay doi truc tiep noi dung tren TextView
            val noiDungMoi = """
                CẬP NHẬT THÀNH CÔNG:
                - Họ tên: $hoTen
                - Email: ${if (email.isNotEmpty()) email else "Chưa nhập"}
                - Giới tính: $gioiTinh
                - Trạng thái: $thongBao
            """.trimIndent()

            tvKetQua.text = noiDungMoi
            tvKetQua.setTextColor(Color.parseColor("#1B5E20")) // Doi sang mau xanh la

            Toast.makeText(this, "Đã cập nhật dữ liệu lên TextView!", Toast.LENGTH_SHORT).show()
        }
    }
}