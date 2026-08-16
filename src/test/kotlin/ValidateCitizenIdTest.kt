package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ValidateCitizenIdTest {

    @Test
    fun `should return true for valid 13-digit format`() {
        assertTrue(validateCitizenId("3509900547250"))
    }

    @Test
    fun `should return false when length is not 13 digits`() {
        assertFalse(validateCitizenId("123456789012"))   // 12 หลัก
        assertFalse(validateCitizenId("12345678901234")) // 14 หลัก
    }

    @Test
    fun `should return false when contains non-digit characters`() {
        assertFalse(validateCitizenId("123456789012A"))
        assertFalse(validateCitizenId("1234-56789012"))
    }

    @Test
    fun `id with wrong checksum returns false`() {
        // หลักที่ 13 ต้องเป็น check digit ที่คำนวณจาก 12 หลักแรก
        // 110170018520 -> check digit ที่ถูกต้องคือ 6
        assertFalse(validateCitizenId("1101700185207")) // หลักสุดท้ายผิด
        assertFalse(validateCitizenId("1234567890129")) // ที่ถูกคือ ...1

        // ใบที่ checksum ถูกต้อง ต้องยังผ่านอยู่
        assertTrue(validateCitizenId("3509900547250"))
        assertTrue(validateCitizenId("1234567890121"))
    }

    @Test
    fun `id with Thai number returns true`() {
        // ต้องรองรับตัวเลขไทย (๐-๙)
        assertTrue(validateCitizenId("๑๑๐๑๗๐๐๑๘๕๒๐๖"))
    }
}
