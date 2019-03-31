package lv.citadele.shops.model

import java.time.LocalTime

class Shop(
        val address: String,
        val phone: String,
        val hours: WeeklyHours
) {
    companion object {
        val ATVERTS = Shop(
                address = "Ground floor, Kaļķu iela 8, Centra rajons, Rīga, LV-1050",
                phone = "25 700 000",
                hours = WeeklyHours(
                        workingDays = DailyHours(
                                opens = LocalTime.of(12, 0),
                                closes = LocalTime.of(21, 0)
                        ),
                        weekends = DailyHours(
                                opens = LocalTime.of(12, 0),
                                closes = LocalTime.of(21, 0)
                        )
                )
        )
        val STREETBURGER = Shop(
                address = "Blaumaņa iela 10, Centra rajons, Rīga, LV-1001   ",
                phone = "26 627 722",
                hours = WeeklyHours(
                        workingDays = DailyHours(
                                opens = LocalTime.of(12, 0),
                                closes = LocalTime.of(22, 0)
                        ),
                        weekends = DailyHours(
                                opens = LocalTime.of(12, 0),
                                closes = LocalTime.of(0, 0)
                        )
                )
        )
    }
}