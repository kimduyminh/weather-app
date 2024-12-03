import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapp.data.weather
import com.example.weatherapp.data.weatherDao

@Database(entities = [weather::class], version = 1)
abstract class weatherDatabase : RoomDatabase() {
    abstract fun hourlyWeatherDao(): weatherDao
}