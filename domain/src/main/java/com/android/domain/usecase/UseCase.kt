package com.android.domain.usecase

/**
 * Created by hassanalizadeh on 19,October,2020
 */
abstract class UseCase<R, P> {

    operator fun invoke(param: P?): R {
        return if (param != null)
            execute(param)
        else throw IllegalArgumentException()
    }

    abstract fun execute(param: P?): R
}

operator fun <R> UseCase<R, Unit>.invoke(): R = this(Unit)