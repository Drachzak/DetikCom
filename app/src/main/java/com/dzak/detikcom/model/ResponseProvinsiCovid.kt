package com.dzak.detikcom.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseProvinsiCovid(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("fid")
	val fid: Int? = null,

	@field:SerializedName("provinsi")
	val provinsi: String? = null,

	@field:SerializedName("kasusMeni")
	val kasusMeni: String? = null,

	@field:SerializedName("kodeProvi")
	val kodeProvi: String? = null,

	@field:SerializedName("kasusSemb")
	val kasusSemb: String? = null,

	@field:SerializedName("kasusPosi")
	val kasusPosi: String? = null
) : Parcelable
