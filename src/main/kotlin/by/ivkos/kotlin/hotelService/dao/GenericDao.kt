package by.ivkos.kotlin.hotelService.dao

import java.io.Serializable

interface GenericDao<T,in  PK : Serializable> {

    fun add(t: T): T
    fun getById(id: PK): T
    fun update(t: T): T
    fun remove(t: T): T
    fun getList(): List<T>
    fun removeById(id: PK): T

}