package com.ute.layoutlogin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtHoTen = findViewById<EditText>(R.id.edtHoTen)
        val rgGioiTinh = findViewById<RadioGroup>(R.id.rgGioiTinh)
        val swNhanThongBao = findViewById<SwitchCompat>(R.id.swNhanThongBao)
        val btnLuu = findViewById<Button>(R.id.btnLuuThietLap)

        btnLuu.setOnClickListener {
            val hoTen = edtHoTen.text.toString().trim()
            val selectedRadioId = rgGioiTinh.checkedRadioButtonId
            val selectedRadio = findViewById<RadioButton>(selectedRadioId)
            val gioiTinh = selectedRadio?.text?.toString() ?: "Chưa chọn"
            val thongBao = if (swNhanThongBao.isChecked) "Bật" else "Tắt"

            if (hoTen.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập họ tên!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "Đã lưu: $hoTen | Giới tính: $gioiTinh | Thông báo: $thongBao",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}