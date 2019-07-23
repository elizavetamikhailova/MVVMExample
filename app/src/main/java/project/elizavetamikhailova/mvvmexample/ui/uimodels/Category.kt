package project.elizavetamikhailova.mvvmexample.ui.uimodels

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Category(@PrimaryKey(autoGenerate = true)
                    var id: Int,
                    @SerializedName("Tables_in_e49426_db")
                    @Expose
                    var tablesInBgu: String,
                    @SerializedName("real_table_name")
                    @Expose
                    var realTableName: String) : Serializable, BaseObservable()