package com.douglasborba.motivation.infra

//ninguém instancia essa classe
class MotivationConstants private constructor(){
    object KEY {
        val PERSON_NAME = "name"
    }

    object PHRASEFILTER {
        val ALL = 1
        val HAPPY = 2
        val MORNING = 3
    }
}