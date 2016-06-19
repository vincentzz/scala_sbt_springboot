package me.vincentzz.demo.model

/**
  * Created by Vincent Zhang on 16-6-20.
  */
// private var without a public getter will not be serialized to JSON
class Animal (var name: String,private var age:Int)
