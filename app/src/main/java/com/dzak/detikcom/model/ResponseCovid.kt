package com.dzak.detikcom.model

import com.google.gson.annotations.SerializedName

data class ResponseCovid(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("value")
	val value: String? = null
)
