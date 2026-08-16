package org.example

/**
 * ตรวจสอบความถูกต้องของเลขบัตรประจำตัวประชาชนไทย 13 หลัก
 * รองรับทั้งตัวเลขอารบิก (0-9) และตัวเลขไทย (๐-๙)
 *
 * @param id รหัสประจำตัวประชาชน 13 หลัก
 * @return true หากรูปแบบและความถูกต้องของ Checksum ถูกต้อง, false หากไม่ถูกต้อง
 */
fun validateCitizenId(id: String): Boolean {
    // 1. ตรวจสอบความยาวต้องเท่ากับ 13 ตัวอักษร
    if (id.length != 13) {
        return false
    }

    // 2. แปลงแต่ละตัวอักษรเป็นตัวเลข (รองรับทั้งเลขอารบิก 0-9 และเลขไทย ๐-๙)
    // หากมีอักขระที่ไม่ใช่ตัวเลข จะคืนค่า false ทันที
    val digits = id.map { ch ->
        when (ch) {
            in '0'..'9' -> ch - '0'
            in '๐'..'๙' -> ch - '๐'
            else -> return false
        }
    }

    // 3. คำนวณ Checksum จาก 12 หลักแรก
    // Sum = (digit[0]*13) + (digit[1]*12) + ... + (digit[11]*2)
    val sum = (0..11).sumOf { i ->
        digits[i] * (13 - i)
    }

    // 4. คำนวณ Check Digit
    // Check Digit = (11 - (Sum % 11)) % 10
    val expectedCheckDigit = (11 - (sum % 11)) % 10

    // 5. นำ Check Digit ไปเปรียบเทียบกับหลักที่ 13 (index 12)
    return expectedCheckDigit == digits[12]
}
