package org.example

import kotlin.test.Test
import kotlin.test.assertEquals

class WorkshopTest {

    // --- Tests for Workshop #1: Unit Converter ---

    // celsius input: 20.0
    // expected output: 68.0
    @Test
    fun `test celsiusToFahrenheit with positive value`() {
        // Arrange: ตั้งค่า input และผลลัพธ์ที่คาดหวัง
        val celsiusInput = 20.0
        val expectedFahrenheit = 68.0

        // Act: เรียกใช้ฟังก์ชันที่ต้องการทดสอบ
        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        // Assert: ตรวจสอบว่าผลลัพธ์ที่ได้ตรงกับที่คาดหวัง
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "20°C should be 68°F")
    }

    // celsius input: 0.0
    // expected output: 32.0
    @Test
    fun `test celsiusToFahrenheit with zero`() {
        val celsiusInput = 0.0
        val expectedFahrenheit = 32.0

        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "0°C should be 32°F")
    }

    // celsius input: -10.0
    // expected output: 14.0
    @Test
    fun `test celsiusToFahrenheit with negative value`() {
        val celsiusInput = -10.0
        val expectedFahrenheit = 14.0

        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "-10°C should be 14°F")
    }

    // test for kilometersToMiles function
    // kilometers input: 1.0
    // expected output: 0.621371
    @Test
    fun `test kilometersToMiles with one kilometer`() {
        val kilometersInput = 1.0
        val expectedMiles = 0.621371

        val actualMiles = kilometersToMiles(kilometersInput)

        assertEquals(expectedMiles, actualMiles, 0.0001, "1 km should be ~0.621371 miles")
    }

    // --- Tests for Workshop #1: Unit Converter End ---

    // --- Tests for Workshop #2: Data Analysis Pipeline ---

    private val sampleProducts = listOf(
        Product("Laptop", 35000.0, "Electronics"),
        Product("Smartphone", 25000.0, "Electronics"),
        Product("T-shirt", 450.0, "Apparel"),
        Product("Monitor", 7500.0, "Electronics"),
        Product("Keyboard", 499.0, "Electronics"), // ราคาไม่เกิน 500
        Product("Jeans", 1200.0, "Apparel"),
        Product("Headphones", 1800.0, "Electronics")
    )

    @Test
    fun `test calculateTotalElectronicsPriceOver500 with sample products`() {
        // Arrange
        // รายการที่เข้าเงื่อนไข: Laptop (35000) + Smartphone (25000) + Monitor (7500) + Headphones (1800) = 69300.0
        val expectedTotal = 69300.0

        // Act
        val actualTotal = calculateTotalElectronicsPriceOver500(sampleProducts)

        // Assert
        assertEquals(expectedTotal, actualTotal, 0.001, "Total price of Electronics > 500 should be 69300.0")
    }

    @Test
    fun `test calculateTotalElectronicsPriceOver500Sequence produces same result`() {
        // Arrange
        val expectedTotal = 69300.0

        // Act
        val actualTotal = calculateTotalElectronicsPriceOver500Sequence(sampleProducts)

        // Assert
        assertEquals(expectedTotal, actualTotal, 0.001, "Sequence total price should match List total price")
    }

    @Test
    fun `test countElectronicsOver500 with sample products`() {
        // Arrange
        // สินค้า Electronics ที่ราคา > 500 มี 4 ชิ้น (Laptop, Smartphone, Monitor, Headphones)
        val expectedCount = 4

        // Act
        val actualCount = countElectronicsOver500(sampleProducts)

        // Assert
        assertEquals(expectedCount, actualCount, "Count of Electronics > 500 should be 4")
    }

    @Test
    fun `test calculateTotalElectronicsPriceOver500 with empty list`() {
        // Arrange
        val emptyProducts = emptyList<Product>()
        val expectedTotal = 0.0

        // Act
        val actualTotal = calculateTotalElectronicsPriceOver500(emptyProducts)

        // Assert
        assertEquals(expectedTotal, actualTotal, 0.001, "Total for empty product list should be 0.0")
    }

    @Test
    fun `test calculateTotalElectronicsPriceOver500 when no items match criteria`() {
        // Arrange
        val products = listOf(
            Product("T-shirt", 450.0, "Apparel"),
            Product("Keyboard", 499.0, "Electronics") // ไม่เกิน 500
        )
        val expectedTotal = 0.0

        // Act
        val actualTotal = calculateTotalElectronicsPriceOver500(products)

        // Assert
        assertEquals(expectedTotal, actualTotal, 0.001, "Total should be 0.0 when no product matches criteria")
    }

    // --- Tests for Workshop #2: Data Analysis Pipeline End ---
}