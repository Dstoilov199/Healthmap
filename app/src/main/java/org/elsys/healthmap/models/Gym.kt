package org.elsys.healthmap.models

import com.google.firebase.firestore.GeoPoint

data class Gym(
    var name: String,
    var photos: MutableList<String>,
    var coordinates: GeoPoint,
    var address: String,
    var geohash: String,
    var description: String,
    var tags: MutableList<String>,
    var priceTable: MutableMap<String, Float>,
    var owner: String
) {
    constructor() : this(
        "",
        mutableListOf(),
        GeoPoint(0.0, 0.0),
        "",
        "",
        "",
        mutableListOf(),
        mutableMapOf(),
        ""
    )

    constructor(gym: Gym) : this(
        gym.name,
        gym.photos,
        gym.coordinates,
        gym.address,
        gym.geohash,
        gym.description,
        gym.tags,
        gym.priceTable,
        gym.owner
    )
}
