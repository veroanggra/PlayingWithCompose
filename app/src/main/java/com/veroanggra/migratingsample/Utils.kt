package com.veroanggra.migratingsample

fun getPredicateStatus(scoreValue: Double): PredicateStatus {
    return when (scoreValue) {
        in 0.0..50.0-> PredicateStatus.TROLL
        in 50.1..60.0 -> PredicateStatus.DREADFUL
        in 60.1..70.0 -> PredicateStatus.POOR
        in 70.1..80.0 -> PredicateStatus.ACCEPTABLE
        in 80.1..90.0 -> PredicateStatus.EXCEEDS_EXPECTATIONS
        else -> PredicateStatus.OUTSTANDING
    }
}