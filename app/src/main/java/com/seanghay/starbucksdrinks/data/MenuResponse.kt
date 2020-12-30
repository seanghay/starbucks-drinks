package com.seanghay.starbucksdrinks.data

data class MenuResponse(
    val menus: List<ProductCategory>? = null
)

data class ProductCategory(
    val displayOrder: Int? = null,
    val name: String? = null,
    val id: String? = null,
    val children: List<ProductCategory>? = null,
    val products: List<ProductItem>? = null
)

data class ProductItem(
    val name: String? = null,
    val formCode: String? = null,
    val displayOrder: Int? = null,
    val productNumber: Long? = null,
    val productType: String? = null,
    val availability: String? = null,
    val assets: ProductAssets? = null,
    val sizes: List<ProductSize>? = null,
    val uri: String? = null,
)

data class ProductSize(
    val sizeCode: String? = null
)

data class ProductAssets(
    val thumbnail: ProductThumbnail? = null,
    val fullSize: ProductImageSource? = null,
    val masterImage: ProductImageSource? = null,
)

data class ProductThumbnail(
    val large: ProductImageSource? = null
)

data class ProductImageSource(
    val uri: String? = null,
)