package by.ivkos.kotlin.pin_service.dao

import java.io.Serializable

interface GenericDao<T,in  PK : Serializable> {

    fun add(t: T): T
    fun getById(id: PK): T
    fun removeById(id: PK): T
    fun removeEntity(entity: T)

}