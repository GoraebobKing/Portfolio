package kr.co.portfolio.util

/**
 * Created by jeongjaehwan on 2021/04/02
 **/
open class PermissionState {
    open fun granted() {}
    open fun rejected() {}
    open fun denied() {}
}