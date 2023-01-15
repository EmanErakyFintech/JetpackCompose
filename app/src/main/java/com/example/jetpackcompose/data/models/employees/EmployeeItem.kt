package com.example.jetpackcompose.data.models.employees


data class EmployeeItem(
    var id: Int=0,
    var name: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var identity_number: String? = null,
    var nationality_id: Int = 0,
    var vendor_branch_id:Int =0,
    var vendor_job_id:Int =0,
    var abilities :List<Int> = mutableListOf(),
    )


