package com.uax.cardealership.models

import java.io.Serializable

class Model(
    var model: String,
    var brand: String,
    var price: Int,
    var cv: Int,
    var description: String,
    var img: Int
) : Serializable {


}