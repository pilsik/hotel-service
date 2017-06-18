package by.ivkos.kotlin.hotelService.dao

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
    override fun update(t: T): T {
        return this.em.merge(t)
    }

    @Transactional
    override fun remove(t: T): T {
        this.em.remove(t)
        return t
    }

    override fun getList(): List<T> {
        val cb = this.em.criteriaBuilder
        val cq = cb.createQuery(entityClass)
        val rootEntry = cq.from(entityClass)
        val all = cq.select(rootEntry)
        val allQuery = em.createQuery(all)
        return allQuery.resultList
    }

    @Transactional
    override fun removeById(id: PK): T {
        val t: T = this.em.find(entityClass,id)
        this.em.remove(t)
        return t
    }

}