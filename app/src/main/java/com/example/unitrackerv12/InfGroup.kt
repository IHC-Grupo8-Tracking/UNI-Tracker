package com.example.unitrackerv12

class InfGroup {
    public var IDGroup = null

    public fun setIDGroup(ID : String?){
        IDGroup = ID as Nothing?
    }
    public fun getIDGroup(): String {
        if (IDGroup != null) {
            return IDGroup as Nothing
        }
        else{
            return "ihc"
        }

    }
}