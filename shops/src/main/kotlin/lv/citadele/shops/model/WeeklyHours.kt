package lv.citadele.shops.model

class WeeklyHours(
        val workingDays: DailyHours,
        val weekends: DailyHours
)