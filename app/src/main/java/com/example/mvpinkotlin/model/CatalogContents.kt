package com.example.mvpinkotlin.model

import com.google.gson.annotations.SerializedName

data class CatalogContents(

	@field:SerializedName("category_name")
	val categoryName: String? = null,

	@field:SerializedName("category_logo")
	val categoryLogo: Any? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("created_by")
	val createdBy: Int? = null,

	@field:SerializedName("active_children")
	val activeChildren: List<Any?>? = null,

	@field:SerializedName("category_publication_status")
	val categoryPublicationStatus: Int? = null,

	@field:SerializedName("depth")
	val depth: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("parent_id")
	val parentId: Int? = null,

	@field:SerializedName("children_recursive")
	val childrenRecursive: List<Any?>? = null,

	@field:SerializedName("updated_by")
	val updatedBy: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("lft")
	val lft: Any? = null,

	@field:SerializedName("slug_url")
	val slugUrl: String? = null,

	@field:SerializedName("category_banner")
	val categoryBanner: String? = null,

	@field:SerializedName("rgt")
	val rgt: Any? = null
)