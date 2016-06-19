package me.vincentzz.demo

import me.vincentzz.demo.model.Human
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}

/**
  * created by Vincentzz 2016.06.18
  */
@SpringBootApplication
@EnableAutoConfiguration
class HelloWorld

object HelloWorld {
  def main(args: Array[String]) {
    def func  = (x:Int, y: String) => x+y
    println(func(5, "123"))
    SpringApplication.run(classOf[HelloWorld], args: _*)
//    val h = new Human("zz", 27 , true)
//    println(h.age)
//    h.age = 2
//    println(h.age)

  }
}
