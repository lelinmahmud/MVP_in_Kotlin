package com.example.mvpinkotlin.model

import com.google.gson.annotations.SerializedName

data class CatalogProductsItem(

	@field:SerializedName("new_arrival")
	val newArrival: Int? = null,

	@field:SerializedName("emi")
	val emi: String? = null,

	@field:SerializedName("end_date")
	val endDate: Any? = null,

	@field:SerializedName("product_image")
	val productImage: String? = null,

	@field:SerializedName("product_publication_status")
	val productPublicationStatus: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("discount")
	val discount: Any? = null,

	@field:SerializedName("type")
	val type: Any? = null,

	@field:SerializedName("tax_rate")
	val taxRate: String? = null,

	@field:SerializedName("product_desc")
	val productDesc: String? = null,

	@field:SerializedName("category_id")
	val categoryId: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("product_id")
	val productId: Int? = null,

	@field:SerializedName("stock_qty")
	val stockQty: Int? = null,

	@field:SerializedName("warranty")
	val warranty: String? = null,

	@field:SerializedName("commission")
	val commission: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("tag")
	val tag: String? = null,

	@field:SerializedName("gift_voucher")
	val giftVoucher: String? = null,

	@field:SerializedName("stock")
	val stock: Int? = null,

	@field:SerializedName("commission_type")
	val commissionType: Any? = null,

	@field:SerializedName("product_model")
	val productModel: String? = null,

	@field:SerializedName("start_date")
	val startDate: Any? = null,

	@field:SerializedName("images")
	val images: List<String?>? = null,

	@field:SerializedName("batch_no")
	val batchNo: Any? = null,

	@field:SerializedName("tax_class_id")
	val taxClassId: Any? = null,

	@field:SerializedName("weight")
	val weight: String? = null,

	@field:SerializedName("specification")
	val specification: String? = null,

	@field:SerializedName("product_name")
	val productName: String? = null,

	@field:SerializedName("created_by")
	val createdBy: Int? = null,

	@field:SerializedName("weight_class")
	val weightClass: String? = null,

	@field:SerializedName("outlet_id")
	val outletId: Int? = null,

	@field:SerializedName("vendor_id")
	val vendorId: Any? = null,

	@field:SerializedName("updated_by")
	val updatedBy: Int? = null,

	@field:SerializedName("weight_class_id")
	val weightClassId: Any? = null,

	@field:SerializedName("max_in_cart")
	val maxInCart: Any? = null,

	@field:SerializedName("is_feature_product")
	val isFeatureProduct: Int? = null
)