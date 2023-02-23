package com.jobgun.aggregator.craigslist

object JobPages {
    val jobPageLinks = for {
        geo <- GeoCategories.geo.toList
        cat <- (JobCategories.cats ++ GigCategories.gigs).toList
    } yield (geo, cat, s"https://${geo._1}.craigslist.com/search/${cat._2}")
}