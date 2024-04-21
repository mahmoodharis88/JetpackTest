package com.example.composeapp.cache.model

import com.example.composeapp.domain.model.Employee
import com.example.composeapp.domain.util.DomainMapper

class EmployeeEntityMapper : DomainMapper<EmployeeEntity, Employee> {
    override fun mapToDomainModel(model: EmployeeEntity): Employee {
        return Employee(
            id = model.id,
            title = model.title,
            description = model.description,
            price = model.price,
            discountPercentage = model.discountPercentage,
            rating = model.rating,
            stock = model.stock,
            brand = model.brand,
            category = model.category,
            thumbnail = model.thumbnail,
            images = model.images,
            )
    }

    override fun mapFromDomainModel(domainModel: Employee): EmployeeEntity {
        return EmployeeEntity(
            id = domainModel.id,
            title = domainModel.title,
            description = domainModel.description,
            price = domainModel.price,
            discountPercentage = domainModel.discountPercentage,
            rating = domainModel.rating,
            stock = domainModel.stock,
            brand = domainModel.brand,
            category = domainModel.category,
            thumbnail = domainModel.thumbnail,
            images = domainModel.images,
        )
    }

    /**
     * "Carrot, potato, Chicken, ..."
     */
    private fun convertIngredientListToString(ingredients: List<String>): String {
        val ingredientsString = StringBuilder()
        for (ingredient in ingredients) {
            ingredientsString.append("$ingredient,")
        }
        return ingredientsString.toString()
    }

    private fun convertIngredientsToList(ingredientsString: String?): List<String> {
        val list: ArrayList<String> = ArrayList()
        ingredientsString?.let {
            for (ingredient in it.split(",")) {
                list.add(ingredient)
            }
        }
        return list
    }

    fun fromEntityList(initial: List<EmployeeEntity>): List<Employee> {
        return initial.map { mapToDomainModel(it) }
    }

    fun toEntityList(initial: List<Employee>): List<EmployeeEntity> {
        return initial.map { mapFromDomainModel(it) }
    }
}