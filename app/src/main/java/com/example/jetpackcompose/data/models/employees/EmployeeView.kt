package  com.example.jetpackcompose.data.models.employees

import com.google.gson.annotations.SerializedName


data class EmployeeView(
    var ban_reason: String? = null,
    @SerializedName("branch")
    var branch: RegionsItem? = null,
    var nationality: RegionsItem? = null,
    var created_at: String? = null,
    var deactivation_comment: String? = null,
    var email: String? = null,
    var id: Int = 0,
    var identity_number: String? = null,
    var is_active: Boolean?,
    var is_ban: Boolean?,
    var job: RegionsItem? = null,
    var name: String? = null,
    var phone: String? = null,
    var risk_name: String? = null,
    var nationality_id: Int = 0,
    var vendor_branch_id: Int = 0,
    var vendor_job_id: Int = 0,
    var facility_id: Int = 0,
    val imei: String? = null,
    val ip_address: String? = null,
    val uuid: String? = null,
)


