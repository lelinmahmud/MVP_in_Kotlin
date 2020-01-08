package com.example.mvpinkotlin.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("catalog_products")
	val catalogProducts: List<CatalogProductsItem?>? = null,

	@field:SerializedName("catalog_contents")
	val catalogContents: CatalogContents? = null,

	@field:SerializedName("subCategories")
	val subCategories: List<Any?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)