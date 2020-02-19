package kr.co.portfolio.dao

class PermissionModel {

    constructor(name : String, isGranted : Boolean){
        this.permissionName = name
        this.isGranted = isGranted
    }
    var permissionName : String = ""
    var isGranted : Boolean = false
}