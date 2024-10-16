package com.tbank.task5

interface Animal {
    val weight : Float
    val age : Float
    fun get_weight() : Float
    fun get_age() : Float
}

interface Bite {
    val bite : String
    fun get_bite() : String
}

interface Type {
    val type : String
    fun get_type() : String
}

open class Dog(override val bite: String,
               override val age: Float,
               override val weight: Float) : Animal, Bite {

    override fun get_bite() : String {
        return bite
    }

    override fun get_weight() : Float {
        return weight
    }

    override fun get_age() : Float {
        return age
    }

}

open class Cat(override val type: String,
               override val age: Float,
               override val weight: Float) : Animal, Type {

    override fun get_type() : String {
        return type
    }

    override fun get_weight() : Float {
        return weight
    }

    override fun get_age() : Float {
        return age
    }

}

class Husky(override val bite: String,
            override val age: Float,
            override val weight: Float) : Dog(bite, age, weight) {
    fun get_breed(): String {
        return "Хаски"
    }
}

class Corgi(override val bite: String,
            override val age: Float,
            override val weight: Float) : Dog(bite, age, weight) {
    fun get_breed(): String {
        return "Корги"
    }
}

class Scottish(override val type: String,
               override val age: Float,
               override val weight: Float) : Cat(type, age, weight) {
    fun get_breed(): String {
        return "Шотландский"
    }
}

class Siamese(override val type: String,
               override val age: Float,
               override val weight: Float) : Cat(type, age, weight) {
    fun get_breed(): String {
        return "Сиамский"
    }
}

class PetStore() {
    fun determine_pet(breed : String) : String {
        return if (breed == "Шотландский" || breed == "Сиамский") {
            "Кот"
        } else {
            "Собака"
        }
    }

    fun find_food(pet : Animal) {
        /*
        Некоторая логика для подбора корма...
         */
    }
}


fun main() {
    val corgi1 = Corgi("Прямой", 10F, 12F)
    val corgi2 = Corgi("Недокус", 6F, 5F)
    val husky1 = Husky("Перекус", 3F, 8F)
    val siamese = Siamese("Активная", 3F, 3F)
    val scottish = Scottish("Пассивная", 5F, 6F)

    val petStore = PetStore()
    println(petStore.determine_pet(siamese.get_breed()))
    println(petStore.determine_pet(husky1.get_breed()))
    println(petStore.determine_pet(corgi2.get_breed()))
}