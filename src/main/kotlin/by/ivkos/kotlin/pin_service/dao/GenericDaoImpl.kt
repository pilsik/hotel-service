package by.ivkos.kotlin.pin_service.dao

import java.io.Serializable
import java.lang.reflect.ParameterizedType
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional


open class GenericDaoImpl<T, in PK : Serializable> : GenericDao<T, PK> {

    protected var entityClass: Class<T>

    @PersistenceContext
    lateinit protected var em: EntityManager

    init {
        val genericSuperClass = javaClass.genericSuperclass as ParameterizedType
        @Suppress("UNCHECKED_CAST")
        this.entityClass = genericSuperClass.actualTypeArguments[0] as Class<T>
    }


    @Transactional
    override fun add(t: T): T {
        this.em.persist(t)
        return t
    }

    override fun getById(id: PK): T {
        return this.em.find(entityClass, id)
    }

    @Transactional
    override fun removeById(id: PK): T {
        val t: T = this.em.find(entityClass,id)
        this.em.remove(t)
        return t
    }

    override fun removeEntity(entity: T) {
        this.em.remove(entity)
    }
}