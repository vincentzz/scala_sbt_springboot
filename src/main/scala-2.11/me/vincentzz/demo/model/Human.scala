package me.vincentzz.demo.model

/**
  * Example of Scala POJO
  * Created by Vincent Zhang on 16-6-19.
  */
// only field declared as var will be considered as
class Human(
           // for field which don't need extra logic in setter or getter
            var name: String,
           // for field need setter and getter
            private var age_ : Int,
            private var sex_ : Boolean) {

  /**
    * getters
    */
  def sex = sex_

  def age = age_

  /**
    * setters
    * ATTENTION: "age_=" is the function name
    * can be used by:
    *                 human.age = 5
    *             or:
    *                 human.age_=(5)
    */
  def age_= (value: Int) = {
    println("do something...")
    age_ = value
  }

  def sex_= (value: Boolean) = sex_ = value

}
